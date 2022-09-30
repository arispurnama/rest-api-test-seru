package com.neo.demo.models.dto;

import com.neo.demo.models.VehicleBrand;
import com.neo.demo.models.VehicleModel;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class VehicleTypeDto {

    private Integer id;
    private String nameType;
    private Integer capacity;
    private List<VehicleBrand> brands;
    private VehicleModel vehicleModel;
}
