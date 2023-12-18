package com.dropCar.dropprofessionnelsservice.application.create;

import com.dropCar.dropprofessionnelsservice.api.dto.RegisterUserDto;
import com.dropCar.dropprofessionnelsservice.infrastructure.persistance.models.UserEntity;
import com.dropCar.dropprofessionnelsservice.infrastructure.persistance.models.SubscriptionEntity;
import com.dropCar.dropprofessionnelsservice.infrastructure.persistance.repositories.UserRepository;
import com.dropCar.dropprofessionnelsservice.infrastructure.persistance.repositories.ModuleRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.Instant;

import static com.dropCar.dropprofessionnelsservice.utils.Enum.OfferTypeEnum.SATNDARD;
import static com.dropCar.dropprofessionnelsservice.utils.mapper.UserMapper.fromDomainToDto;
import static com.dropCar.dropprofessionnelsservice.utils.mapper.UserMapper.fromEntityToDomain;
import static java.time.Instant.now;
import static java.time.temporal.ChronoUnit.DAYS;

/**
 * Service class for creating a new Client.
 */
@Service
@AllArgsConstructor
public class CreateUser {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;
    private  final ModuleRepository moduleRepository;


    /**
     * Create a new client based on the provided CustomerRegistrationDto.
     *
     * @param registerUserDto The CustomerRegistrationDto object containing client information.
     * @return The newly created CustomerRegistrationDto.
     */
    @Transactional
    public @NotNull RegisterUserDto create(@NotNull final RegisterUserDto registerUserDto) {
        UserEntity userEntity = buildEntity(registerUserDto);
        var userDb = userRepository.save(userEntity);
        return fromDomainToDto(fromEntityToDomain(userDb));
    }

    /**
     * Build a UserEntity from a CustomerRegistrationDto.
     *
     * @param registerUserDto The CustomerRegistrationDto object to build the UserEntity from.
     * @return The UserEntity object.
     */
    private @NotNull UserEntity buildEntity(@NotNull final RegisterUserDto registerUserDto) {
        UserEntity userEntity = new UserEntity();
        BeanUtils.copyProperties(registerUserDto, userEntity);
        userEntity.setPassword(passwordEncoder.encode(registerUserDto.getPassword()));
        userEntity.setPhoneNumber(registerUserDto.getPhoneNumber());
        // creation subscription
        final SubscriptionEntity subscriptionEntity = new SubscriptionEntity();
        subscriptionEntity.setStartDate(Instant.now());
        subscriptionEntity.setEndDate(subscriptionEntity.getStartDate().plus(30,DAYS));
        subscriptionEntity.setIsActive(Boolean.TRUE);
        subscriptionEntity.setTypeEnum(SATNDARD);
//        userEntity.setSubscriptionEntity(subscriptionEntity);

        // TODO: Implement the mapping logic if needed.
        return userEntity;
    }
}
