package com.dropCar.dropprofessionnelsservice.infrastructure.persistance.repositories;

import com.dropCar.dropprofessionnelsservice.infrastructure.persistance.models.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<UserEntity, Long> {
//    Optional<UserEntity> findByName(String name);

    Optional<UserEntity> findByUserName(String userName);
//
//    public UserEntity findByUserame(String username);
//    public UserEntity findByPhoneNumber(Integer phoneNumber);

}
