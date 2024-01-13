package com.dropCar.dropprofessionnelsservice.application.create;

import com.dropCar.dropprofessionnelsservice.api.dto.CarsDisplayDto;
import com.dropCar.dropprofessionnelsservice.api.dto.UserCarCreationDto;
import com.dropCar.dropprofessionnelsservice.infrastructure.persistance.models.CarEntity;
import com.dropCar.dropprofessionnelsservice.infrastructure.persistance.models.UserEntity;
import com.dropCar.dropprofessionnelsservice.infrastructure.persistance.repositories.CarRepository;
import com.dropCar.dropprofessionnelsservice.infrastructure.persistance.repositories.CategoryRepository;
import com.dropCar.dropprofessionnelsservice.infrastructure.persistance.repositories.UserRepository;
import com.dropCar.dropprofessionnelsservice.utils.mapper.CarMapper;
import jakarta.transaction.Transactional;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

import static com.dropCar.dropprofessionnelsservice.utils.mapper.CarMapper.*;

@AllArgsConstructor
@Service
public class CreateCar {
    private final UserRepository userRepository;

    @Transactional
    public List<CarsDisplayDto> create(final @NonNull UserCarCreationDto carDto) {
        return this.buildEntity(carDto).stream().map(CarMapper::fromEntityToDomain).map(CarMapper::fromDomainToDtoDisplayCar).toList();

    }

    private @NonNull List<CarEntity> buildEntity(@NonNull final UserCarCreationDto carDto) {
        CarEntity carEntity = new CarEntity();
        BeanUtils.copyProperties(carDto, carEntity);
        UserEntity user = userRepository.findById(carDto.getUserId()).orElseThrow();
        user.getCarList().add(carEntity);
        return user.getCarList();
    }

}
