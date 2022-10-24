package com.example.mobileapplication.service;

import com.example.mobileapplication.dto.request.UserDetailsRequestModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceImplTest {
    @Autowired
    private UserService userService;

    @BeforeEach
    void setUp() {
    }

    @Test
    void createUser() {
        UserDetailsRequestModel userDetailsRequestModel = new UserDetailsRequestModel();
        userDetailsRequestModel.setEmail("");
        userDetailsRequestModel.setFirstName("");
        userDetailsRequestModel.setLastName("");
        userDetailsRequestModel.setPassword("");


    }

    @Test
    void getUserByEmail() {
    }

    @Test
    void totalUsers() {
    }

    @Test
    void deleteAll() {
    }

    @Test
    void getUserById() {
    }

    @Test
    void loadUserByUsername() {
    }
}