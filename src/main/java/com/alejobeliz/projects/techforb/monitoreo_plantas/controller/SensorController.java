package com.alejobeliz.projects.techforb.monitoreo_plantas.controller;


import com.alejobeliz.projects.techforb.monitoreo_plantas.dto.request.sensor.NewSensorRequestDTO;
import com.alejobeliz.projects.techforb.monitoreo_plantas.dto.request.sensor.UpdateSensorRequestDTO;
import com.alejobeliz.projects.techforb.monitoreo_plantas.dto.response.SensorResponseDTO;
import com.alejobeliz.projects.techforb.monitoreo_plantas.service.SensorService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sensors")
public class SensorController {

    private final SensorService sensorService;

    public SensorController(SensorService sensorService) {
        this.sensorService = sensorService;
    }

    // Obtener todos los sensores
    @GetMapping
    public ResponseEntity<List<SensorResponseDTO>> getAllSensors() {
        List<SensorResponseDTO> sensors = sensorService.getAllSensors();
        return ResponseEntity.ok(sensors);
    }

    // Obtener un sensor por ID
    @GetMapping("/{id}")
    public ResponseEntity<SensorResponseDTO> getSensorById(@PathVariable Long id) {
        SensorResponseDTO sensor = sensorService.getSensorById(id);
        return ResponseEntity.ok(sensor);
    }

    // Crear un nuevo sensor
    @PostMapping
    public ResponseEntity<SensorResponseDTO> createSensor(@RequestBody @Valid NewSensorRequestDTO sensorRequestDTO) {
        SensorResponseDTO sensor = sensorService.createSensor(sensorRequestDTO);
        return new ResponseEntity<>(sensor, HttpStatus.CREATED);
    }

    // Actualizar un sensor
    @PutMapping("/{id}")
    public ResponseEntity<SensorResponseDTO> updateSensor(@PathVariable Long id, @RequestBody @Valid UpdateSensorRequestDTO sensorRequestDTO) {
        SensorResponseDTO updatedSensor = sensorService.updateSensor(id, sensorRequestDTO);
        return ResponseEntity.ok(updatedSensor);
    }

    // Eliminar un sensor
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSensor(@PathVariable Long id) {
        sensorService.deleteSensor(id);
        return ResponseEntity.noContent().build();
    }

}