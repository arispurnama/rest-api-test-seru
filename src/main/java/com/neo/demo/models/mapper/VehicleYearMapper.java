package com.neo.demo.models.mapper;

import com.neo.demo.models.VehicleYear;
import com.neo.demo.models.dto.VehicleYearDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface VehicleYearMapper {
    VehicleYearMapper INSTANCE = Mappers.getMapper(VehicleYearMapper.class);

    VehicleYear toEntitiy(VehicleYearDto e);

    VehicleYearDto toDto(VehicleYear e);

    List<VehicleYearDto> toDtoList(List<VehicleYear> e);
}
