package com.dropCar.dropprofessionnelsservice.api;


import com.dropCar.dropprofessionnelsservice.api.dto.LocationCreationDto;
import com.dropCar.dropprofessionnelsservice.api.dto.LocationDisplayDto;
import com.dropCar.dropprofessionnelsservice.application.create.CreateLocation;
import com.dropCar.dropprofessionnelsservice.application.load.LocationLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/location")
public class LocationController {
    @Autowired
    CreateLocation createLocation;
    @Autowired
    LocationLoader locationLoader;
    @PostMapping("/addlocation")
    public List<LocationDisplayDto> createLocation (@RequestBody LocationCreationDto locationCreationDto){
        return createLocation.create(locationCreationDto);
    }
    @GetMapping("/loadlocations")
    public List<LocationDisplayDto> loadLocations (@RequestParam ("userId") Long userId){
        return locationLoader.loadLocationListByUerId(userId);

    }
}
