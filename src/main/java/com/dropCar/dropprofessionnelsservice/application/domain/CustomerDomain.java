package com.dropCar.dropprofessionnelsservice.application.domain;

import com.dropCar.dropprofessionnelsservice.utils.Enum.StatesEnum;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CustomerDomain {

    @NotEmpty
    private String name;

    @NotEmpty
    private String lastName;

    @NotNull
    private Integer phoneNumber;

    private StatesEnum statesEnum;

    @NotNull
    private Long Id;

    @NotNull
    private Long userId;

}
