package com.dropCar.dropprofessionnelsservice.utils.mapper;

import com.dropCar.dropprofessionnelsservice.api.dto.CarsDisplayDto;
import com.dropCar.dropprofessionnelsservice.api.dto.CustomerDisplayDto;
import com.dropCar.dropprofessionnelsservice.api.dto.CustomerRegistrationDto;
import com.dropCar.dropprofessionnelsservice.api.dto.UserCarCreationDto;
import com.dropCar.dropprofessionnelsservice.application.domain.CarDomain;
import com.dropCar.dropprofessionnelsservice.application.domain.CustomerDomain;
import com.dropCar.dropprofessionnelsservice.infrastructure.persistance.models.CarEntity;
import com.dropCar.dropprofessionnelsservice.infrastructure.persistance.models.CustomerEntity;
import lombok.NonNull;
import org.springframework.beans.BeanUtils;

public final class CustomerMapper {
    public static @NonNull CustomerDomain fromDtoToDomainCustomer(final @NonNull CustomerRegistrationDto customerRegistrationDto){
        final CustomerDomain customerDomain = new CustomerDomain();
        BeanUtils.copyProperties(customerRegistrationDto,customerDomain);

        return customerDomain;
    }
    public static @NonNull CustomerRegistrationDto fromDomainToDtoCustomer(final @NonNull CustomerDomain customerDomain){
        final CustomerRegistrationDto customerRegistrationDto =new CustomerRegistrationDto();
        BeanUtils.copyProperties(customerDomain,customerRegistrationDto);

        return customerRegistrationDto;
    }
    public static @NonNull CustomerDomain fromEntityToDomainCustomer(final @NonNull CustomerEntity customerEntity){
        final CustomerDomain customerDomain =new CustomerDomain();
        BeanUtils.copyProperties(customerEntity,customerDomain);
        return customerDomain;
    }
    public static @NonNull CustomerDisplayDto fromDomainToDtoDisplayCustomer(final @NonNull CustomerDomain customerDomain){
        final CustomerDisplayDto customerDisplayDto =new CustomerDisplayDto();
        BeanUtils.copyProperties(customerDomain,customerDisplayDto);
        return customerDisplayDto;
    }
}
