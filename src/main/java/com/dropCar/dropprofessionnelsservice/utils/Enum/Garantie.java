package com.dropCar.dropprofessionnelsservice.utils.Enum;

public enum Garantie {
    CASH,
    CHECK,
    NONE;
    private static final Garantie[] ENUMS = Garantie.values();


    public static Garantie of(int alias) {
        return ENUMS[alias - 1];
    }
}
