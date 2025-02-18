package com.alejobeliz.projects.techforb.entity;

import com.fasterxml.jackson.annotation.JsonValue;

public enum Name {
    TEMPERATURA("Temperatura"),
    PRESIÓN("Presión"),
    VIENTO("Viento"),
    NIVELES("Niveles"),
    ENERGÍA("Energía"),
    TENSIÓN("Tensión"),
    MONÓXIDO_DE_CARBONO("Monóxido de Carbono"),
    OTROS_GASES("Otros gases");

    private final String displayName;

    Name(String displayName) {
        this.displayName = displayName;
    }

    @JsonValue
    public String getDisplayName() {
        return displayName;
    }

    // Método para obtener el enum desde un String
    public static Name fromString(String text) {
        for (Name b : Name.values()) {
            if (b.displayName.equalsIgnoreCase(text)) {
                return b;
            }
        }
        throw new IllegalArgumentException("Unexpected value: " + text);
    }
}
