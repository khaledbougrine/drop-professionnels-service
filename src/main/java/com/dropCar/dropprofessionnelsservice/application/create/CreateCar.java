package com.dropCar.dropprofessionnelsservice.application.create;

import com.dropCar.dropprofessionnelsservice.api.dto.UserCarCreationDto;
import com.dropCar.dropprofessionnelsservice.infrastructure.persistance.models.CarEntity;
import com.dropCar.dropprofessionnelsservice.infrastructure.persistance.models.CategoryEntity;
import com.dropCar.dropprofessionnelsservice.infrastructure.persistance.models.UserEntity;
import com.dropCar.dropprofessionnelsservice.infrastructure.persistance.repositories.CarRepository;
import com.dropCar.dropprofessionnelsservice.infrastructure.persistance.repositories.CategoryRepository;
import com.dropCar.dropprofessionnelsservice.infrastructure.persistance.repositories.ClientRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static com.dropCar.dropprofessionnelsservice.utils.mapper.CarMapper.*;

@AllArgsConstructor
@Service
public class CreateCar {
    private final CarRepository carRepository;
    private final CategoryRepository categoryRepository;
    private final ClientRepository userRepository;

    @Transactional
    public UserCarCreationDto create(final @NonNull UserCarCreationDto carDto) {
        CarEntity carDb = carRepository.save(this.buildEntity(carDto));
        return fromDomainToDto(fromEntityToDomain(carDb));

    }

    private @NotNull CarEntity buildEntity(@NonNull final UserCarCreationDto carDto) {
        CarEntity carEntity = new CarEntity();
        BeanUtils.copyProperties(carDto, carEntity);
        UserEntity user = userRepository.findById(carDto.getUserId()).orElseThrow();
        carEntity.setClient(user);
//        CategoryEntity categoryDb = new CategoryEntity();
//        carEntity.setCategory(categoryDb);

        return carEntity;
    }

}
