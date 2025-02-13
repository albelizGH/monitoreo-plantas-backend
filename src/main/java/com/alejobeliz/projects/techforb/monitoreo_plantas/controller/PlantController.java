package com.alejobeliz.projects.techforb.monitoreo_plantas.controller;

import com.alejobeliz.projects.techforb.monitoreo_plantas.dto.request.plant.NewPlantRequestDTO;
import com.alejobeliz.projects.techforb.monitoreo_plantas.dto.request.plant.UpdatePlantRequestDTO;
import com.alejobeliz.projects.techforb.monitoreo_plantas.dto.response.PlantResponseDTO;
import com.alejobeliz.projects.techforb.monitoreo_plantas.service.PlantService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/plants")
public class PlantController {

    private final PlantService plantService;

    @Autowired
    public PlantController(PlantService plantService) {
        this.plantService = plantService;
    }

    // Obtener todas las plantas
    @GetMapping
    public ResponseEntity<List<PlantResponseDTO>> getAllPlants() {
        List<PlantResponseDTO> plants = plantService.getAllPlants();
        return ResponseEntity.ok(plants);
    }

    // Obtener una planta por ID
    @GetMapping("/{id}")
    public ResponseEntity<PlantResponseDTO> getPlantById(@PathVariable Long id) {
        PlantResponseDTO plant = plantService.getPlantById(id);
        return ResponseEntity.ok(plant);
    }

    // Crear una nueva planta
    @PostMapping
    public ResponseEntity<PlantResponseDTO> createPlant(@RequestBody @Valid NewPlantRequestDTO plantRequestDTO) {
        PlantResponseDTO plant = plantService.createPlant(plantRequestDTO);
        return new ResponseEntity<>(plant, HttpStatus.CREATED);
    }

    // Actualizar una planta
    @PutMapping("/{id}")
    public ResponseEntity<PlantResponseDTO> updatePlant(@PathVariable Long id, @RequestBody @Valid UpdatePlantRequestDTO plantRequestDTO) {
        PlantResponseDTO updatedPlant = plantService.updatePlant(id, plantRequestDTO);
        return ResponseEntity.ok(updatedPlant);
    }

    // Eliminar una planta
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePlant(@PathVariable Long id) {
        plantService.deletePlant(id);
        return ResponseEntity.noContent().build();
    }

    // Desactivar un sensor de una planta
    @PutMapping("/{plantId}/sensors/{sensorId}/disable")
    public ResponseEntity<Void> disableSensor(@PathVariable Long plantId, @PathVariable Long sensorId) {
        plantService.changeEnabled(plantId, sensorId);
        return ResponseEntity.noContent().build();
    }

    // Activar un sensor de una planta
    @PutMapping("/{plantId}/sensors/{sensorId}/enable")
    public ResponseEntity<Void> enableSensor(@PathVariable Long plantId, @PathVariable Long sensorId) {
        plantService.changeEnabled(plantId, sensorId);
        return ResponseEntity.noContent().build();
    }
}