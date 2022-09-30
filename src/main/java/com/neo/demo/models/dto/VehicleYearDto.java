package com.neo.demo.models.dto;

import com.neo.demo.models.PriceList;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class VehicleYearDto {
    private Integer id;
    private Date Year;
    private PriceList priceList;
}
