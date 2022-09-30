package com.neo.demo.models.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AuthResponseDto {
    private String username;
    private String token;
}
