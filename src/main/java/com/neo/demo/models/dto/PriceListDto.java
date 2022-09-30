package com.neo.demo.models.dto;

import com.neo.demo.models.VehicleModel;
import com.neo.demo.models.VehicleYear;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class PriceListDto {
    private Integer id;
    private String code;
    private Integer price;
    private List<VehicleYear> years;
    private List<VehicleModel> models;
}
