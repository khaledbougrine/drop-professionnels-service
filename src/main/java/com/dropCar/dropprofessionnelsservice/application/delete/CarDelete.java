package com.dropCar.dropprofessionnelsservice.application.delete;
import static com.dropCar.dropprofessionnelsservice.utils.mapper.CarMapper.*;

import com.dropCar.dropprofessionnelsservice.api.dto.UserCarCreationDto;
import com.dropCar.dropprofessionnelsservice.application.domain.CarDomain;
import com.dropCar.dropprofessionnelsservice.infrastructure.persistance.repositories.CarRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CarDelete {
    private final CarRepository carRepository;
  public String deleteCar(UserCarCreationDto carDto){
   CarDomain carDomain =fromDtoToDomain(carDto);
    return "car deleted";
  }
}
