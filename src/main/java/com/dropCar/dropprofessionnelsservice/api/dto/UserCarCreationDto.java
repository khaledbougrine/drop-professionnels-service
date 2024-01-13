package com.dropCar.dropprofessionnelsservice.api.dto;

import com.dropCar.dropprofessionnelsservice.utils.Enum.BoiteVitesse;
import com.dropCar.dropprofessionnelsservice.utils.Enum.Motorisation;
import com.dropCar.dropprofessionnelsservice.utils.Enum.VehiculeType;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.io.Serializable;
import java.time.Instant;
import java.util.Date;

/**
 * Data Transfer Object (DTO) for representing a car.
 * Contains information about a car for various operations.
 */
@Data
public class UserCarCreationDto implements Serializable {

    /**
     * The registration number of the car.
     */
    @NotEmpty
    private String immatricule;

    /**
     * The brand of the car.
     */
    @NotEmpty
    private String brand;

    /**
     * The model of the car.
     */
    @NotEmpty
    private String model;

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
     * The user ID associated with the car.
     */
    @NotNull
    private Long userId;

    /**
     * The type of the car create.
     */
    @NotNull
    private VehiculeType typeDeVehicule;
}
