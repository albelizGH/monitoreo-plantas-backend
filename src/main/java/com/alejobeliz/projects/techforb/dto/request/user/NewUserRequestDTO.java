package com.alejobeliz.projects.techforb.dto.request.user;

import jakarta.validation.constraints.*;

public record NewUserRequestDTO(
        @NotNull(message = "El nombre de usuario no puede estar vació")
        @Size(min = 3, max = 20, message = "El nombre de usuario debe tener entre 3 y 20 caracteres")
        String username,

        @NotNull(message = "El email no puede estar vació")
        @Email(message = "El email debe ser válido")
        String email,

        @Pattern(regexp = "^(?=.*[@$!%*?&]).{8,}$", message = "La contraseña debe tener al menos 8 caracteres y contener al menos un carácter especial")
        @NotNull(message = "La contraseña no puede estar vaciá")
        String password
) {
}
