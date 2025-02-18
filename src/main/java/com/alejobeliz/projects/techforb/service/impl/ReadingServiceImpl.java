package com.alejobeliz.projects.techforb.service.impl;

import com.alejobeliz.projects.techforb.dto.request.reading.UpdateReadingRequestDTO;
import com.alejobeliz.projects.techforb.dto.response.ReadingResponseDTO;
import com.alejobeliz.projects.techforb.entity.Reading;
import com.alejobeliz.projects.techforb.repository.PlantRepository;
import com.alejobeliz.projects.techforb.repository.ReadingRepository;
import com.alejobeliz.projects.techforb.service.IReadingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReadingServiceImpl implements IReadingService {

    private final ReadingRepository readingRepository;
    private final PlantRepository plantRepository;

    @Autowired
    public ReadingServiceImpl(ReadingRepository readingRepository, PlantRepository plantRepository) {
        this.readingRepository = readingRepository;
        this.plantRepository = plantRepository;
    }

    public void changeEnabled(Long readingId) {
        Reading reading = readingRepository.findById(readingId)
                .orElseThrow(() -> new RuntimeException("Lectura no encontrada"));

        if (reading.getDisabled()) {
            reading.setDisabled(false);
            this.readingRepository.save(reading);
        } else {
            reading.setDisabled(true);
            this.readingRepository.save(reading);
        }
    }

    @Override
    public Optional<Reading> getReadingById(Long id) {
        return readingRepository.findById(id);
    }

    @Override
    public List<Reading> getAllReadings() {
        return readingRepository.findAll();
    }

    @Override
    public ReadingResponseDTO updateReading(Long id, UpdateReadingRequestDTO readingRequestDTO) {
        Reading reading = readingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Lectura no encontrada"));
        reading.updateReadding(readingRequestDTO);
        readingRepository.save(reading);
        return new ReadingResponseDTO(
                reading.getId(),
                reading.getName(),
                reading.getReadingsOk(),
                reading.getMediumAlerts(),
                reading.getRedAlerts(),
                reading.getDisabled()
        );
    }

}
