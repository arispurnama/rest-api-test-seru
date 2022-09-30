package com.neo.demo.models.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegistrationDto {
    private String username;
    private String password;
    private boolean admin;
}
