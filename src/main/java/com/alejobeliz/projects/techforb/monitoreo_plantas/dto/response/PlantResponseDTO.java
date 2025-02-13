package com.alejobeliz.projects.techforb.monitoreo_plantas.dto.response;

public record PlantResponseDTO(
        Long id,
        String name,
        CountryResponseDTO  country
) {
}

record CountryResponseDTO (
        String name,
        String imageUrl

) {
}
