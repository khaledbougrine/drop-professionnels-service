package com.dropCar.dropprofessionnelsservice.application.load;

import com.dropCar.dropprofessionnelsservice.api.dto.DashBoardDto;
import com.dropCar.dropprofessionnelsservice.infrastructure.persistance.models.CarEntity;
import com.dropCar.dropprofessionnelsservice.infrastructure.persistance.repositories.CarRepository;
import com.dropCar.dropprofessionnelsservice.infrastructure.persistance.repositories.CustomerRepository;
import com.dropCar.dropprofessionnelsservice.infrastructure.persistance.repositories.LocationRepository;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class DashBoardLoader {
    private final CustomerRepository customerRepository;
    private final LocationRepository locationRepository;
    private final CarRepository carRepository;
    public DashBoardDto load (@NotNull final Long userId){
        return DashBoardDto.builder()
                .nbOfClients(customerRepository.countByClientId(userId))
                .nbOfLocations(locationRepository.countByClientId(userId))
                .nbOfCars(carRepository.countByClientId(userId))
                .build();
    }
}

