package com.alejobeliz.projects.techforb.monitoreo_plantas.service;

import com.alejobeliz.projects.techforb.monitoreo_plantas.dto.request.plant.NewPlantRequestDTO;
import com.alejobeliz.projects.techforb.monitoreo_plantas.dto.request.plant.UpdatePlantRequestDTO;
import com.alejobeliz.projects.techforb.monitoreo_plantas.dto.response.PlantResponseDTO;
import com.alejobeliz.projects.techforb.monitoreo_plantas.model.PlantSensorReading;
import com.alejobeliz.projects.techforb.monitoreo_plantas.repository.PlantSensorReadingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlantService {

    private final PlantSensorReadingRepository plantSensorReadingRepository;

    @Autowired
    public PlantService(PlantSensorReadingRepository plantSensorReadingRepository) {
        this.plantSensorReadingRepository = plantSensorReadingRepository;
    }

    public List<PlantResponseDTO> getAllPlants() {
        return null;
    }

    public PlantResponseDTO getPlantById(Long id) {
        return null;
    }

    public PlantResponseDTO createPlant(NewPlantRequestDTO plantRequestDTO) {
        return null;
    }

    public PlantResponseDTO updatePlant(Long id, UpdatePlantRequestDTO plantRequestDTO) {
        return null;
    }

    public void deletePlant(Long id) {

    }

    public void changeEnabled(Long plantId, Long sensorId) {
        PlantSensorReading plantSensorReading = plantSensorReadingRepository.findByPlantIdAndSensorId(plantId, sensorId)
                .orElseThrow(() -> new RuntimeException("No se encontró la relación entre la planta y el sensor."));

        if(plantSensorReading.getEnabled()) {
            plantSensorReading.setEnabled(false);
            plantSensorReadingRepository.save(plantSensorReading);
        }else{
            plantSensorReading.setEnabled(true);
            plantSensorReadingRepository.save(plantSensorReading);
        }
    }
}
