package com.dropCar.dropprofessionnelsservice.api.dto;

import com.dropCar.dropprofessionnelsservice.utils.Enum.Statut;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;
import java.util.Date;

/**
 * Data Transfer Object (DTO) representing the creation of a location for a car rental service.
 * This DTO encapsulates information related to the creation of a rental location.
 */
public class LocationCreationDto implements Serializable {

    @NotEmpty
    private String clientName;

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
     * The total amount for the rental location.
     */
    @NotNull
    private Integer montant;

    /**
     * The vehicle associated with the rental location.
     */
    @NotEmpty
    private String vehicule;
    /**
     * The statut of the rent.
     */
    private Statut statut;

    /**
     * Indicates whether a guarantee is provided for the rental location.
     */
    private Boolean garantie;

    /**
     * Indicates whether the rental location has been checked.
     */
    private Boolean check;

    /**
     * Indicates whether the payment is made in cash for the rental location.
     */
    private Boolean cash;

    /**
     * The amount of the guarantee for the rental location.
     */
    @NotNull
    private Integer montantGarantie;

    /**
     * Additional description or notes for the rental location.
     */
    private String description;

}
