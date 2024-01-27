package com.dropCar.dropprofessionnelsservice.api;

import com.dropCar.dropprofessionnelsservice.api.dto.LocationDisplayDto;
import com.dropCar.dropprofessionnelsservice.utils.exception.LocationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(LocationException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ResponseEntity<List<LocationDisplayDto>> handleLocationException(LocationException e) {
        // Log the exception or perform additional actions
        return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getLocationDisplayDtos());
    }
}
