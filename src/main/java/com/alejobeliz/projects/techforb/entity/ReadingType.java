package com.alejobeliz.projects.techforb.entity;

import com.fasterxml.jackson.annotation.JsonValue;

public enum ReadingType {
    ENERGÍA("Energía"),
    MONÓXIDO_DE_CARBONO("Monóxido de Carbono"),
    NIVELES("Niveles"),
    OTROS_GASES("Otros gases"),
    PRESIÓN("Presión"),
    TEMPERATURA("Temperatura"),
    TENSIÓN("Tensión"),
    VIENTO("Viento");

    private final String displayName;

    ReadingType(String displayName) {
        this.displayName = displayName;
    }

    @JsonValue
    public String getDisplayName() {
        return displayName;
    }

    // Método para obtener el enum desde un String
    public static ReadingType fromString(String text) {
        for (ReadingType b : ReadingType.values()) {
            if (b.displayName.equalsIgnoreCase(text)) {
                return b;
            }
        }
        throw new IllegalArgumentException("Unexpected value: " + text);
    }
}
