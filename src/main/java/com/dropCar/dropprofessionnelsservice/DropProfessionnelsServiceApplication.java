package com.dropCar.dropprofessionnelsservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@EnableWebSecurity
public class DropProfessionnelsServiceApplication {


    public static void main(String[] args) {

        SpringApplication.run(DropProfessionnelsServiceApplication.class, args);

    }

}
