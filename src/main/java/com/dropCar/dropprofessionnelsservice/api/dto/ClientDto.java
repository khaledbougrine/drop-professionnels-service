package com.dropCar.dropprofessionnelsservice.api.dto;

import com.dropCar.dropprofessionnelsservice.utils.Enum.StatesEnum;
import lombok.Data;

import java.io.Serializable;

@Data
public class ClientDto implements Serializable {
    private  String name;
    private  String lastName;
    private  Integer phoneNumber;
    private  StatesEnum statesEnum;
    private Long category_id;

}
