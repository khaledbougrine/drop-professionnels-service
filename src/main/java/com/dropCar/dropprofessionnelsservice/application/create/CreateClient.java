package com.dropCar.dropprofessionnelsservice.application.create;

import com.dropCar.dropprofessionnelsservice.api.dto.ClientDto;
import com.dropCar.dropprofessionnelsservice.infrastructure.persistance.models.ClientEntity;
import com.dropCar.dropprofessionnelsservice.infrastructure.persistance.repositories.ClientRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.dropCar.dropprofessionnelsservice.utils.mapper.ClientMapper.fromDomainToDto;
import static com.dropCar.dropprofessionnelsservice.utils.mapper.ClientMapper.fromEntityToDomain;

/**
 * Service class for creating a new Client.
 */
@Service
public class CreateClient {

    @Autowired
    private ClientRepository clientRepository;

    /**
     * Create a new client based on the provided ClientDto.
     *
     * @param clientDto The ClientDto object containing client information.
     * @return The newly created ClientDto.
     */
    @Transactional
    private @NotNull ClientDto create(@NotNull final ClientDto clientDto) {
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
    private @NotNull ClientEntity buildEntity(@NotNull final ClientDto clientDto) {
        ClientEntity clientEntity = new ClientEntity();

        // TODO: Implement the mapping logic if needed.

        return clientEntity;
    }
}
