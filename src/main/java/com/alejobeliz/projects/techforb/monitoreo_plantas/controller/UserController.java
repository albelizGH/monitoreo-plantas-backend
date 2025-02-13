package com.alejobeliz.projects.techforb.monitoreo_plantas.controller;

import com.alejobeliz.projects.techforb.monitoreo_plantas.dto.request.user.NewUserRequestDTO;
import com.alejobeliz.projects.techforb.monitoreo_plantas.dto.request.user.UpdateUserRequestDTO;
import com.alejobeliz.projects.techforb.monitoreo_plantas.dto.response.UserResponseDTO;
import com.alejobeliz.projects.techforb.monitoreo_plantas.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // Obtener todos los usuarios
    @GetMapping
    public ResponseEntity<List<UserResponseDTO>> getAllUsers() {
        List<UserResponseDTO> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }

    // Obtener un usuario por ID
    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDTO> getUserById(@PathVariable Long id) {
        UserResponseDTO user = userService.getUserById(id);
        return ResponseEntity.ok(user);
    }

    // Crear un nuevo usuario
    @PostMapping
    public ResponseEntity<UserResponseDTO> createUser(@RequestBody @Valid NewUserRequestDTO userRequestDTO) {
        UserResponseDTO user = userService.createUser(userRequestDTO);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    // Actualizar un usuario
    @PutMapping("/{id}")
    public ResponseEntity<UserResponseDTO> updateUser(@PathVariable Long id, @RequestBody @Valid UpdateUserRequestDTO userRequestDTO) {
        UserResponseDTO updatedUser = userService.updateUser(id, userRequestDTO);
        return ResponseEntity.ok(updatedUser);
    }

    // Eliminar un usuario
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}
