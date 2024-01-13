package com.dropCar.dropprofessionnelsservice.api.dto;

import lombok.Data;

@Data
public class OngoingLocationDTO {
    private String carName;
    private String registrationNb;
    private String customerName;
    private Integer customerPhoneNB;
    private Long percentageDaysRemaining;
    private Integer daysRemaining;
}
