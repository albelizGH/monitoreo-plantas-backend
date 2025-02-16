package com.alejobeliz.projects.techforb.service;

import com.alejobeliz.projects.techforb.entity.Plant;

import java.util.List;
import java.util.Optional;

public interface IPlantService {

    Plant createPlant(Plant plant);

    Optional<Plant> getPlantById(Long id);

    List<Plant> getAllPlants();

    Plant updatePlant(Long id, Plant plant);

    void deletePlant(Long id);
}
