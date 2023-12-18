package com.dropCar.dropprofessionnelsservice.api.dto;

import com.dropCar.dropprofessionnelsservice.utils.Enum.StatesEnum;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class CustomerDisplayDto {

    @NotNull
    private Integer customerId;
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
