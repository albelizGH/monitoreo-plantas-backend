package com.alejobeliz.projects.techforb.service;

import com.alejobeliz.projects.techforb.entity.Reading;

import java.util.List;
import java.util.Optional;

public interface IReadingService {

    Reading createReading(Reading reading);

    Optional<Reading> getReadingById(Long id);

    List<Reading> getAllReadings();

    Reading updateReading(Long id, Reading reading);

    void deleteReading(Long id);
}
