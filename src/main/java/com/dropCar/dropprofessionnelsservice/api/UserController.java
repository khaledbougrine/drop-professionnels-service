package com.dropCar.dropprofessionnelsservice.api;

import com.dropCar.dropprofessionnelsservice.api.dto.RegisterUserDto;
import com.dropCar.dropprofessionnelsservice.api.dto.AuthenticationUserDto;
import com.dropCar.dropprofessionnelsservice.api.dto.UserTokenDto;
import com.dropCar.dropprofessionnelsservice.application.AuthService;
import com.dropCar.dropprofessionnelsservice.application.create.CreateUser;
import com.dropCar.dropprofessionnelsservice.application.load.ClientLoader;
import com.dropCar.dropprofessionnelsservice.utils.mapper.UserMapper;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * Controller to expose endpoints to list the available clients
 */
@RestController
@AllArgsConstructor
@RequestMapping("/usr/")
public class UserController {
    private final CreateUser createUser;
    private final AuthService authService;
    private final ClientLoader clientLoader;

    @PostMapping("register")
    public RegisterUserDto postClient(@Valid @RequestBody RegisterUserDto clientDto) {
        System.out.println(clientDto);
        createUser.create(clientDto);
        return clientDto;
    }

    @PostMapping("authenticate")
    public UserTokenDto loginClient(@RequestBody AuthenticationUserDto clientLoginDto) {
        return authService.authenticate(clientLoginDto);
    }
    @GetMapping("load")
    public RegisterUserDto loadUser(@RequestParam("userName") String userName) {
        var userDomain = clientLoader.loadUserByUsernameForApi(userName);
        return UserMapper.fromDomainToDto(userDomain);
    }
}
