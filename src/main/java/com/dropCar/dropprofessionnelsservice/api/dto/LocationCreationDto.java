package com.dropCar.dropprofessionnelsservice.api.dto;

import com.dropCar.dropprofessionnelsservice.utils.Enum.Garantie;
import com.dropCar.dropprofessionnelsservice.utils.Enum.Statut;
import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * Data Transfer Object (DTO) representing the creation of a location for a car rental service.
 * This DTO encapsulates information related to the creation of a rental location.
 */
@Data
public class LocationCreationDto implements Serializable {

    private CustomerRegistrationDto customerRegistrationDto;
    @NotNull
    private Long clientId;

    /**
     * The start date of the rental location.
     */
    private Date startDate;

    /**
     * The end date of the rental location.
     */
    private Date endDate;

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
     * The rentStatus of the rent.
     */
    private Statut rentStatus;

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

    private Long carId;

    private Long customerId;


}
