package com.dropCar.dropprofessionnelsservice.application.create;

import com.dropCar.dropprofessionnelsservice.api.dto.CarsDisplayDto;
import com.dropCar.dropprofessionnelsservice.api.dto.CustomerDisplayDto;
import com.dropCar.dropprofessionnelsservice.api.dto.CustomerRegistrationDto;
import com.dropCar.dropprofessionnelsservice.api.dto.UserCarCreationDto;
import com.dropCar.dropprofessionnelsservice.infrastructure.persistance.models.CarEntity;
import com.dropCar.dropprofessionnelsservice.infrastructure.persistance.models.CustomerEntity;
import com.dropCar.dropprofessionnelsservice.infrastructure.persistance.models.UserEntity;
import com.dropCar.dropprofessionnelsservice.infrastructure.persistance.repositories.CustomerRepository;
import com.dropCar.dropprofessionnelsservice.infrastructure.persistance.repositories.UserRepository;
import com.dropCar.dropprofessionnelsservice.utils.mapper.CarMapper;
import com.dropCar.dropprofessionnelsservice.utils.mapper.CustomerMapper;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class CreateCustomer {
    private final UserRepository userRepository;


    @Transactional
    public List<CustomerDisplayDto> create(final @NonNull CustomerRegistrationDto customerRegistrationDto) {
      return this.buildEntity(customerRegistrationDto).stream().map(CustomerMapper::fromEntityToDomainCustomer).map(CustomerMapper::fromDomainToDtoDisplayCustomer).toList();

    }
    private @NonNull List<CustomerEntity> buildEntity(@NonNull final CustomerRegistrationDto customerRegistrationDto) {
        CustomerEntity customerEntity = new CustomerEntity();
        BeanUtils.copyProperties(customerRegistrationDto, customerEntity);
        UserEntity user = userRepository.findById(customerRegistrationDto.getUserId()).orElseThrow();
        user.getCustomerList().add(customerEntity);
        return user.getCustomerList();
    }
}
