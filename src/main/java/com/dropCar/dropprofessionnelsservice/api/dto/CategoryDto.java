package com.dropCar.dropprofessionnelsservice.api.dto;

import com.dropCar.dropprofessionnelsservice.infrastructure.persistance.models.CarEntity;
import com.dropCar.dropprofessionnelsservice.utils.Enum.VehiculeType;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.List;
@Data
public class CategoryDto implements Serializable {
    private String name;

    private VehiculeType carType;
    private List<CarEntity> cars;
}
