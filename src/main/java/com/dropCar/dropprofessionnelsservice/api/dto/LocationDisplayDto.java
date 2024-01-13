package com.dropCar.dropprofessionnelsservice.api.dto;

import com.dropCar.dropprofessionnelsservice.utils.Enum.Garantie;
import com.dropCar.dropprofessionnelsservice.utils.Enum.Statut;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.Date;

/**
 * Data Transfer Object (DTO) representing the display of a rental location.
 * This DTO encapsulates information related to the display of a rental location.
 */
@Data
public class LocationDisplayDto {

    private Long id;
    /**
     * The reference number of the rental location.
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
    private String vehicleName;
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

    /**
     * The registration number of the car.
     */
    @NotEmpty
    private String immatricule;

    @NotEmpty
    private String customerName;

    /**
     * The client's last name.
     */
    @NotEmpty
    private String customerLastName;

    /**
     * The client's phone number.
     */
    @NotNull
    private Integer customerPhoneNumber;

}
