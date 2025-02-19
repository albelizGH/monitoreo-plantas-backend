package com.alejobeliz.projects.techforb.controller;

import com.alejobeliz.projects.techforb.dto.request.user.NewUserRequestDTO;
import com.alejobeliz.projects.techforb.dto.response.UserResponseDTO;
import com.alejobeliz.projects.techforb.config.security.AuthenticationService;
import com.alejobeliz.projects.techforb.config.security.LoginDTO;
import com.alejobeliz.projects.techforb.config.security.WebToken;
import com.alejobeliz.projects.techforb.service.impl.UserServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@Tag(name = "Autenticación", description = "Endpoints para la autenticación de usuarios")
public class AutenticacionController {

    private final UserServiceImpl userService;
    private final AuthenticationService authenticationService;

    @Autowired
    public AutenticacionController(UserServiceImpl userService, AuthenticationService authenticationService) {
        this.userService = userService;
        this.authenticationService = authenticationService;
    }

    @Operation(summary = "Registrar un nuevo usuario", description = "Crea una nueva cuenta de usuario en el sistema.")
    @PostMapping("/register")
    public ResponseEntity<UserResponseDTO> registrarCliente(@RequestBody @Valid NewUserRequestDTO newUserRequestDTO) {
        UserResponseDTO user = userService.createUser(newUserRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }

    @Operation(summary = "Autenticar usuario", description = "Permite a un usuario iniciar sesión y obtener un token JWT.")
    @PostMapping("/login")
    public ResponseEntity<WebToken> autenticarUsuario(@RequestBody @Valid LoginDTO data) {
        WebToken token = authenticationService.autenticarLogin(data);
        return ResponseEntity.ok(token);
    }
}
