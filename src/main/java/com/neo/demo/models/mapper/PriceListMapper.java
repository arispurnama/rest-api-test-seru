package com.neo.demo.models.mapper;

import com.neo.demo.models.PriceList;
import com.neo.demo.models.dto.PriceListDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface PriceListMapper {
    PriceListMapper INSTANCE = Mappers.getMapper(PriceListMapper.class);

    PriceList toEntitiy(PriceListDto e);

    PriceListDto toDto(PriceList e);

    List<PriceListDto> toDtoList(List<PriceList> e);
}