package com.dropCar.dropprofessionnelsservice.application.create;

import com.dropCar.dropprofessionnelsservice.api.dto.RegisterUserDto;
import com.dropCar.dropprofessionnelsservice.infrastructure.persistance.models.ClientEntity;
import com.dropCar.dropprofessionnelsservice.infrastructure.persistance.repositories.ClientRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import static com.dropCar.dropprofessionnelsservice.utils.mapper.ClientMapper.fromDomainToDto;
import static com.dropCar.dropprofessionnelsservice.utils.mapper.ClientMapper.fromEntityToDomain;

/**
 * Service class for creating a new Client.
 */
@Service
@AllArgsConstructor
public class CreateClient {

    private final  ClientRepository clientRepository;

    private final PasswordEncoder passwordEncoder;


    /**
     * Create a new client based on the provided ClientDto.
     *
     * @param clientDto The ClientDto object containing client information.
     * @return The newly created ClientDto.
     */
    @Transactional
    public @NotNull RegisterUserDto create(@NotNull final RegisterUserDto clientDto) {
        ClientEntity clientEntity = buildEntity(clientDto);
        var clientDb = clientRepository.save(clientEntity);
        return fromDomainToDto(fromEntityToDomain(clientDb));
    }

    /**
     * Build a ClientEntity from a ClientDto.
     *
     * @param clientDto The ClientDto object to build the ClientEntity from.
     * @return The ClientEntity object.
     */
    private @NotNull ClientEntity buildEntity(@NotNull final RegisterUserDto clientDto) {
        ClientEntity clientEntity = new ClientEntity();
        BeanUtils.copyProperties(clientDto, clientEntity);
        clientEntity.setPassword(passwordEncoder.encode(clientDto.getPassword()));
        // TODO: Implement the mapping logic if needed.

        return clientEntity;
    }
}
