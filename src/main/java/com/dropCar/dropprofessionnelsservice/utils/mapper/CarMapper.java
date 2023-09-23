package com.dropCar.dropprofessionnelsservice.utils.mapper;

import com.dropCar.dropprofessionnelsservice.api.dto.CarDto;
import com.dropCar.dropprofessionnelsservice.application.domain.CarDomain;
import com.dropCar.dropprofessionnelsservice.infrastructure.persistance.models.CarEntity;
import jakarta.validation.constraints.NotNull;
import lombok.NonNull;
import org.springframework.beans.BeanUtils;

public final class CarMapper {
    public static @NonNull  CarDomain fromDtoToDomain(final @NonNull  CarDto carDto){
        final CarDomain carDomain = new CarDomain();
        BeanUtils.copyProperties(carDto,carDomain);

        return carDomain;
    }
    public static @NonNull CarDto fromDomainToDto(final @NonNull CarDomain carDomain){
        final CarDto carDto =new CarDto();
        BeanUtils.copyProperties(carDomain,carDto);

        return carDto;
    }
    public static @NonNull CarDomain fromEntityToDomain(final @NonNull CarEntity carEntity){
        final CarDomain carDomain =new CarDomain();
        BeanUtils.copyProperties(carEntity,carDomain);
        return carDomain;
    }
}
