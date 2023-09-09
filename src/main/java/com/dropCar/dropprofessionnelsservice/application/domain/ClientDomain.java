package com.dropCar.dropprofessionnelsservice.application.domain;

import com.dropCar.dropprofessionnelsservice.utils.Enum.StatesEnum;
import lombok.NoArgsConstructor;
import lombok.With;

@NoArgsConstructor
@With
public class ClientDomain  {
    private  String name;
    private  String lastName;
    private  Integer phoneNumber;
    private StatesEnum statesEnum;

}
