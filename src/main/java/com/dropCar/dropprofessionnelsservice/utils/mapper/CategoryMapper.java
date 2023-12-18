package com.dropCar.dropprofessionnelsservice.utils.mapper;

import com.dropCar.dropprofessionnelsservice.api.dto.CategoryDto;
import com.dropCar.dropprofessionnelsservice.application.domain.CategoryDomain;
import com.dropCar.dropprofessionnelsservice.infrastructure.persistance.models.CategoryEntity;
import lombok.NonNull;
import org.springframework.beans.BeanUtils;

public final class CategoryMapper {
    public static @NonNull CategoryDomain fromDtoToDomain(final @NonNull CategoryDto categoryDto){
        final CategoryDomain categoryDomain = new CategoryDomain();
        BeanUtils.copyProperties(categoryDto,categoryDomain);

        return categoryDomain;
    }
    public static @NonNull CategoryDto fromDomainToDto(final @NonNull CategoryDomain categoryDomain){
        final CategoryDto categoryDto =new CategoryDto();
        BeanUtils.copyProperties(categoryDomain,categoryDto);

        return categoryDto;
    }
    public static @NonNull CategoryDomain fromEntityToDomain(final @NonNull CategoryEntity categoryEntity){
        final CategoryDomain categoryDomain =new CategoryDomain();
        BeanUtils.copyProperties(categoryEntity,categoryDomain);
        return categoryDomain;
    }
}
