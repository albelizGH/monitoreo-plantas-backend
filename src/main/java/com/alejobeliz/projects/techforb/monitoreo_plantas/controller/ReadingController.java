package com.alejobeliz.projects.techforb.monitoreo_plantas.controller;

import com.alejobeliz.projects.techforb.monitoreo_plantas.dto.request.reading.NewReadingRequestDTO;
import com.alejobeliz.projects.techforb.monitoreo_plantas.dto.request.reading.UpdateReadingRequestDTO;
import com.alejobeliz.projects.techforb.monitoreo_plantas.dto.response.ReadingResponseDTO;
import com.alejobeliz.projects.techforb.monitoreo_plantas.dto.response.SensorsWithReadingsDTO;
import com.alejobeliz.projects.techforb.monitoreo_plantas.service.ReadingService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/readings")
public class ReadingController {

    private final ReadingService readingService;

    public ReadingController(ReadingService readingService) {
        this.readingService = readingService;
    }

    // Obtener todas las lecturas
    @GetMapping
    public ResponseEntity<List<ReadingResponseDTO>> getAllReadings() {
        List<ReadingResponseDTO> readings = readingService.getAllReadings();
        return ResponseEntity.ok(readings);
    }

    // Obtener una lectura por ID
    @GetMapping("/{id}")
    public ResponseEntity<ReadingResponseDTO> getReadingById(@PathVariable Long id) {
        ReadingResponseDTO reading = readingService.getReadingById(id);
        return ResponseEntity.ok(reading);
    }

    // Crear una nueva lectura
    @PostMapping
    public ResponseEntity<ReadingResponseDTO> createReading(@RequestBody @Valid NewReadingRequestDTO readingRequestDTO) {
        ReadingResponseDTO reading = readingService.createReading(readingRequestDTO);
        return new ResponseEntity<>(reading, HttpStatus.CREATED);
    }

    // Actualizar una lectura
    @PutMapping("/{id}")
    public ResponseEntity<ReadingResponseDTO> updateReading(@PathVariable Long id, @RequestBody @Valid UpdateReadingRequestDTO readingRequestDTO) {
        ReadingResponseDTO updatedReading = readingService.updateReading(id, readingRequestDTO);
        return ResponseEntity.ok(updatedReading);
    }

    // Eliminar una lectura
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReading(@PathVariable Long id) {
        readingService.deleteReading(id);
        return ResponseEntity.noContent().build();
    }

    // Obtener todas las lecturas de todos los sensores de una planta
    @GetMapping("/plant/{plantId}")
    public ResponseEntity<List<SensorsWithReadingsDTO>> getAllReadingsForPlant(@PathVariable Long plantId) {
        List<SensorsWithReadingsDTO> readings = readingService.getAllReadingsForPlant(plantId);
        return ResponseEntity.ok(readings);
    }


}