package com.neo.demo.models.dto;

import com.neo.demo.models.PriceList;
import com.neo.demo.models.VehicleType;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class VehicleModelDto {
    private Integer id;
    private String nameModel;
    private List<VehicleType> types;
    private PriceList priceList;
}
