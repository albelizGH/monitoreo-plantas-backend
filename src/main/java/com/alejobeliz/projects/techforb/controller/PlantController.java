package com.alejobeliz.projects.techforb.controller;

import com.alejobeliz.projects.techforb.dto.request.plant.NewPlantRequestDTO;
import com.alejobeliz.projects.techforb.dto.response.PlantResponseDTO;
import com.alejobeliz.projects.techforb.dto.response.ReadingResponseDTO;
import com.alejobeliz.projects.techforb.entity.Plant;
import com.alejobeliz.projects.techforb.service.impl.PlantServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/plants")
@Tag(name = "Plantas", description = "Endpoints para la gestión de plantas y sus lecturas")
public class PlantController {

    private final PlantServiceImpl plantService;

    public PlantController(PlantServiceImpl plantService) {
        this.plantService = plantService;
    }

    @Operation(
            summary = "Obtener planta por ID",
            description = "Devuelve la información de una planta específica basada en su ID."
    )
    @GetMapping("/{id}")
    public ResponseEntity<PlantResponseDTO> getPlantById(@PathVariable Long id) {
        Plant plant = plantService.getPlantById(id).orElseThrow(() -> new RuntimeException("No se encontró la planta con ID: " + id));
        PlantResponseDTO responseDTO = new PlantResponseDTO(plant.getId(), plant.getName(), new PlantResponseDTO.CountryResponseDTO(plant.getCountry().getName(), plant.getCountry().getImageUrl()));
        return ResponseEntity.ok(responseDTO);
    }

    @Operation(
            summary = "Crear una nueva planta",
            description = "Registra una nueva planta en el sistema."
    )
    @PostMapping
    public ResponseEntity<PlantResponseDTO> createPlant(@RequestBody NewPlantRequestDTO plantRequestDTO) {
        PlantResponseDTO createdPlant = plantService.createPlant(plantRequestDTO);
        return ResponseEntity.status(201).body(createdPlant);
    }

    @Operation(
            summary = "Actualizar una planta",
            description = "Modifica los datos de una planta existente según su ID."
    )
    @PutMapping("/{id}")
    public ResponseEntity<PlantResponseDTO> updatePlant(@PathVariable Long id, @RequestBody NewPlantRequestDTO plantRequestDTO) {
        PlantResponseDTO updatedPlant = plantService.updatePlant(id, plantRequestDTO);
        return ResponseEntity.ok(updatedPlant);
    }

    @Operation(
            summary = "Eliminar una planta",
            description = "Elimina una planta del sistema según su ID."
    )
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePlant(@PathVariable Long id) {
        plantService.deletePlant(id);
        return ResponseEntity.noContent().build();
    }

    @Operation(
            summary = "Obtener lecturas de una planta",
            description = "Devuelve todas las lecturas asociadas a una planta específica."
    )
    @GetMapping("/{id}/readings")
    public ResponseEntity<List<ReadingResponseDTO>> getPlantReadings(@PathVariable Long id) {
        List<ReadingResponseDTO> responseDTO = plantService.getPlantReadings(id);
        return ResponseEntity.ok(responseDTO);
    }
}
