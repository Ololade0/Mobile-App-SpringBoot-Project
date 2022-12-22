package com.example.mobileapplication.service;

import com.example.mobileapplication.dao.UserDto;
import com.example.mobileapplication.data.model.UserEntity;
import com.example.mobileapplication.exception.UsernameNotFoundException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService   {

        UserDto createUser(UserDto user);
        UserDto getUserByUserId(String userId);

        UserDto getUserByEmail(String email) throws UsernameNotFoundException;

        long TotalUsers();

        void deleteAll();


        UserDto getUserById(String userId) throws UsernameNotFoundException;

        UserDetails loadUserByUsername(String email) throws UsernameNotFoundException;

        UserDto updateUser(String userId, UserDto userDto);
        void deleteUser(String userId);

        List<UserDto> getUsers(int page, int limit);
}

