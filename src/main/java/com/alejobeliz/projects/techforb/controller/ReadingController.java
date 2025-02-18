package com.alejobeliz.projects.techforb.controller;

import com.alejobeliz.projects.techforb.dto.request.reading.UpdateReadingRequestDTO;
import com.alejobeliz.projects.techforb.dto.response.ReadingResponseDTO;
import com.alejobeliz.projects.techforb.entity.Reading;
import com.alejobeliz.projects.techforb.service.impl.ReadingServiceImpl;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/readings")
public class ReadingController {

    private final ReadingServiceImpl readingService;

    public ReadingController(ReadingServiceImpl readingService) {
        this.readingService = readingService;
    }

    // Obtener lectura por ID
    @GetMapping("/{id}")
    public ResponseEntity<ReadingResponseDTO> getReadingById(@PathVariable Long id) {
        Optional<Reading> reading = readingService.getReadingById(id);
        ReadingResponseDTO response = new ReadingResponseDTO(reading.get().getId(),reading.get().getName(), reading.get().getReadingsOk(),reading.get().getMediumAlerts(),reading.get().getRedAlerts(),reading.get().getDisabled());
        return ResponseEntity.ok(response);
    }

    // Actualizar una lectura
    @PutMapping("/{id}")
    public ResponseEntity<ReadingResponseDTO> updateReading(@PathVariable Long id, @RequestBody @Valid UpdateReadingRequestDTO readingRequestDTO) {
        ReadingResponseDTO updatedReading = readingService.updateReading(id, readingRequestDTO);
        return ResponseEntity.ok(updatedReading);
    }

    // Activar un sensor de una planta
    @PutMapping("/{id}/change-state")
    public ResponseEntity<Void> enableSensor(@PathVariable Long id) {
        readingService.changeEnabled(id);
        return ResponseEntity.noContent().build();
    }




}
