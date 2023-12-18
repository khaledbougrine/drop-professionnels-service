package com.dropCar.dropprofessionnelsservice.api.dto;

import com.dropCar.dropprofessionnelsservice.utils.Enum.BoiteVitesse;
import com.dropCar.dropprofessionnelsservice.utils.Enum.Motorisation;
import com.dropCar.dropprofessionnelsservice.utils.Enum.VehiculeType;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.Date;

public class CarsDisplayDto {

    @NotNull
    private Integer carId;
    /**
     * The registration number of the car.
     */
    @NotEmpty
    private String immatricule;
    /**
     * The mileage of the car.
     */
    @NotNull
    private Double kilometrage;
    /**
     * The type of motorization for the car.
     */
    @NotNull
    private Motorisation motorisation;

    /**
     * The type of gearbox for the car.
     */
    @NotNull
    private BoiteVitesse boiteVitesse;

    /**
     * The Last date of technical inspection of the car.
     */
    @NotNull
    private Date DernierControleTechnique;

    /**
     * The user ID associated with the car.
     */
    @NotNull
    private Integer userId;

    /**
     * The type of the car create.
     */
    @NotNull
    private VehiculeType typeDeVehicule;
}
