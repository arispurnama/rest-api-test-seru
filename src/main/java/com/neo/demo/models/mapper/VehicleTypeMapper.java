package com.neo.demo.models.mapper;

import com.neo.demo.models.VehicleType;
import com.neo.demo.models.dto.VehicleTypeDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface VehicleTypeMapper {
    VehicleTypeMapper INSTANCE = Mappers.getMapper(VehicleTypeMapper.class);

    VehicleType toEntity(VehicleTypeDto e);

    VehicleTypeDto toDto(VehicleType e);

    List<VehicleType> toEntityList(List<VehicleTypeDto> e);

    List<VehicleTypeDto> toDtoList(List<VehicleType> e);
}
