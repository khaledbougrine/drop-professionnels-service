package com.dropCar.dropprofessionnelsservice.utils.Enum;

public enum Statut {
    RESERVEE,
    CONFIRMEE,
    ENCOURS,
    TERMINER;

    private static final Statut[] ENUMS = Statut.values();


    public static Statut of(int alias) {
        return ENUMS[alias - 1];
    }

}
