package com.alejobeliz.projects.techforb.dto.request.plant;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record UpdatePlantRequestDTO(
        @NotNull(message = "El id no puede ser nulo")
        Long id,

        @Size(min = 1, max = 20, message = "El nombre debe tener entre 1 y 20 caracteres")
        String name,

        String country
) {
}
