package com.neo.demo.models.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class VehicleModelDto {
    private Integer id;
    private String nameModel;
    private VehicleTypeDto vehicleType;
}
