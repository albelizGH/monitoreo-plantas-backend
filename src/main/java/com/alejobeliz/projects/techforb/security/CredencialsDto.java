package com.alejobeliz.projects.techforb.security;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record CredencialsDto(
        @Email
        String email,
        @NotBlank(message = "La contraseña es requerida.")
        @Size(min = 8, message = "La contraseña debe tener al menos 8 caracteres.")
        @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$",
                message = "La contraseña debe incluir una letra mayúscula, una letra minúscula, un número y un carácter especial.")
        String password

        ) {

}
