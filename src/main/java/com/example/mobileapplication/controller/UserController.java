package com.example.mobileapplication.controller;

import com.example.mobileapplication.dto.request.RequestOperationName;
import com.example.mobileapplication.dto.response.OperationStatusModel;
import com.example.mobileapplication.dto.response.RequestOperationStatus;
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

import java.util.ArrayList;
import java.util.List;

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

    @GetMapping()
    public  UserRest login(LoginUserRequest loginUserRequest){
        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(loginUserRequest, userDto);
       // UserDto createdUser = userService.userDto);
        UserRest returnValue = new UserRest();
     //   BeanUtils.copyProperties(createdUser, returnValue);
        return returnValue;
    }

    @PutMapping()
    public UserRest updateUser(@PathVariable String id, @RequestBody UserDetailsRequestModel userDetailsRequestModel){
        UserRest returnValue = new UserRest();
        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(userDetailsRequestModel, userDto);
        UserDto createdUser = userService.updateUser(id, userDto);

        BeanUtils.copyProperties(createdUser, returnValue);
        return returnValue;
    }
@DeleteMapping(path = "/{id}")
    public OperationStatusModel deleteUser(@PathVariable String id){
        OperationStatusModel returnValue = new OperationStatusModel();
        returnValue.setOperationName(RequestOperationName.DELETE.name() );
        userService.deleteUser(id);
        returnValue.setOperationName(RequestOperationStatus.SUCCESS.name());
        return returnValue;

}
    @PostMapping("/getUsers")
    public List<UserRest> getUser(@RequestParam(value = "page", defaultValue = "1")int page,
                                  @RequestParam(value = "limit", defaultValue = "25") int limit){
        List<UserRest> returnValue = new ArrayList<>();
        List<UserDto> users = userService.getUsers(page, limit);
        for(UserDto userDto : users){
            UserRest userModel = new UserRest();
            BeanUtils.copyProperties(userDto, userModel);
            returnValue.add(userModel);

        }
        return returnValue;

    }

}
