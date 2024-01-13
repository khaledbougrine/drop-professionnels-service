package com.dropCar.dropprofessionnelsservice.infrastructure.persistance.repositories;

import com.dropCar.dropprofessionnelsservice.infrastructure.persistance.models.LocationEntity;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LocationRepository extends JpaRepository<LocationEntity, Long> {
    @Query("SELECT COUNT(e) FROM LocationEntity e WHERE e.userEntity.id = :client_id")
    Long countByClientId(@Param("client_id") Long client_id);
}
