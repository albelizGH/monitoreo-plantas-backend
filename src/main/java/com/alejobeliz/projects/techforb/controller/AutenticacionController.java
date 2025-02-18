package com.alejobeliz.projects.techforb.controller;

import com.alejobeliz.projects.techforb.dto.request.user.NewUserRequestDTO;
import com.alejobeliz.projects.techforb.dto.response.UserResponseDTO;
import com.alejobeliz.projects.techforb.security.AuthenticationService;
import com.alejobeliz.projects.techforb.security.LoginDTO;
import com.alejobeliz.projects.techforb.security.WebToken;
import com.alejobeliz.projects.techforb.service.impl.UserServiceImpl;
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
public class AutenticacionController {


    private UserServiceImpl userService;
    private AuthenticationService authenticationService;

    @Autowired
    public AutenticacionController(UserServiceImpl clienteService, AuthenticationService authenticationService) {
        this.userService = clienteService;
        this.authenticationService = authenticationService;
    }

    @PostMapping("register")
    public ResponseEntity<UserResponseDTO> registrarCliente(@RequestBody @Valid NewUserRequestDTO newUserRequestDTO) {
        UserResponseDTO user = userService.createUser(newUserRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }

    @PostMapping("login")
    public ResponseEntity autenticarUsuario(@RequestBody @Valid LoginDTO data) {
        WebToken token = authenticationService.autenticarLogin(data);
        return ResponseEntity.ok(token);
    }


}

