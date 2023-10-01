package com.dropCar.dropprofessionnelsservice.api;

import com.dropCar.dropprofessionnelsservice.api.dto.RegisterUserDto;
import com.dropCar.dropprofessionnelsservice.api.dto.AuthenticationUserDto;
import com.dropCar.dropprofessionnelsservice.api.dto.UserTokenDto;
import com.dropCar.dropprofessionnelsservice.application.AuthService;
import com.dropCar.dropprofessionnelsservice.application.create.CreateClient;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 * Controller to expose endpoints to list the available clients
 */
@RestController
@AllArgsConstructor
@RequestMapping("/usr/")
public class ClientController {
    private final CreateClient createClient;
    private final AuthService authService;

    @PostMapping("register")
    public RegisterUserDto postClient(@RequestBody RegisterUserDto clientDto) {
        System.out.println(clientDto);
        createClient.create(clientDto);

        return clientDto;
    }

    @PostMapping("authenticate")
    public UserTokenDto loginClient(@RequestBody AuthenticationUserDto clientLoginDto) {
        return authService.authenticate(clientLoginDto);
    }
}
