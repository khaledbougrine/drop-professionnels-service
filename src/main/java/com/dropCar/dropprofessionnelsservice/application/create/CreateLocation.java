package com.dropCar.dropprofessionnelsservice.application.create;


import com.dropCar.dropprofessionnelsservice.api.dto.*;
import com.dropCar.dropprofessionnelsservice.infrastructure.persistance.models.CarEntity;
import com.dropCar.dropprofessionnelsservice.infrastructure.persistance.models.CustomerEntity;
import com.dropCar.dropprofessionnelsservice.infrastructure.persistance.models.LocationEntity;
import com.dropCar.dropprofessionnelsservice.infrastructure.persistance.models.UserEntity;
import com.dropCar.dropprofessionnelsservice.infrastructure.persistance.repositories.CarRepository;
import com.dropCar.dropprofessionnelsservice.infrastructure.persistance.repositories.CustomerRepository;
import com.dropCar.dropprofessionnelsservice.infrastructure.persistance.repositories.LocationRepository;
import com.dropCar.dropprofessionnelsservice.infrastructure.persistance.repositories.UserRepository;
import com.dropCar.dropprofessionnelsservice.utils.exception.LocationException;
import com.dropCar.dropprofessionnelsservice.utils.mapper.CarMapper;
import com.dropCar.dropprofessionnelsservice.utils.mapper.LocationMapper;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class CreateLocation {
    private final UserRepository userRepository;
    private final CustomerRepository customerRepository;
    private final CarRepository carRepository;
    private final LocationRepository locationRepository;

    @Transactional
    public List<LocationDisplayDto> create(final @NonNull LocationCreationDto locationCreationDto) {
        return this.buildEntity(locationCreationDto).stream().map(LocationMapper::fromLocationEntityToDtoDisplayLocation).toList();

    }

    private @NonNull List<LocationEntity> buildEntity(@NonNull final LocationCreationDto locationCreationDto) {

        var user = userRepository.findById(locationCreationDto.getClientId()).orElseThrow();
        List<LocationDisplayDto> locationInRangeList = locationRepository.findLocationsByCarIdInDateRange(locationCreationDto.getCarId(), locationCreationDto.getClientId(), locationCreationDto.getStartDate(), locationCreationDto.getEndDate()).stream().map(LocationMapper::fromLocationEntityToDtoDisplayLocation).toList();
        if(!locationInRangeList.isEmpty()){
            throw new LocationException(locationInRangeList);
        }
        LocationEntity locationEntity = new LocationEntity();
        BeanUtils.copyProperties(locationCreationDto, locationEntity);

        CustomerEntity customerEntity = customerRepository.findById(locationCreationDto.getCustomerId()).orElseThrow();
        locationEntity.setCustomerEntity(customerEntity);

        CarEntity car = carRepository.findById(locationCreationDto.getCarId()).orElseThrow();
        locationEntity.setCarEntity(car);
        locationEntity.setUserEntity(user);
        locationRepository.save(locationEntity);
        return user.getLocationList();
    }

}
