package com.dropCar.dropprofessionnelsservice.utils.Enum;

public enum VehiculeType {

    SEDAN,
    SUV,
    SPORTS_CAR,
    VAN,
    HATCHBACK,
    OTHER;
    private static final VehiculeType[] ENUMS = VehiculeType.values();


    public static VehiculeType of(int alias) {
        return ENUMS[alias - 1];
    }

}
