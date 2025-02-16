package com.alejobeliz.projects.techforb.service.impl;

import com.alejobeliz.projects.techforb.entity.Reading;
import com.alejobeliz.projects.techforb.repository.ReadingRepository;
import com.alejobeliz.projects.techforb.service.IReadingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReadingServiceImpl implements IReadingService {

    private final ReadingRepository readingRepository;

    @Autowired
    public ReadingServiceImpl(ReadingRepository readingRepository) {
        this.readingRepository = readingRepository;
    }

    @Override
    public Reading createReading(Reading reading) {
        return readingRepository.save(reading);
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
    public Reading updateReading(Long id, Reading reading) {
        if (!readingRepository.existsById(id)) {
            return null;
        }
        reading.setId(id);
        return readingRepository.save(reading);
    }

    @Override
    public void deleteReading(Long id) {
        readingRepository.deleteById(id);
    }
}
