package com.neo.demo.models.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PriceListDto {
    private Integer id;
    private String code;
    private Integer price;
    private VehicleModelDto vehicleModel;
    private VehicleYearDto vehicleYear;
}
