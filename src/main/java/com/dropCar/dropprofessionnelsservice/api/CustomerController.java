package com.dropCar.dropprofessionnelsservice.api;

import com.dropCar.dropprofessionnelsservice.api.dto.CustomerDisplayDto;
import com.dropCar.dropprofessionnelsservice.api.dto.CustomerRegistrationDto;
import com.dropCar.dropprofessionnelsservice.application.create.CreateCustomer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    CreateCustomer createCustomer;

    @PostMapping("/addcustomer")
    public List<CustomerDisplayDto> createCustomer (@RequestBody CustomerRegistrationDto customerRegistrationDto){
        var tets =  createCustomer.create(customerRegistrationDto);
        return tets;
    }
}
