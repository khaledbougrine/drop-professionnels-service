package com.dropCar.dropprofessionnelsservice.application.domain;

import com.dropCar.dropprofessionnelsservice.infrastructure.persistance.models.CarEntity;
import com.dropCar.dropprofessionnelsservice.utils.Enum.VehiculeType;
import lombok.Data;

import java.util.List;
@Data
public class CategoryDomain {
    private String name;

    private VehiculeType carType;
    private List<CarEntity> cars;
}
