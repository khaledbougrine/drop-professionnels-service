package com.dropCar.dropprofessionnelsservice.application.create;

import com.dropCar.dropprofessionnelsservice.api.dto.CategoryDto;
import com.dropCar.dropprofessionnelsservice.infrastructure.persistance.models.CategoryEntity;
import com.dropCar.dropprofessionnelsservice.infrastructure.persistance.repositories.CategoryRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import static com.dropCar.dropprofessionnelsservice.utils.mapper.CategoryMapper.fromDomainToDto;
import static com.dropCar.dropprofessionnelsservice.utils.mapper.CategoryMapper.fromEntityToDomain;
@AllArgsConstructor
@Service
public  class CreateCategory {
   public final CategoryRepository categoryRepository;
    @Transactional
    public @NotNull CategoryDto create(final @NonNull CategoryDto categoryDto){
        CategoryEntity categoryEntity = buildEntity(categoryDto);
        CategoryEntity categoryDb= categoryRepository.save(categoryEntity);
        return fromDomainToDto(fromEntityToDomain(categoryDb));
    };
    private @NotNull CategoryEntity buildEntity(@NonNull final CategoryDto categoryDto) {
        CategoryEntity categoryEntity= new CategoryEntity();
        BeanUtils.copyProperties(categoryDto,categoryEntity);

        return categoryEntity;
    }
}
