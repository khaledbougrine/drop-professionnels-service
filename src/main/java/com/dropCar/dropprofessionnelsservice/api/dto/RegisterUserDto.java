package com.dropCar.dropprofessionnelsservice.api.dto;

import com.dropCar.dropprofessionnelsservice.utils.Enum.StatesEnum;
import lombok.Data;

import java.io.Serializable;

@Data
public class RegisterUserDto implements Serializable {
    private String name;
    private String lastName;
    private String userName;
    private String phoneNumber;
    private StatesEnum statesEnum;
    private  String password;

}
