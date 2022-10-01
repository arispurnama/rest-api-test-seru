package com.neo.demo.models.mapper;

import com.neo.demo.models.VehicleBrand;
import com.neo.demo.models.VehicleType;
import com.neo.demo.models.dto.VehicleBrandDto;
import com.neo.demo.models.dto.VehicleTypeDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface VehicleBrandMapper {
    VehicleBrandMapper INSTANCE = Mappers.getMapper(VehicleBrandMapper.class);

    VehicleBrand toEntity(VehicleBrandDto e);

    VehicleBrandDto toDto(VehicleBrand e);

    List<VehicleBrand> toEntityList(List<VehicleBrandDto> e);

    List<VehicleBrandDto> toDtoList(List<VehicleBrand> e);
}
