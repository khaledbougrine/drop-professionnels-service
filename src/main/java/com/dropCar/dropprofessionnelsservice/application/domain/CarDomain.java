package com.dropCar.dropprofessionnelsservice.application.domain;

import lombok.Data;

@Data
public class CarDomain {
    private String immatricule;
    private String brand;
    private String model;
    private Double kilometrage;
    private Integer category_id;
    private Integer age;

}
