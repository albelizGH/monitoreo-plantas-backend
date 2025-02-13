package com.alejobeliz.projects.techforb.monitoreo_plantas.dto.request.reading;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record UpdateReadingRequestDTO(
        @NotNull(message = "El id no puede ser nulo")
        Long id,

        @Size(min = 1, message = "Debe haber al menos una lectura")
        Integer readingsOk,

        @Size(min = 1, message = "Debe haber al menos una alerta media")
        Integer mediumAlerts,

        @Size(min = 1, message = "Debe haber al menos una alerta roja")
        Integer redAlerts,

        Boolean enabled
) {
}
