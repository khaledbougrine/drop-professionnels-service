package com.dropCar.dropprofessionnelsservice.api.dto;

import com.dropCar.dropprofessionnelsservice.utils.Enum.StatesEnum;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NonNull;

import java.io.Serializable;

/**
 * Data Transfer Object (DTO) for registering a new user.
 * Contains user and society information for registration.
 */
@Data
public class RegisterUserDto implements Serializable {

    // User information

    /**
     * The user's first name.
     */
    @NotEmpty
    private String name;

    /**
     * The user's last name.
     */
    @NotEmpty
    private String lastName;

    /**
     * The user's chosen username.
     */
    @NotEmpty
    private String userName;

    /**
     * The user's phone number.
     */
    @NotEmpty
    private String phoneNumber;

    /**
     * The state of the user, represented by StatesEnum.
     */
    @NotNull
    private StatesEnum statesEnum;

    /**
     * The user's password.
     */
    @NotEmpty
    private String password;

    /**
     * The user's email address.
     */
    @Email
    private String email;

    // Society information

    /**
     * The name of the user's enterprise (society).
     */
    private String entrepriseName;

    /**
     * The number of cars associated with the user's account. Default value is 0.
     */
    @NotNull
    private Integer carNumber = 0;

}
