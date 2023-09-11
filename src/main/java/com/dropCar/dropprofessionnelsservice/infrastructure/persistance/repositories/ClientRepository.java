package com.dropCar.dropprofessionnelsservice.infrastructure.persistance.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dropCar.dropprofessionnelsservice.infrastructure.persistance.models.ClientEntity;
@Repository
public interface ClientRepository extends JpaRepository<ClientEntity, Long> {

}
