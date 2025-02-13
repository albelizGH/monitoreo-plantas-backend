package com.alejobeliz.projects.techforb.monitoreo_plantas.dto.request.sensor;

import jakarta.validation.constraints.NotNull;

public record NewSensorRequestDTO(
        @NotNull(message = "El nombre no puede estar vació")
        String name
) {
}
