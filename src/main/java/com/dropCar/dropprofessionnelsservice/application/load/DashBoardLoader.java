package com.dropCar.dropprofessionnelsservice.application.load;

import com.dropCar.dropprofessionnelsservice.api.dto.DashBoardDto;
import com.dropCar.dropprofessionnelsservice.infrastructure.persistance.models.CarEntity;
import com.dropCar.dropprofessionnelsservice.infrastructure.persistance.repositories.CarRepository;
import com.dropCar.dropprofessionnelsservice.infrastructure.persistance.repositories.CustomerRepository;
import com.dropCar.dropprofessionnelsservice.infrastructure.persistance.repositories.LocationRepository;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@AllArgsConstructor
@Service
public class DashBoardLoader {
    private final CustomerRepository customerRepository;
    private final LocationRepository locationRepository;
    private final CarRepository carRepository;
    public DashBoardDto load (@NotNull final Long userId){
        var reult =  DashBoardDto.builder()
                .nbOfClients(customerRepository.countByClientId(userId))
                .nbOfLocations(locationRepository.countByClientId(userId))
                .nbOfCars(carRepository.countByClientId(userId))
                .build();
        Date dateSt = new Date();
        var dateStr = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        var dateNw = dateStr.format(dateSt);
        System.out.println(dateNw);

        System.out.println(Date.from(Instant.now()));
        System.out.println("))))))))))))))");
        carRepository.findDetailsByDate(Date.from(Instant.now()),userId).stream().forEach(System.out::println);
        return reult;
    }
}

