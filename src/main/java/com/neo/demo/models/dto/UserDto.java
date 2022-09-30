package com.neo.demo.models.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserDto {
    private Integer id;
    private String username;
    private String password;
    private boolean admin;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String token;
}
