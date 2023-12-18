package com.dropCar.dropprofessionnelsservice.application.domain;

import com.dropCar.dropprofessionnelsservice.utils.Enum.StatesEnum;
import lombok.Data;


//@With
@Data
public class UserDomain {
    private String name;
    private String lastName;
    private String userName;
    private String phoneNumber;
    private StatesEnum statesEnum;

}
