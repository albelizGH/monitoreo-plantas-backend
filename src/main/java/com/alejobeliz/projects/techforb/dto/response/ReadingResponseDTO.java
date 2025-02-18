package com.alejobeliz.projects.techforb.dto.response;

import com.alejobeliz.projects.techforb.entity.Name;

public record ReadingResponseDTO(
        Long id,
        Name name,
        Integer readingsOk,
        Integer mediumAlerts,
        Integer redAlerts,
        Boolean disabled
) {
}
