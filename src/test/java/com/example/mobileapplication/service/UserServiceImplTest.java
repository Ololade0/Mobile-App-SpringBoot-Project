package com.example.mobileapplication.service;

import com.example.mobileapplication.dao.UserDto;
import com.example.mobileapplication.data.model.UserEntity;
import com.example.mobileapplication.data.repository.UserRepository;
import com.example.mobileapplication.dto.request.UserDetailsRequestModel;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

//@ExtendWith(MockitoExtension.class)
//@Slf4j
class UserServiceImplTest {
    @Autowired
    private UserService userService;
    @Mock
    UserRepository userRepository;
    @InjectMocks
    UserServiceImpl userServiceImpl;

    @BeforeEach
    void setUp() {
    }

    @Test
    void createUser() {
        UserDetailsRequestModel userDetailsRequestModel = new UserDetailsRequestModel();
//        userDetailsRequestModel.setEmail("");
//        userDetailsRequestModel.setFirstName("");
//        userDetailsRequestModel.setLastName("");
//        userDetailsRequestModel.setPassword("");


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

    @Test
    void getUsers() {
        UserEntity userEntity = new UserEntity();
        userEntity.setUserId("123");
        userEntity.setFirstName("Ololade");
        userEntity.setEmail("Ololade@gmail.com");
        userEntity.setEncryptedPassword("1ui67dhv339");
       UserDto userDto =  userService.getUserByEmail(userEntity.getEmail());
//       assertNotNull(userDto);
       assertEquals("Ololade", userDto.getFirstName());
        when(userRepository.findByEmail(anyString())).thenReturn(userEntity);

    }

}