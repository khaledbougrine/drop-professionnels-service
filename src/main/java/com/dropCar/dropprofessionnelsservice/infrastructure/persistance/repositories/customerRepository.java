package com.dropCar.dropprofessionnelsservice.infrastructure.persistance.repositories;

import com.dropCar.dropprofessionnelsservice.infrastructure.persistance.models.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface customerRepository extends JpaRepository<CustomerEntity,Long> {
}
