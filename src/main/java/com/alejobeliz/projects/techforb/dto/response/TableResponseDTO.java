package com.alejobeliz.projects.techforb.dto.response;

public record TableResponseDTO(
        Long id,
        String name,
        PlantResponseDTO.CountryResponseDTO country,
        Long readingsOk,
        Long mediumAlerts,
        Long redAlerts,
        Long disabledSensors
) {

}
