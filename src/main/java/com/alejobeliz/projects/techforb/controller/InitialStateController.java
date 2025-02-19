package com.alejobeliz.projects.techforb.controller;

import com.alejobeliz.projects.techforb.dto.response.DashboardInitialStateResponseDTO;
import com.alejobeliz.projects.techforb.security.SecurityContextService;
import com.alejobeliz.projects.techforb.service.impl.InitialStateServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/initial-state")
@Tag(name = "Estado Inicial", description = "Endpoints para obtener el estado inicial del dashboard")
public class InitialStateController {

    private final InitialStateServiceImpl initialStateService;
    private final SecurityContextService securityContextService;

    @Autowired
    public InitialStateController(InitialStateServiceImpl initialStateService, SecurityContextService securityContextService) {
        this.initialStateService = initialStateService;
        this.securityContextService = securityContextService;
    }

    @Operation(
            summary = "Obtener el estado inicial del dashboard",
            description = "Recupera la información inicial del dashboard basada en el usuario autenticado."
    )
    @GetMapping
    public ResponseEntity<DashboardInitialStateResponseDTO> getInitialState() {
        Long id = securityContextService.getIdDeUsuarioDesdeAuthenticated();
        DashboardInitialStateResponseDTO state = initialStateService.getInitialState(id);
        return ResponseEntity.ok(state);
    }
}
