package com.example.mobileapplication.service;

import com.example.mobileapplication.dao.UserDto;
import com.example.mobileapplication.exception.UsernameNotFoundException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService   {

        UserDto createUser(UserDto user);

        UserDto getUserByEmail(String email) throws UsernameNotFoundException;

        long TotalUsers();

        void deleteAll();


        UserDto getUserById(String userId) throws UsernameNotFoundException;

        UserDetails loadUserByUsername(String email) throws UsernameNotFoundException;
}

