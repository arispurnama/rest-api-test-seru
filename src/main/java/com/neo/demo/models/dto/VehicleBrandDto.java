package com.neo.demo.models.dto;

import com.neo.demo.models.VehicleType;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class VehicleBrandDto {
    private Integer id;
    private String name;
    private VehicleType vehicleType;
}
