package com.neo.demo.models.mapper;

import com.neo.demo.models.PriceList;
import com.neo.demo.models.VehicleBrand;
import com.neo.demo.models.dto.PriceListDto;
import com.neo.demo.models.dto.VehicleBrandDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface PriceListMapper {
    PriceListMapper INSTANCE = Mappers.getMapper(PriceListMapper.class);

    PriceList toEntity(PriceListDto e);

    PriceListDto toDto(PriceList e);

    List<PriceList> toEntityList(List<PriceListDto> e);

    List<PriceListDto> toDtoList(List<PriceList> e);
}