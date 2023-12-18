package com.dropCar.dropprofessionnelsservice.utils.Enum;

public enum BoiteVitesse {
    MANUELLE,
    AUTOMATIQUE;
    private static final BoiteVitesse[] ENUMS = BoiteVitesse.values();


    public static BoiteVitesse of(int alias) {
        return ENUMS[alias - 1];
    }
}
