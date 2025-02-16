package com.alejobeliz.projects.techforb.dto.request.sensor;

import jakarta.validation.constraints.NotNull;

public record UpdateSensorRequestDTO(
        @NotNull(message = "El id no puede estar vació")
        Long id,

        String name
) {
}
