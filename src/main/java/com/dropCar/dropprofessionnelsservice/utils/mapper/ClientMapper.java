package com.dropCar.dropprofessionnelsservice.utils.mapper;

import com.dropCar.dropprofessionnelsservice.api.dto.ClientDto;
import com.dropCar.dropprofessionnelsservice.application.domain.ClientDomain;
import com.dropCar.dropprofessionnelsservice.infrastructure.persistance.models.ClientEntity;
import jakarta.validation.constraints.NotNull;
import lombok.NonNull;
import org.springframework.beans.BeanUtils;

/**
 * Mapper class for converting between different representations of Client objects.
 */
public final class ClientMapper {

    /**
     * Converts a ClientDomain object to a ClientDto object.
     *
     * @param clientDomain The ClientDomain object to be converted.
     * @return The corresponding ClientDto object.
     */
    public static @NonNull ClientDto fromDomainToDto(final @NotNull ClientDomain clientDomain) {
        final ClientDto clientDto = new ClientDto();
        BeanUtils.copyProperties(clientDomain, clientDto);

        // TODO: Implement the mapping logic if needed.

        return clientDto;
    }

    /**
     * Converts a ClientDto object to a ClientDomain object.
     *
     * @param clientDto The ClientDto object to be converted.
     * @return The corresponding ClientDomain object.
     */
    public static @NonNull ClientDomain fromDtoToDomain(final @NotNull ClientDto clientDto) {
        final ClientDomain clientDomain = new ClientDomain();
        BeanUtils.copyProperties(clientDto, clientDomain);

        // TODO: Implement the mapping logic if needed.

        return clientDomain;
    }

    /**
     * Converts a ClientEntity object to a ClientDomain object.
     *
     * @param clientEntity The ClientEntity object to be converted.
     * @return The corresponding ClientDomain object.
     */
    public static @NonNull ClientDomain fromEntityToDomain(@NonNull final ClientEntity clientEntity) {
        final ClientDomain clientDomain = new ClientDomain();
        BeanUtils.copyProperties(clientEntity, clientDomain);

        // TODO: Implement the mapping logic if needed.

        return clientDomain;
    }
}
