package com.dropCar.dropprofessionnelsservice.infrastructure.persistance.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dropCar.dropprofessionnelsservice.infrastructure.persistance.models.SubscriptionEntity;
@Repository
public interface SubscriptionRepository extends JpaRepository<SubscriptionEntity, Long> {

}
