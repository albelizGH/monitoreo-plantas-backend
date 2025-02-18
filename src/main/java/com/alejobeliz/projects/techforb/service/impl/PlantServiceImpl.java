package com.alejobeliz.projects.techforb.service.impl;

import com.alejobeliz.projects.techforb.dto.request.plant.NewPlantRequestDTO;
import com.alejobeliz.projects.techforb.dto.response.PlantResponseDTO;
import com.alejobeliz.projects.techforb.dto.response.ReadingResponseDTO;
import com.alejobeliz.projects.techforb.entity.Country;
import com.alejobeliz.projects.techforb.entity.Name;
import com.alejobeliz.projects.techforb.entity.Plant;
import com.alejobeliz.projects.techforb.entity.Reading;
import com.alejobeliz.projects.techforb.repository.CountryRepository;
import com.alejobeliz.projects.techforb.repository.PlantRepository;
import com.alejobeliz.projects.techforb.repository.ReadingRepository;
import com.alejobeliz.projects.techforb.service.IPlantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PlantServiceImpl implements IPlantService {

    private final PlantRepository plantRepository;
    private final CountryRepository countryRepository;
    private final ReadingRepository readingRepository;

    @Autowired
    public PlantServiceImpl(PlantRepository plantRepository, CountryRepository countryRepository, ReadingRepository readingRepository) {
        this.plantRepository = plantRepository;
        this.countryRepository = countryRepository;
        this.readingRepository = readingRepository;
    }

    @Override
    public PlantResponseDTO createPlant(NewPlantRequestDTO plantRequestDTO) {
        // Buscar si el país ya existe para evitar duplicados
        Country country = countryRepository.findByName(plantRequestDTO.country())
                .orElseGet(() -> {
                    Country newCountry = new Country(null, plantRequestDTO.country(), plantRequestDTO.imageUrl());
                    return countryRepository.save(newCountry);
                });

        // Crear y guardar la planta
        Plant plant = new Plant(null, plantRequestDTO.name(), country);
        plant = plantRepository.save(plant); // Guardar antes de asignar las lecturas

        // Crear y asociar las lecturas
        List<Reading> readings = List.of(
                new Reading(null, plant, 0, 0, 0, false, Name.TEMPERATURA),
                new Reading(null, plant, 0, 0, 0, false, Name.PRESIÓN),
                new Reading(null, plant, 0, 0, 0, false, Name.VIENTO),
                new Reading(null, plant, 0, 0, 0, false, Name.NIVELES),
                new Reading(null, plant, 0, 0, 0, false, Name.ENERGÍA),
                new Reading(null, plant, 0, 0, 0, false, Name.TENSIÓN),
                new Reading(null, plant, 0, 0, 0, false, Name.MONÓXIDO_DE_CARBONO),
                new Reading(null, plant, 0, 0, 0, false, Name.OTROS_GASES)
        );

        readingRepository.saveAll(readings); // Guardar todas las lecturas

        // Retornar la respuesta con la información creada
        return new PlantResponseDTO(plant.getId(), plant.getName(),
                new PlantResponseDTO.CountryResponseDTO(country.getName(), country.getImageUrl()));
    }


    @Override
    public Optional<Plant> getPlantById(Long id) {
        return plantRepository.findById(id);
    }

    @Override
    public List<Plant> getAllPlants() {
        return plantRepository.findAll();
    }

    @Override
    public PlantResponseDTO updatePlant(Long id, NewPlantRequestDTO plant) {
        Plant plantToUpdate = plantRepository.findById(id).orElseThrow(() -> new RuntimeException("No se encontró la planta con ID: " + id));
        plantToUpdate.setName(plant.name());
        plantToUpdate.getCountry().setName(plant.country());
        plantToUpdate.getCountry().setImageUrl(plant.imageUrl());
        plantRepository.save(plantToUpdate);
        return new PlantResponseDTO(plantToUpdate.getId(), plantToUpdate.getName(), new PlantResponseDTO.CountryResponseDTO(plantToUpdate.getCountry().getName(), plantToUpdate.getCountry().getImageUrl()));
    }

    @Override
    public void deletePlant(Long id) {
        plantRepository.deleteById(id);
    }

    @Override
    public List<ReadingResponseDTO> getPlantReadings(Long id) {
        Plant plant = plantRepository.findById(id).orElseThrow(() -> new RuntimeException("No se encontró la planta con ID: " + id));
        return plant.getReadings().stream()
                .map(reading -> new ReadingResponseDTO(
                        reading.getId(),
                        reading.getName(),
                        reading.getReadingsOk(),
                        reading.getMediumAlerts(),
                        reading.getRedAlerts(),
                        reading.getDisabled()))
                .sorted(Comparator.comparingInt(reading -> reading.name().ordinal()))
                .collect(Collectors.toList());

    }
}
