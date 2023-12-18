package com.dropCar.dropprofessionnelsservice.api.dto;

import com.dropCar.dropprofessionnelsservice.utils.Enum.Statut;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.Date;

/**
 * Data Transfer Object (DTO) representing the display of a rental location.
 * This DTO encapsulates information related to the display of a rental location.
 */
public class LocationDisplayDto {

    /**
     * The reference number of the rental location.
     */
    @NotNull
    private Integer reference;

    /**
     * The name of the car associated with the rental location.
     */
    @NotEmpty
    private String carName;

    /**
     * The name of the customer associated with the rental location.
     */
    @NotEmpty
    private String customerName;

    /**
     * The start date of the rental location.
     */
    private Date dateDeDebut;

    /**
     * The end date of the rental location.
     */
    private Date dateDeFin;

    /**
     * The number of days for the rental location.
     */
    @NotNull
    private Integer nbJourDeLocation;

    /**
     * The tariff or cost associated with the rental location.
     */
    @NotNull
    private Integer tarif;

    /**
     * The status of the rental location, represented by Statut enum.
     */
    private Statut statut;

    /**
     * The user ID associated with the rental location.
     */
    @NotNull
    private Integer userId;

}
