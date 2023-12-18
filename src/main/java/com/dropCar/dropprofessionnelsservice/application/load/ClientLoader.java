package com.dropCar.dropprofessionnelsservice.application.load;

import com.dropCar.dropprofessionnelsservice.application.domain.UserDomain;
import com.dropCar.dropprofessionnelsservice.application.domain.UserSecurityDomain;
import com.dropCar.dropprofessionnelsservice.infrastructure.persistance.repositories.UserRepository;
import com.dropCar.dropprofessionnelsservice.utils.mapper.UserMapper;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class ClientLoader implements UserDetailsService {

    private final UserRepository userRepository;


    @Override
    public UserSecurityDomain loadUserByUsername(String username) throws UsernameNotFoundException {
        var usr = userRepository.findByUserName(username).map(UserMapper::fromEntityToSecurityDomain).orElseThrow();
        return usr;
    }

    public UserDomain loadUserByUsernameForApi(String username) throws UsernameNotFoundException {
        var usr = userRepository.findByUserName(username).map(UserMapper::fromEntityToDomain).orElseThrow();
        return usr;
    }


}
