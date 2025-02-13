package com.alejobeliz.projects.techforb.monitoreo_plantas.dto.response;

public record ReadingResponseDTO(
        Long id,
        Integer readingsOk,
        Integer mediumAlerts,
        Integer redAlerts
) {
}
