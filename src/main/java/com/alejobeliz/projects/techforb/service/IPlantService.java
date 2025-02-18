package com.alejobeliz.projects.techforb.service;

import com.alejobeliz.projects.techforb.dto.request.plant.NewPlantRequestDTO;
import com.alejobeliz.projects.techforb.dto.response.PlantResponseDTO;
import com.alejobeliz.projects.techforb.dto.response.ReadingResponseDTO;
import com.alejobeliz.projects.techforb.entity.Plant;

import java.util.List;
import java.util.Optional;

public interface IPlantService {

    PlantResponseDTO createPlant(NewPlantRequestDTO plantRequestDTO);

    Optional<Plant> getPlantById(Long id);

    List<Plant> getAllPlants();

    PlantResponseDTO updatePlant(Long id, NewPlantRequestDTO plant);

    void deletePlant(Long id);

    List<ReadingResponseDTO> getPlantReadings(Long id);
}
