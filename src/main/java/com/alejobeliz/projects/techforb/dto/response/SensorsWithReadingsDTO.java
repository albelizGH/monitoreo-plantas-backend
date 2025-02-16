package com.alejobeliz.projects.techforb.dto.response;

public record SensorsWithReadingsDTO(
        Long id,
        String name,
        ReadingResponseDTO readings,
        Boolean disabled
) {
}
