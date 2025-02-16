package com.alejobeliz.projects.techforb.dto.request.sensor;

import jakarta.validation.constraints.NotNull;

public record NewSensorRequestDTO(
        @NotNull(message = "El nombre no puede estar vació")
        String name
) {
}
