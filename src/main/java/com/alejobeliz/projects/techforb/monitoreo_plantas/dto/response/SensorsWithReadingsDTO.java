package com.alejobeliz.projects.techforb.monitoreo_plantas.dto.response;

import java.util.List;

public record SensorsWithReadingsDTO(
        SensorResponseDTO sensor,
        ReadingResponseDTO reading,
        Boolean enabled
) {
}
