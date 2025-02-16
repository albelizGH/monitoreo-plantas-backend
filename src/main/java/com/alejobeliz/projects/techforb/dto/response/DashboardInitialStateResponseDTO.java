package com.alejobeliz.projects.techforb.dto.response;

import java.util.List;

public record DashboardInitialStateResponseDTO(
        UserResponseDTO user,
        List<TableResponseDTO> table,
        GlobalResponseDTO global
) {}
