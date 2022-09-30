package com.neo.demo.controller;

import com.neo.demo.common.Response;
import com.neo.demo.models.User;
import com.neo.demo.models.dto.UserDto;
import com.neo.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping
    public Response findAllUser(){
        return new Response(
                userService.findAllUser(),
                userService.findAllUser().size(),
                HttpStatus.OK
        );
    }

    @PostMapping
    public ResponseEntity<?> saveUser(@RequestBody UserDto user){
        return new ResponseEntity(userService.createUser(user), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser (@PathVariable int id){
        userService.deleteUser(id);
        return new ResponseEntity("Berhasil Dihapus", HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateUser(@PathVariable int id, @RequestBody User user){
        return new ResponseEntity(userService.updateUser(id, user),HttpStatus.OK);
    }
}
