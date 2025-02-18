package com.alejobeliz.projects.techforb.dto.request.reading;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public record NewReadingRequestDTO(
        @NotNull(message = "Las lecturas no pueden ser nulas")
        @Min(value = 1, message = "Debe haber al menos una lectura")
        Integer readingsOk,

        @NotNull(message = "Las alertas medias no pueden ser nulas")
        @Min(value = 1, message = "Debe haber al menos una alerta media")
        Integer mediumAlerts,

        @NotNull(message = "Las alertas rojas no pueden ser nulas")
        @Min(value = 1, message = "Debe haber al menos una alerta roja")
        Integer redAlerts,

        @NotNull(message = "El id de la planta no puede ser nulo")
        Long idPlant

) {
}
