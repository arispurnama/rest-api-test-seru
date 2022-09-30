package com.neo.demo.models.mapper;

import com.neo.demo.models.User;
import com.neo.demo.models.dto.RegistrationDto;
import com.neo.demo.models.dto.UserDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

//    User toEntity(UserDto e);
//
//    UserDto toDto(User e);
//
//
//
//    RegistrationDto toRegistrationDto(User e);
//
//    User toUserFromRegistrationDto(RegistrationDto e);
//    @Mapping(source = "name", target = "profileName")
    User toEntity(UserDto dto);

//    @Mapping(source = "profileName", target = "name")
    UserDto toDto(User data);

    List<UserDto> toListDTO(List<User> list);

    List<User> toListEntity(List<UserDto> data);

    RegistrationDto toRegistrationDto(User data);

    User toUserFromRegistationDTO(RegistrationDto dto);
}
