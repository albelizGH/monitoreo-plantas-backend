package com.alejobeliz.projects.techforb.dto.request.reading;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public record UpdateReadingRequestDTO(
        @NotNull(message = "El id no puede ser nulo")
        Long id,

        @Min(message ="Debe haber al menos una lectura",value = 1)
        Integer readingsOk,

        @Min(message ="Debe haber al menos una alerta media",value = 1)
        Integer mediumAlerts,

        @Min(message ="Debe haber al menos una alerta roja",value = 1)
        Integer redAlerts,

        Boolean enabled
) {
}
