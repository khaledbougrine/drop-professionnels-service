package com.dropCar.dropprofessionnelsservice.utils.Enum;

public enum StatesEnum {
    TUNIS,
    ARIANA,
    BENAROUS,
    MANNOUBA,
    BIZERTE,
    NABEUL,
    BEJA,
    JANDOUBA,
    ZAGHOUAN,
    SILIANA,
    LEKEF,
    SOUSSE,
    MOUNASTIR,
    MAHDIA,
    KASSERINE,
    SIDIBOUZIDE,
    KAIROUANE,
    GAFSA,
    SFAX,
    GABES,
    MEDENINE,
    TOZEUR,
    KEBILI,
    TATAOUINE;

    private static final OfferTypeEnum[] ENUMS = OfferTypeEnum.values();


    public static OfferTypeEnum of(int alias) {
        return ENUMS[alias - 1];
    }
}
