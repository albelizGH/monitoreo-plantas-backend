package com.alejobeliz.projects.techforb.monitoreo_plantas.service;

import com.alejobeliz.projects.techforb.monitoreo_plantas.dto.request.sensor.NewSensorRequestDTO;
import com.alejobeliz.projects.techforb.monitoreo_plantas.dto.request.sensor.UpdateSensorRequestDTO;
import com.alejobeliz.projects.techforb.monitoreo_plantas.dto.response.SensorResponseDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SensorService {
    public void deleteSensor(Long id) {

    }

    public SensorResponseDTO updateSensor(Long id, UpdateSensorRequestDTO sensorRequestDTO) {
        return null;
    }

    public SensorResponseDTO createSensor(NewSensorRequestDTO sensorRequestDTO) {
        return null;
    }

    public List<SensorResponseDTO> getAllSensors() {
        return null;
    }

    public SensorResponseDTO getSensorById(Long id) {
        return null;
    }

}
