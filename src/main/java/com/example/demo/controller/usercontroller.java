package com.example.demo.controller;


import com.example.demo.dto.request.userDetailsRequestModel;
import com.example.demo.dto.response.UserRest;
import com.example.demo.service.UserService;
import com.example.demo.shared.dto.UserDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
//@RequestMapping("users")
public class usercontroller {
    @Autowired
    UserService userService;

@PostMapping("/users")
    public UserRest createUser(@RequestBody userDetailsRequestModel userDetails){
        //Create object of the response
        UserRest returnValue = new UserRest();
        //create object of the data transfer object
        UserDto userDto = new UserDto();
        //copying of request from source to the target area
        BeanUtils.copyProperties(userDetails, userDto);

        UserDto createdUser = userService.createUser(userDto);
        BeanUtils.copyProperties(createdUser, returnValue);
        return  returnValue;

    }
    @GetMapping
    public String getUser(){
    return "user was called";
    }


}
