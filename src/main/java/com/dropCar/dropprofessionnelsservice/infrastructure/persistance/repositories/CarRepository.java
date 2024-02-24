package com.dropCar.dropprofessionnelsservice.infrastructure.persistance.repositories;

import com.dropCar.dropprofessionnelsservice.application.domain.OngoingLocationDomain;
import com.dropCar.dropprofessionnelsservice.infrastructure.persistance.models.CarEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<CarEntity,Long>{
    @Query("SELECT COUNT(e) FROM CarEntity e WHERE e.client.id = :client_id")
    Long countByClientId(@Param("client_id") Long client_id);
//    public CarEntity findCarEntityByIdAndClientId(Integer id,Integer client_id);

    @Query("SELECT new domain.OngoingLocationDomain (c.brand, c.model, c.immatricule, cu.name, cu.lastName, cu.phoneNumber, l.startDate, l.endDate) " +
        "FROM CarEntity c " +
        "FULL JOIN LocationEntity l ON c.id = l.carEntity.id " +
        "JOIN CustomerEntity cu ON cu.id = l.customerEntity.id " +
        "WHERE l.startDate <= :dateNow AND l.endDate >= :dateNow and c.client.id = :clientId")
    List<OngoingLocationDomain> findDetailsByDate(@Param("dateNow") Date dateNow,
                                                  @Param("clientId") Long clientId);

    @Query("select new package.DeadlineType(a.id, a.code) from ABDeadlineType a ")
    List<DeadlineType> findAllSummarizedBy();


}
