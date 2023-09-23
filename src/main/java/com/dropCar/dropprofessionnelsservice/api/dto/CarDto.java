package com.dropCar.dropprofessionnelsservice.api.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class CarDto implements Serializable {
    private String immatricule;
    private String brand;
    private String model;
    private Double kilometrage;
    private Integer age;
    private Integer client_id;
    private Long category_id;
}
