package com.dropCar.dropprofessionnelsservice.application.domain;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class OngoingLocationDomain implements Serializable {
    private String brand;
    private String model;
    private Integer immatricule;
    private String name;
    private String lastName;
    private Integer phoneNumber;
    private Date startDate;
    private Date endDate;



}
