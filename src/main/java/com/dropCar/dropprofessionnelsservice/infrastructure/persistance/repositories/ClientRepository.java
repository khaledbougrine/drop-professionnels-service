package com.dropCar.dropprofessionnelsservice.infrastructure.persistance.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dropCar.dropprofessionnelsservice.infrastructure.persistance.models.ClientEntity;

import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<ClientEntity, Long> {
//    Optional<ClientEntity> findByName(String name);

    Optional<ClientEntity> findByUserName(String userName);
//
//    public ClientEntity findByUserame(String username);
//    public ClientEntity findByPhoneNumber(Integer phoneNumber);

}
