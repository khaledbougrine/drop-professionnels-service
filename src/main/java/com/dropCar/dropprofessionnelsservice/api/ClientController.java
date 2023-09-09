package com.dropCar.dropprofessionnelsservice.api;

import com.dropCar.dropprofessionnelsservice.api.dto.ClientDto;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

/**
 * Controller to expose endpoints to list the available clients
 */
@RestController
@RequestMapping("/clients")
public class ClientController {
    @PostMapping("/postClient")
    public ClientDto postClient(@RequestBody ClientDto clientDto) {

        // Print the new Work Period
        System.out.println(clientDto);

        return clientDto;
    }
}
