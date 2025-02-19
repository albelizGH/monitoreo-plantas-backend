package com.alejobeliz.projects.techforb.controller;

import com.alejobeliz.projects.techforb.dto.request.reading.UpdateReadingRequestDTO;
import com.alejobeliz.projects.techforb.dto.response.ReadingResponseDTO;
import com.alejobeliz.projects.techforb.entity.Reading;
import com.alejobeliz.projects.techforb.service.impl.ReadingServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/readings")
@Tag(name = "Lecturas", description = "Endpoints para la gestión de lecturas de sensores")
public class ReadingController {

    private final ReadingServiceImpl readingService;

    public ReadingController(ReadingServiceImpl readingService) {
        this.readingService = readingService;
    }

    @Operation(
            summary = "Obtener una lectura por ID",
            description = "Devuelve la información de una lectura específica basada en su ID."
    )
    @GetMapping("/{id}")
    public ResponseEntity<ReadingResponseDTO> getReadingById(@PathVariable Long id) {
        Optional<Reading> reading = readingService.getReadingById(id);
        if (reading.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        ReadingResponseDTO response = new ReadingResponseDTO(
                reading.get().getId(),
                reading.get().getName(),
                reading.get().getReadingsOk(),
                reading.get().getMediumAlerts(),
                reading.get().getRedAlerts(),
                reading.get().getDisabled()
        );
        return ResponseEntity.ok(response);
    }

    @Operation(
            summary = "Actualizar una lectura",
            description = "Modifica los datos de una lectura existente según su ID."
    )
    @PutMapping("/{id}")
    public ResponseEntity<ReadingResponseDTO> updateReading(
            @PathVariable Long id,
            @RequestBody @Valid UpdateReadingRequestDTO readingRequestDTO
    ) {
        ReadingResponseDTO updatedReading = readingService.updateReading(id, readingRequestDTO);
        return ResponseEntity.ok(updatedReading);
    }

    @Operation(
            summary = "Activar o desactivar un sensor",
            description = "Cambia el estado de activación de un sensor asociado a una lectura."
    )
    @PutMapping("/{id}/change-state")
    public ResponseEntity<Void> enableSensor(@PathVariable Long id) {
        readingService.changeEnabled(id);
        return ResponseEntity.noContent().build();
    }
}

