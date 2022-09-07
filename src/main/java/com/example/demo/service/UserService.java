package com.example.demo.service;

import com.example.demo.data.model.UserEntity;
import com.example.demo.shared.dto.UserDto;
import org.springframework.security.core.userdetails.UserDetailsService;


public interface UserService extends UserDetailsService {



    UserDto createUser(UserDto user);

    UserDto getUserByEmail(String email);

    long TotalUsers();

    void deleteAll();


    UserDto getUserById(String userId);
}
