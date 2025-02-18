package com.alejobeliz.projects.techforb.controller;

import com.alejobeliz.projects.techforb.dto.request.plant.NewPlantRequestDTO;
import com.alejobeliz.projects.techforb.dto.response.PlantResponseDTO;
import com.alejobeliz.projects.techforb.dto.response.ReadingResponseDTO;
import com.alejobeliz.projects.techforb.entity.Plant;
import com.alejobeliz.projects.techforb.service.impl.PlantServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/plants")
public class PlantController {

    private final PlantServiceImpl plantService;

    public PlantController(PlantServiceImpl plantService) {
        this.plantService = plantService;
    }

    // Obtener planta por ID
    @GetMapping("/{id}")
    public ResponseEntity<PlantResponseDTO> getPlantById(@PathVariable Long id) {
        Plant plant = plantService.getPlantById(id).orElseThrow(() -> new RuntimeException("No se encontró la planta con ID: " + id));
        PlantResponseDTO responseDTO = new PlantResponseDTO(plant.getId(), plant.getName(), new PlantResponseDTO.CountryResponseDTO(plant.getCountry().getName(), plant.getCountry().getImageUrl()));
        return ResponseEntity.ok(responseDTO);
    }

    // Crear nueva planta
    @PostMapping
    public ResponseEntity<PlantResponseDTO> createPlant(@RequestBody NewPlantRequestDTO plantRequestDTO) {
        PlantResponseDTO createdPlant = plantService.createPlant(plantRequestDTO);
        return ResponseEntity.status(201).body(createdPlant);
    }

    // Actualizar planta
    @PutMapping("/{id}")
    public ResponseEntity<PlantResponseDTO> updatePlant(@PathVariable Long id, @RequestBody NewPlantRequestDTO plantRequestDTO) {
        PlantResponseDTO updatedPlant = plantService.updatePlant(id, plantRequestDTO);
        return ResponseEntity.ok(updatedPlant);
    }

    // Eliminar planta
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePlant(@PathVariable Long id) {
        plantService.deletePlant(id);
        return ResponseEntity.noContent().build();
    }

    // Obtener todas las lecturas de una planta
    @GetMapping("/{id}/readings")
    public ResponseEntity<List<ReadingResponseDTO>> getPlantReadings(@PathVariable Long id) {
        List<ReadingResponseDTO> responseDTO = plantService.getPlantReadings(id);
        return ResponseEntity.ok(responseDTO);
    }
}