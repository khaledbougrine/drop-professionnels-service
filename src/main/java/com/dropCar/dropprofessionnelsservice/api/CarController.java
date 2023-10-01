package com.dropCar.dropprofessionnelsservice.api;

import com.dropCar.dropprofessionnelsservice.api.dto.CarDto;
import com.dropCar.dropprofessionnelsservice.application.create.CreateCar;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/car")
public class CarController {
    @Autowired
     CreateCar createCar;
   @PostMapping("/add")
    public CarDto createCar(@RequestBody CarDto carDto){
        createCar.create(carDto);
        return carDto;
    }
}
