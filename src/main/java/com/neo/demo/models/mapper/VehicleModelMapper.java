package com.neo.demo.models.mapper;

import com.neo.demo.models.VehicleBrand;
import com.neo.demo.models.VehicleModel;
import com.neo.demo.models.dto.VehicleBrandDto;
import com.neo.demo.models.dto.VehicleModelDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface VehicleModelMapper {
    VehicleModelMapper INSTANCE = Mappers.getMapper(VehicleModelMapper.class);

    VehicleModel toEntity(VehicleModelDto e);

    VehicleModelDto toDto(VehicleModel e);

    List<VehicleModel> toEntityList(List<VehicleModelDto> e);

    List<VehicleModelDto> toDtoList(List<VehicleModel> e);
}
