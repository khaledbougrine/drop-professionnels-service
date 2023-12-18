package com.dropCar.dropprofessionnelsservice.utils.Enum;

public enum Motorisation {
    DIESEL,
    ESSENCE,
    ELECTIQUE,
    HYBRIDE;
    private static final Motorisation[] ENUMS = Motorisation.values();


    public static Motorisation of(int alias) {
        return ENUMS[alias - 1];
    }
}
