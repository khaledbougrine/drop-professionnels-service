package com.dropCar.dropprofessionnelsservice.utils.mapper;

import com.dropCar.dropprofessionnelsservice.api.dto.CustomerDisplayDto;
import com.dropCar.dropprofessionnelsservice.api.dto.CustomerRegistrationDto;
import com.dropCar.dropprofessionnelsservice.api.dto.LocationCreationDto;
import com.dropCar.dropprofessionnelsservice.api.dto.LocationDisplayDto;
import com.dropCar.dropprofessionnelsservice.application.domain.CustomerDomain;
import com.dropCar.dropprofessionnelsservice.application.domain.LocationDomain;
import com.dropCar.dropprofessionnelsservice.infrastructure.persistance.models.CarEntity;
import com.dropCar.dropprofessionnelsservice.infrastructure.persistance.models.CustomerEntity;
import com.dropCar.dropprofessionnelsservice.infrastructure.persistance.models.LocationEntity;
import lombok.NonNull;
import org.springframework.beans.BeanUtils;

public class LocationMapper {
    public static @NonNull LocationDomain fromDtoToDomainLocation(final @NonNull LocationCreationDto locationCreationDto){
        final LocationDomain locationDomain = new LocationDomain();
        BeanUtils.copyProperties(locationCreationDto,locationDomain);

        return locationDomain;
    }
    public static @NonNull LocationCreationDto fromDomainToDtoLocation(final @NonNull LocationDomain locationDomain){
        final LocationCreationDto locationCreationDto =new LocationCreationDto();
        BeanUtils.copyProperties(locationDomain,locationCreationDto);

        return locationCreationDto;
    }
    public static @NonNull LocationDomain fromEntityToDomainLocation(final @NonNull LocationEntity locationEntity){
        final LocationDomain locationDomain =new LocationDomain();
        BeanUtils.copyProperties(locationEntity,locationDomain);
        return locationDomain;
    }
    public static @NonNull LocationDisplayDto fromDomainToDtoDisplayLocation(final @NonNull LocationDomain locationDomain){
        final LocationDisplayDto locationDisplayDto =new LocationDisplayDto();
        BeanUtils.copyProperties(locationDomain,locationDisplayDto);
        return locationDisplayDto;
    }


    public static @NonNull LocationDisplayDto fromLocationEntityToDtoDisplayLocation(final @NonNull LocationEntity locationEntity){
        final  LocationDisplayDto locationDisplayDtotmp = new LocationDisplayDto();
        BeanUtils.copyProperties(locationEntity,locationDisplayDtotmp);
        CustomerEntity customerEntity = locationEntity.getCustomerEntity();
        locationDisplayDtotmp.setCustomerName(customerEntity.getName());
        locationDisplayDtotmp.setCustomerLastName(customerEntity.getLastName());
        locationDisplayDtotmp.setCustomerPhoneNumber(customerEntity.getPhoneNumber());
        CarEntity carEntity = locationEntity.getCarEntity();

        locationDisplayDtotmp.setImmatricule(carEntity.getImmatricule());
        locationDisplayDtotmp.setVehicleName(carEntity.getBrand()+" "+carEntity.getModel());
        return locationDisplayDtotmp;
}
}
