package com.alejobeliz.projects.techforb.dto.response;

public record GlobalResponseDTO(
        Integer readingsOk,
        Integer mediumAlerts,
        Integer redAlerts,
        Integer disabledSensors
) {
}
