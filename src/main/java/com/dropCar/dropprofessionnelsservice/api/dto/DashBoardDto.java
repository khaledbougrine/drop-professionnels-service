package com.dropCar.dropprofessionnelsservice.api.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class DashBoardDto {

    private Long nbOfClients;
    private Long nbOfLocations;
    private Long nbOfCars;
    private Integer nbOfAbelCars;
    private List<OngoingLocationDTO> ongoingLocationDTOList;
}
