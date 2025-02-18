package com.alejobeliz.projects.techforb.service;

import com.alejobeliz.projects.techforb.dto.request.reading.UpdateReadingRequestDTO;
import com.alejobeliz.projects.techforb.dto.response.ReadingResponseDTO;
import com.alejobeliz.projects.techforb.entity.Reading;

import java.util.List;
import java.util.Optional;

public interface IReadingService {

    Optional<Reading> getReadingById(Long id);

    List<Reading> getAllReadings();

    ReadingResponseDTO updateReading(Long id, UpdateReadingRequestDTO readingRequestDTO);
    void changeEnabled(Long readingId);

}
