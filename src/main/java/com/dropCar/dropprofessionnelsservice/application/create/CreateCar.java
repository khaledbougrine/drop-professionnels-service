package com.dropCar.dropprofessionnelsservice.application.create;

import com.dropCar.dropprofessionnelsservice.api.dto.CarDto;
import com.dropCar.dropprofessionnelsservice.infrastructure.persistance.models.CarEntity;
import com.dropCar.dropprofessionnelsservice.infrastructure.persistance.models.CategoryEntity;
import com.dropCar.dropprofessionnelsservice.infrastructure.persistance.repositories.CarRepository;
import com.dropCar.dropprofessionnelsservice.infrastructure.persistance.repositories.CategoryRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import static com.dropCar.dropprofessionnelsservice.utils.mapper.CarMapper.*;

@AllArgsConstructor
@Service
public class CreateCar {
    private final CarRepository carRepository;
    private final CategoryRepository categoryRepository;

    @Transactional
    public  CarDto create(final @NonNull CarDto carDto) {
//        CarEntity carEntity = buildEntity(carDto);
////        CategoryEntity categoryDb = categoryRepository.findCategoryEntitiesById(carDto.getCategory_id());
//        carEntity.setCategory(categoryDb);
//        CarEntity carDb = carRepository.save(carEntity);
//        return fromDomainToDto(fromEntityToDomain(carDb));
        return null;
    }

    private @NotNull CarEntity buildEntity(@NonNull final CarDto carDto) {
        CarEntity carEntity = new CarEntity();
        BeanUtils.copyProperties(carDto, carEntity);
        return carEntity;
    }

}
