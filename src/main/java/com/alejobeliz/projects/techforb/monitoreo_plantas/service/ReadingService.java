package com.alejobeliz.projects.techforb.monitoreo_plantas.service;

import com.alejobeliz.projects.techforb.monitoreo_plantas.dto.request.reading.NewReadingRequestDTO;
import com.alejobeliz.projects.techforb.monitoreo_plantas.dto.request.reading.UpdateReadingRequestDTO;
import com.alejobeliz.projects.techforb.monitoreo_plantas.dto.response.ReadingResponseDTO;
import com.alejobeliz.projects.techforb.monitoreo_plantas.dto.response.SensorResponseDTO;
import com.alejobeliz.projects.techforb.monitoreo_plantas.dto.response.SensorsWithReadingsDTO;
import com.alejobeliz.projects.techforb.monitoreo_plantas.model.PlantSensorReading;
import com.alejobeliz.projects.techforb.monitoreo_plantas.model.Reading;
import com.alejobeliz.projects.techforb.monitoreo_plantas.repository.PlantSensorReadingRepository;
import com.alejobeliz.projects.techforb.monitoreo_plantas.repository.ReadingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReadingService {

    private final PlantSensorReadingRepository plantSensorReadingRepository;
    private final ReadingRepository readingRepository;

    @Autowired
    public ReadingService(PlantSensorReadingRepository plantSensorReadingRepository, ReadingRepository readingRepository) {
        this.plantSensorReadingRepository = plantSensorReadingRepository;
        this.readingRepository = readingRepository;

    }


    public List<ReadingResponseDTO> getAllReadings() {
        return null;
    }

    public ReadingResponseDTO getReadingById(Long id) {
        return null;
    }

    public ReadingResponseDTO createReading(NewReadingRequestDTO readingRequestDTO) {
        return null;
    }

    public ReadingResponseDTO updateReading(Long id, UpdateReadingRequestDTO readingRequestDTO) {
        Reading reading = readingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Lectura no encontrada"));
        reading.updateReadding(readingRequestDTO);
        readingRepository.save(reading);
        return new ReadingResponseDTO(
                reading.getId(),
                reading.getReadingsOk(),
                reading.getMediumAlerts(),
                reading.getRedAlerts());
    }

    public void deleteReading(Long id) {
        Reading reading = readingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Lectura no encontrada"));
        readingRepository.delete(reading);
    }

    // Obtener todas las lecturas de todos los sensores de una planta
    public List<SensorsWithReadingsDTO> getAllReadingsForPlant(Long plantId) {
        List<PlantSensorReading> plantSensorReadings = plantSensorReadingRepository.findByPlantId(plantId);

        return plantSensorReadings.stream()
                .map(sensorWithreadings -> new SensorsWithReadingsDTO(
                        new SensorResponseDTO(
                                sensorWithreadings.getSensor().getId(),
                                sensorWithreadings.getSensor().getName()
                                ),
                        new ReadingResponseDTO(
                                sensorWithreadings.getReading().getId(),
                                sensorWithreadings.getReading().getReadingsOk(),
                                sensorWithreadings.getReading().getMediumAlerts(),
                                sensorWithreadings.getReading().getRedAlerts()
                        ),
                        sensorWithreadings.getEnabled()
                )).collect(Collectors.toList());
    }
}
