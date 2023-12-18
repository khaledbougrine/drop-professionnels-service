package com.dropCar.dropprofessionnelsservice.utils.mapper;

import com.dropCar.dropprofessionnelsservice.api.dto.RegisterUserDto;
import com.dropCar.dropprofessionnelsservice.application.domain.UserDomain;
import com.dropCar.dropprofessionnelsservice.application.domain.UserSecurityDomain;
import com.dropCar.dropprofessionnelsservice.infrastructure.persistance.models.UserEntity;
import jakarta.validation.constraints.NotNull;
import lombok.NonNull;
import org.springframework.beans.BeanUtils;

/**
 * Mapper class for converting between different representations of Client objects.
 */
public final class UserMapper {

    /**
     * Converts a UserDomain object to a CustomerRegistrationDto object.
     *
     * @param userDomain The UserDomain object to be converted.
     * @return The corresponding CustomerRegistrationDto object.
     */
    public static @NonNull RegisterUserDto fromDomainToDto(final @NotNull UserDomain userDomain) {
        final RegisterUserDto clientDto = new RegisterUserDto();
        BeanUtils.copyProperties(userDomain, clientDto);

        // TODO: Implement the mapping logic if needed.

        return clientDto;
    }

    /**
     * Converts a CustomerRegistrationDto object to a UserDomain object.
     *
     * @param clientDto The CustomerRegistrationDto object to be converted.
     * @return The corresponding UserDomain object.
     */
    public static @NonNull UserDomain fromDtoToDomain(final @NotNull RegisterUserDto clientDto) {
        final UserDomain userDomain = new UserDomain();
        BeanUtils.copyProperties(clientDto, userDomain);

        // TODO: Implement the mapping logic if needed.

        return userDomain;
    }

    /**
     * Converts a UserEntity object to a UserDomain object.
     *
     * @param userEntity The UserEntity object to be converted.
     * @return The corresponding UserDomain object.
     */
    public static @NonNull UserDomain fromEntityToDomain(@NonNull final UserEntity userEntity) {
        final UserDomain userDomain = new UserDomain();
        BeanUtils.copyProperties(userEntity, userDomain);

        // TODO: Implement the mapping logic if needed.

        return userDomain;
    }


    public static @NonNull UserSecurityDomain fromEntityToSecurityDomain(@NonNull final UserEntity userEntity) {
        final UserSecurityDomain clientDomain = new UserSecurityDomain();
        BeanUtils.copyProperties(userEntity, clientDomain);

        // TODO: Implement the mapping logic if needed.

        return clientDomain;
    }
}
