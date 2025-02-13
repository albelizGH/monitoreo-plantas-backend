package com.alejobeliz.projects.techforb.monitoreo_plantas.dto.request.reading;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record NewReadingRequestDTO(
        @NotNull(message = "Las lecturas no pueden ser nulas")
        @Size(min = 1, message = "Debe haber al menos una lectura")
        Integer readingsOk,

        @NotNull(message = "Las alertas medias no pueden ser nulas")
        @Size(min = 1, message = "Debe haber al menos una alerta media")
        Integer mediumAlerts,

        @NotNull(message = "Las alertas rojas no pueden ser nulas")
        @Size(min = 1, message = "Debe haber al menos una alerta roja")
        Integer redAlerts,

        @NotNull(message = "El id de la planta no puede ser nulo")
        Long idPlant,

        @NotNull(message = "El id del sensor no puede ser nulo")
        Long idSensor
) {
}
