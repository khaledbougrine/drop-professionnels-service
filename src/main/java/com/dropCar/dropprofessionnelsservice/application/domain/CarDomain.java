package com.dropCar.dropprofessionnelsservice.application.domain;

import com.dropCar.dropprofessionnelsservice.utils.Enum.BoiteVitesse;
import com.dropCar.dropprofessionnelsservice.utils.Enum.Motorisation;
import com.dropCar.dropprofessionnelsservice.utils.Enum.VehiculeType;
import lombok.Data;


@Data
public class CarDomain {
    private Integer carId;
    private String immatricule;
    private String brand;
    private String model;
    private Double kilometrage;
    private BoiteVitesse boiteVitesse;
    private Motorisation motorisation;
    private VehiculeType typeDeVehicule;


}
