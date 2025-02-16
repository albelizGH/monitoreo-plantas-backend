package com.alejobeliz.projects.techforb.dto.request.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record UpdateUserRequestDTO(

        @NotNull(message = "El id no puede estar vació")
        Long id,

        @Size(min = 3, max = 20, message = "El nombre de usuario debe tener entre 3 y 20 caracteres")
        String username,

        @Email(message = "El email debe ser válido")
        String email,

        String password
) {
}
