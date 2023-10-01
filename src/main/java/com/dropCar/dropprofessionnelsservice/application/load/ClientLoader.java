package com.dropCar.dropprofessionnelsservice.application.load;

import com.dropCar.dropprofessionnelsservice.application.domain.ClientSecurityDomain;
import com.dropCar.dropprofessionnelsservice.infrastructure.persistance.repositories.ClientRepository;
import com.dropCar.dropprofessionnelsservice.utils.mapper.ClientMapper;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class ClientLoader implements UserDetailsService {

    private  final ClientRepository clientRepository;


    @Override
    public ClientSecurityDomain loadUserByUsername(String username) throws UsernameNotFoundException {
        var usr=   clientRepository.findByUserName(username).map(ClientMapper::fromEntityToSecurityDomain).orElseThrow();
        return  usr ;
    }




}
