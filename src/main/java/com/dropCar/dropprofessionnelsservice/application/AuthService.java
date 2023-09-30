package com.dropCar.dropprofessionnelsservice.application;

import com.dropCar.dropprofessionnelsservice.api.dto.AuthenticationUserDto;
import com.dropCar.dropprofessionnelsservice.api.dto.UserTokenDto;
import com.dropCar.dropprofessionnelsservice.application.load.ClientLoader;
import com.dropCar.dropprofessionnelsservice.utils.JwtHelper;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@AllArgsConstructor
@Service
public class AuthService {
    private final AuthenticationManager authenticationManager;

    private final ClientLoader clientLoader;

    public UserTokenDto authenticate(AuthenticationUserDto request) {
        final String userName = request.getUserName();
        final String password = request.getPassword();

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        userName, password)
        );
        var jwtToken = JwtHelper.generateToken(new HashMap<>(),userName);
        return UserTokenDto.builder()
                .token(jwtToken)
                .build();
    }
}
