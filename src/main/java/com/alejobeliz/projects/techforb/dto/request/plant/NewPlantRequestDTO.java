package com.alejobeliz.projects.techforb.dto.request.plant;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record NewPlantRequestDTO(
        @NotBlank(message = "El nombre no puede estar vacío")
        @Size(min = 1, max = 20, message = "El nombre debe tener entre 1 y 20 caracteres")
        String name,

        @NotBlank(message = "El país no puede estar vacío")
        String country,

        @NotBlank(message = "La url no puede estar vacía")
        String imageUrl
) {
}
