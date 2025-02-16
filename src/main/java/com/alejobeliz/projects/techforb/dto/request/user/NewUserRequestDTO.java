package com.alejobeliz.projects.techforb.dto.request.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record NewUserRequestDTO(
        @NotNull(message = "El nombre de usuario no puede estar vació")
        @Size(min = 3, max = 20, message = "El nombre de usuario debe tener entre 3 y 20 caracteres")
        String username,

        @NotNull(message = "El email no puede estar vació")
        @Email(message = "El email debe ser válido")
        String email,

        @NotNull(message = "La contraseña no puede estar vaciá")
        String password
) {
}
