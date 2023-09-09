package com.dropCar.dropprofessionnelsservice.infrastructure.persistance.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ModuleRepository extends JpaRepository<Module, Long> {

}
