package com.alejobeliz.projects.techforb.dto.response;

public record ReadingResponseDTO(
        Long id,
        Integer readingsOk,
        Integer mediumAlerts,
        Integer redAlerts
) {
}
