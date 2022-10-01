package com.neo.demo.controller;

import com.neo.demo.common.Response;
import com.neo.demo.models.dto.AuthRequestDto;
import com.neo.demo.models.dto.RegistrationDto;
import com.neo.demo.models.dto.UserDto;
import com.neo.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private UserService userService;

    @PostMapping("/do-login")
    public Response doLogin(@RequestBody AuthRequestDto param){
        UserDto data = userService.doLogin(param);

        return new Response(data, data != null ? "Login Sukses" : "Login Gagal", HttpStatus.OK);
    }

    @PostMapping("/do-register")
    public Response doRegister(@RequestBody RegistrationDto registrationDto){
        RegistrationDto data = userService.doRegister(registrationDto);

        return new Response(data, data != null ? "Registrasi Berhasil" : "Registrasi Gagal", HttpStatus.OK);
    }
}
