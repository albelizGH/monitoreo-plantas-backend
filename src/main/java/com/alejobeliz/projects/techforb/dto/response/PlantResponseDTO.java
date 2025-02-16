package com.alejobeliz.projects.techforb.dto.response;

public record PlantResponseDTO(
        Long id,
        String name,
        CountryResponseDTO country
) {

    public record CountryResponseDTO(
            String name,
            String imageUrl
    ) {


    }
}
