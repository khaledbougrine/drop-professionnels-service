package com.dropCar.dropprofessionnelsservice.infrastructure.persistance.repositories;

import com.dropCar.dropprofessionnelsservice.infrastructure.persistance.models.LocationEntity;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface LocationRepository extends JpaRepository<LocationEntity, Long> {
    @Query("SELECT COUNT(e) FROM LocationEntity e WHERE e.userEntity.id = :client_id")
    Long countByClientId(@Param("client_id") Long client_id);

    /**
     * Checks if there are any locations for a specific car within a given date range.
     *
     * @param startDate The start date for the date range.
     * @param endDate   The end date for the date range.
     * @param carId     The ID of the car for which to check locations.
     * @return True if there are no locations for the specified car within the given date range, otherwise false.
     */
//    @Query(value = "SELECT CASE WHEN sub.count = 0 THEN true ELSE false END " +
//            "FROM (SELECT COUNT(*) AS count FROM Location " +
//            "WHERE end_date < :startDate AND start_date > :startDate AND car_id = :carId) AS sub", nativeQuery = true)
//    boolean checkLocationByCarIdAndData(@Param("startDate") String startDate, @Param("endDate") String endDate, @Param("carId") Long carId);


    @Query(value = "SELECT l FROM LocationEntity l " +
            "WHERE l.carEntity.id = :carId AND l.userEntity.id = :clientId AND" +
            "    (" +
            "        (l.startDate >= :startDateRangeStart AND l.endDate <= :endDateRangeEnd) " +
            "        OR " +
            "        (l.endDate > :startDateRangeStart AND l.startDate < :startDateRangeStart) " +
            "        OR " +
            "        (l.startDate < :endDateRangeEnd AND l.endDate > :endDateRangeEnd)" +
            "    )")
    List<LocationEntity> findLocationsByCarIdInDateRange(@Param("carId") Long carId,
                                                   @Param("clientId") Long clientId,
                                                   @Param("startDateRangeStart") Date startDateRangeStart,
                                                   @Param("endDateRangeEnd") Date endDateRangeEnd);

}
