package com.example.mobileapplication.controller;

import com.example.mobileapplication.dao.UserDto;
import com.example.mobileapplication.dto.request.UserDetailsRequestModel;
import com.example.mobileapplication.dto.response.UserRest;
import com.example.mobileapplication.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserService userService;


    @PostMapping
    public UserRest createUser(@RequestBody UserDetailsRequestModel userDetails) {
        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(userDetails, userDto);
        UserDto createdUser = userService.createUser(userDto);
        UserRest returnValue = new UserRest();
        BeanUtils.copyProperties(createdUser, returnValue);
        return returnValue;

    }

    @GetMapping(path = "/{userId}")
    public UserRest getUser(@PathVariable String userId) {
        UserDto userDto = userService.getUserById(userId);
        UserRest userRest = new UserRest();
        BeanUtils.copyProperties(userDto, userRest);
        return userRest;

    }

}
