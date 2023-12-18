package com.dropCar.dropprofessionnelsservice.api.dto;

import com.dropCar.dropprofessionnelsservice.utils.Enum.StatesEnum;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.io.Serializable;

/**
 * Data Transfer Object (DTO) representing client information.
 * This DTO is used for handling client data in the application.
 */
@Data
public class CustomerRegistrationDto implements Serializable {

    /**
     * The client's first name.
     */
    @NotEmpty
    private String name;

    /**
     * The client's last name.
     */
    @NotEmpty
    private String lastName;

    /**
     * The client's phone number.
     */
    @NotNull
    private Integer phoneNumber;

    /**
     * The state of the client, represented by StatesEnum.
     */
    private StatesEnum statesEnum;

}
