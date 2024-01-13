package com.dropCar.dropprofessionnelsservice.infrastructure.persistance.repositories;

import com.dropCar.dropprofessionnelsservice.infrastructure.persistance.models.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity,Long> {
  @Query("SELECT COUNT(e) FROM CustomerEntity e WHERE e.user.id = :client_id")
   Long countByClientId (@Param("client_id") Long client_id);

}
