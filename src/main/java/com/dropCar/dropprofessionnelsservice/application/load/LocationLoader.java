package com.dropCar.dropprofessionnelsservice.application.load;

import com.dropCar.dropprofessionnelsservice.api.dto.LocationDisplayDto;
import com.dropCar.dropprofessionnelsservice.infrastructure.persistance.models.CarEntity;
import com.dropCar.dropprofessionnelsservice.infrastructure.persistance.models.CustomerEntity;
import com.dropCar.dropprofessionnelsservice.infrastructure.persistance.models.LocationEntity;
import com.dropCar.dropprofessionnelsservice.infrastructure.persistance.repositories.LocationRepository;
import com.dropCar.dropprofessionnelsservice.infrastructure.persistance.repositories.UserRepository;
import com.dropCar.dropprofessionnelsservice.utils.mapper.LocationMapper;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@AllArgsConstructor
@Service
public class LocationLoader {
    private final LocationRepository locationRepository;
    private  final UserRepository userRepository;

    public @NotNull List<LocationDisplayDto> loadLocationListByUerId(@NotNull final Long userId) {
        List<LocationEntity> locationEntities = userRepository.findById(userId).orElseThrow().getLocationList();
       return locationEntities.stream().map(LocationMapper::fromLocationEntityToDtoDisplayLocation).toList() ;

    }

}
