package com.dropCar.dropprofessionnelsservice.application.domain;

import com.dropCar.dropprofessionnelsservice.utils.Enum.Garantie;
import com.dropCar.dropprofessionnelsservice.utils.Enum.Statut;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import java.util.Date;
@Data
public class LocationDomain {

    private Long id;

    private Date startDate;

    private Date endDate;

    private Integer rentalDays;

    private Integer amount;

    private String vehicle;

    private Statut rentStatus;

    private Garantie guarantee;

    private Integer guaranteeAmount;

    private String description;

    private Long carId;

    private Long customerId;

}
