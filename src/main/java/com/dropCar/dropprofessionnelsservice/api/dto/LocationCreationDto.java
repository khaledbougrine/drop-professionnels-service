package com.dropCar.dropprofessionnelsservice.api.dto;

import com.dropCar.dropprofessionnelsservice.utils.Enum.Garantie;
import com.dropCar.dropprofessionnelsservice.utils.Enum.Statut;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.springframework.lang.Nullable;

import java.io.Serializable;
import java.util.Date;

/**
 * Data Transfer Object (DTO) representing the creation of a location for a car rental service.
 * This DTO encapsulates information related to the creation of a rental location.
 */
public class LocationCreationDto implements Serializable {

    private CustomerRegistrationDto customerRegistrationDto;
    @Nullable
    private Integer clientId;

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
    private Integer rentalDays;

    /**
     * The total amount for the rental location.
     */
    @NotNull
    private Integer amount;

    /**
     * The vehicle associated with the rental location.
     */
    @NotEmpty
    private String vehicle;
    /**
     * The statut of the rent.
     */
    private Statut statut;

    /**
     * Indicates whether a guarantee is provided for the rental location.
     */
    private Garantie guarantee;

    /**
     * The amount of the guarantee for the rental location.
     */
    @NotNull
    private Integer guaranteeAmount;

    /**
     * Additional description or notes for the rental location.
     */
    private String description;

}
