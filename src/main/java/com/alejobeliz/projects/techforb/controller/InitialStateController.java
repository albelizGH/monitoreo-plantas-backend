package com.alejobeliz.projects.techforb.controller;

import com.alejobeliz.projects.techforb.dto.response.DashboardInitialStateResponseDTO;
import com.alejobeliz.projects.techforb.service.impl.InitialStateServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/initial-state")
public class InitialStateController {

    private final InitialStateServiceImpl initialStateService;

    @Autowired
    public InitialStateController(InitialStateServiceImpl initialStateService) {
        this.initialStateService = initialStateService;
    }

    // Obtener el estado inicial
    @GetMapping
    public ResponseEntity<DashboardInitialStateResponseDTO> getInitialState(@RequestParam Long id) {
        DashboardInitialStateResponseDTO state = initialStateService.getInitialState(id);
        return ResponseEntity.ok(state);
    }
}
