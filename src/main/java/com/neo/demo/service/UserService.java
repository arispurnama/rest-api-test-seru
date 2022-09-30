package com.neo.demo.service;

import com.neo.demo.config.JwtTokenUtil;
import com.neo.demo.models.User;
import com.neo.demo.models.dto.AuthRequestDto;
import com.neo.demo.models.dto.RegistrationDto;
import com.neo.demo.models.dto.UserDto;
import com.neo.demo.models.mapper.UserMapper;
import com.neo.demo.repositorie.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository repository;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;


//    public List<User> findAllUser(){
//        return userRepository.findAll();
//    }
//
//    public User create(User param){
//        return userRepository.save(param);
//    }
//
//    public void deleteUser(int id){
//        User data = userRepository.findById(id).orElseThrow(null);
//    }
//
//    public User updateUser(int id, User user){
//        User data = userRepository.findById(id).orElseThrow(null);
//
//        data.setUsername(user.getUsername() != null ? user.getUsername() : data.getUsername());
//        data.setPassword(user.getPassword() != null ? user.getPassword() : data.getPassword());
//        data.setAdmin(user.isAdmin() != true ? user.isAdmin() : data.isAdmin());
//
//        return userRepository.save(data);
//    }
//
//    public UserDto doLogin(AuthRequestDto user){
//        User currentUser = userRepository.findByUsername(user.getUsername());
//
//        if (currentUser != null){
//            return UserMapper.INSTANCE.toDto(currentUser);
//        }else if(currentUser.getPassword() != null && BCrypt.checkpw(user.getPassword(), currentUser.getPassword())){
//            System.out.println("test2");
//            UserDetails userDetails = new org.springframework.security.core.userdetails.User(currentUser.getUsername(), currentUser.getPassword(), new ArrayList<>());
//            currentUser.setToken(jwtTokenUtil.doGenerateToken(userDetails));
//            return UserMapper.INSTANCE.toDto(currentUser);
//        }
//        System.out.println("test3");
//        return null;
//    }
//
//    public RegistrationDto doRegister(RegistrationDto param){
//        User user = userRepository.findByUsername(param.getUsername());
//
//        if (user != null){
//            return null;
//        }
//        param.setPassword(BCrypt.hashpw(param.getPassword(), BCrypt.gensalt()));
//
//        user = userRepository.save(UserMapper.INSTANCE.toUserFromRegistrationDto(param));
//        return UserMapper.INSTANCE.toRegistrationDto(user);
//    }
    public List<UserDto> findAllUser() {
        return UserMapper.INSTANCE.toListDTO(repository.findAll());
    }

    @Transactional
    public UserDto createUser(UserDto param) {
        User user = UserMapper.INSTANCE.toEntity(param);
        user = repository.save(user);

//        DetailUser detailUser = detailUserRepository.save(param.getDetailUser());
//
//        RoleUser roleUser = roleUserRepository.save(param.getRole());
//
//        user.setDetailUser(detailUser);
//        user.setRole(roleUser);
        return UserMapper.INSTANCE.toDto(user);
    }

    public boolean deleteUser(int id) {
        try {
            User data = repository.findById(id).get();
            repository.delete(data);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public User updateUser(int id, User user) {
        User data = repository.findById(id).orElseThrow(null);
        data.setUsername(user.getUsername() != null ? user.getUsername() : data.getUsername());

        return repository.save(data);
    }

    public UserDto findById(Integer id){
        return UserMapper.INSTANCE.toDto(repository.findById(id).orElseThrow(null));
    }

    public UserDto doLogin(AuthRequestDto user){
        User currentUser = repository.findByUsername(user.getUsername());

        //mengecek apakan user kosong, jika kosong maka akan mengembalikan data null
        if (currentUser == null){
            return UserMapper.INSTANCE.toDto(currentUser);
        }else if (currentUser.getPassword() != null && BCrypt.checkpw(user.getPassword(), currentUser.getPassword())){
            //mengecek value password dari currentUser apakah tidak sama dengan null, dan membandingkan passwod dari param dan current user menggunakan BCrypt
            System.out.println("test2");
            UserDetails userDetails = new org.springframework.security.core.userdetails.User(currentUser.getUsername(), currentUser.getPassword(), new ArrayList<>());
            currentUser.setToken(jwtTokenUtil.doGenerateToken(userDetails));

            return UserMapper.INSTANCE.toDto(currentUser);
        }

        return null;
    }

    public RegistrationDto doRegister(RegistrationDto param){
        User user = repository.findByUsername(param.getUsername());

        if (user != null){
            return null;
        }

        //menyimpan value dari encripsi password dari parameter menggunakan BCrypt
        param.setPassword(BCrypt.hashpw(param.getPassword(), BCrypt.gensalt()));

        user = repository.save(UserMapper.INSTANCE.toUserFromRegistationDTO(param));

        return UserMapper.INSTANCE.toRegistrationDto(user);
    }
}
