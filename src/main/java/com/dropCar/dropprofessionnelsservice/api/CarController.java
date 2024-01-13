package com.dropCar.dropprofessionnelsservice.api;

import com.dropCar.dropprofessionnelsservice.api.dto.CarsDisplayDto;
import com.dropCar.dropprofessionnelsservice.api.dto.UserCarCreationDto;
import com.dropCar.dropprofessionnelsservice.application.create.CreateCar;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/car")
public class CarController {
    @Autowired
     CreateCar createCar;
   @PostMapping("/add")
    public List<CarsDisplayDto> createCar(@RequestBody UserCarCreationDto userCarCreationDto){
        return  createCar.create(userCarCreationDto);
    }
}
