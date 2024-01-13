package com.dropCar.dropprofessionnelsservice.infrastructure.persistance.repositories;

import com.dropCar.dropprofessionnelsservice.infrastructure.persistance.models.CarEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends JpaRepository<CarEntity,Long>{
    @Query("SELECT COUNT(e) FROM CarEntity e WHERE e.client.id = :client_id")
    Long countByClientId(@Param("client_id") Long client_id);
//    public CarEntity findCarEntityByIdAndClientId(Integer id,Integer client_id);
}
