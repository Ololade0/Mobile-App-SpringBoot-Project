package com.example.mobileapplication.controller;

import com.example.mobileapplication.exception.ErrorMessage;
import com.example.mobileapplication.dao.UserDto;
import com.example.mobileapplication.dto.request.LoginUserRequest;
import com.example.mobileapplication.dto.request.UserDetailsRequestModel;
import com.example.mobileapplication.dto.response.UserRest;
import com.example.mobileapplication.exception.UsernameNotFoundException;
import com.example.mobileapplication.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserService userService;


    @PostMapping
    public UserRest createUser(@RequestBody UserDetailsRequestModel userDetails) throws Exception {
        UserRest returnValue = new UserRest();
        if(userDetails.getFirstName().isEmpty())
            throw new UsernameNotFoundException(ErrorMessage.MISSING_REQUIRED_FIELD.getErrorMessage());
        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(userDetails, userDto);
        UserDto createdUser = userService.createUser(userDto);

        BeanUtils.copyProperties(createdUser, returnValue);
        return returnValue;

    }

    @GetMapping(value = "/{id}",
            produces ={MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public UserRest getUser(@PathVariable String id){
        UserRest returnValue = new UserRest();
        UserDto userDto =   userService.getUserByUserId(id);
        BeanUtils.copyProperties(userDto, returnValue);
        return returnValue;
    }

//    @GetMapping(path = "/{userId}")
//    public UserRest getUser(@PathVariable String userId) {
//        UserDto userDto = userService.getUserById(userId);
//        UserRest userRest = new UserRest();
//        BeanUtils.copyProperties(userDto, userRest);
//        return userRest;
//
//    }
    @GetMapping()
    public  UserRest login(LoginUserRequest loginUserRequest){
        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(loginUserRequest, userDto);
       // UserDto createdUser = userService.userDto);
        UserRest returnValue = new UserRest();
     //   BeanUtils.copyProperties(createdUser, returnValue);
        return returnValue;
    }


}
