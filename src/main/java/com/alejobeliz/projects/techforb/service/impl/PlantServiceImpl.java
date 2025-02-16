package com.alejobeliz.projects.techforb.service.impl;

import com.alejobeliz.projects.techforb.entity.Plant;
import com.alejobeliz.projects.techforb.repository.PlantRepository;
import com.alejobeliz.projects.techforb.service.IPlantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlantServiceImpl implements IPlantService {

    private final PlantRepository plantRepository;

    @Autowired
    public PlantServiceImpl(PlantRepository plantRepository) {
        this.plantRepository = plantRepository;
    }

    @Override
    public Plant createPlant(Plant plant) {
        return plantRepository.save(plant);
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
    public Plant updatePlant(Long id, Plant plant) {
        if (!plantRepository.existsById(id)) {
            return null;
        }
        plant.setId(id);
        return plantRepository.save(plant);
    }

    @Override
    public void deletePlant(Long id) {
        plantRepository.deleteById(id);
    }
}
