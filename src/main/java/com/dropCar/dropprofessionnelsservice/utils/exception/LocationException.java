package com.dropCar.dropprofessionnelsservice.utils.exception;

import com.dropCar.dropprofessionnelsservice.api.dto.LocationDisplayDto;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Data
public class LocationException extends RuntimeException {
    private List<LocationDisplayDto> locationDisplayDtos;

    public LocationException(final @NotNull List<LocationDisplayDto> locationDisplayDtos) {
        super();
        this.locationDisplayDtos = locationDisplayDtos;
    }
}
