package com.dropCar.dropprofessionnelsservice.utils.Enum;

public enum OfferTypeEnum {
    SATNDARD,
    PREMUIM,
    FULL;

    private static final OfferTypeEnum[] ENUMS = OfferTypeEnum.values();


    public static OfferTypeEnum of(int alias) {
        return ENUMS[alias - 1];
    }
}
