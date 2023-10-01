package com.dropCar.dropprofessionnelsservice.application.domain;

import com.dropCar.dropprofessionnelsservice.utils.Enum.StatesEnum;
import lombok.Data;


//@With
@Data
public class ClientDomain {
    private String name;
    private String lastName;
    private Integer phoneNumber;
    private StatesEnum statesEnum;

}
