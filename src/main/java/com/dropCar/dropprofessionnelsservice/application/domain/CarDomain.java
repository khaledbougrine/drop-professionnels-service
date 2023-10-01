package com.dropCar.dropprofessionnelsservice.application.domain;

import lombok.Data;

@Data
public class CarDomain {
    private String immatricule;
    private String brand;
    private String model;
    private Double kilometrage;
    private int age;
    private Integer category_id;

}
