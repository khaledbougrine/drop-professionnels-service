package com.dropCar.dropprofessionnelsservice.api;

import com.dropCar.dropprofessionnelsservice.api.dto.DashBoardDto;
import com.dropCar.dropprofessionnelsservice.application.load.DashBoardLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dashboard")
public class DashBoardController {
    @Autowired
    DashBoardLoader dashBoardLoader;
    @GetMapping("/load")
    public DashBoardDto loadDashboard (@RequestParam ("userId") Long userId){
        return dashBoardLoader.load(userId);

    }
}
