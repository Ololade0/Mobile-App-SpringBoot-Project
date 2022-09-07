package com.example.demo.controller;
import com.example.demo.dto.request.userDetailsRequestModel;
import com.example.demo.dto.response.UserRest;
import com.example.demo.service.UserService;
import com.example.demo.shared.dto.UserDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class usercontroller {
    @Autowired
    UserService userService;


@PostMapping
    public UserRest createUser(@RequestBody userDetailsRequestModel userDetails){
        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(userDetails, userDto);
        UserDto createdUser = userService.createUser(userDto);
         UserRest returnValue = new UserRest();
        BeanUtils.copyProperties(createdUser, returnValue);
        return  returnValue;

    }
    @GetMapping(path= "/{userId}")
    public UserRest getUser(@PathVariable String userId){
    UserDto userDto = userService.getUserById(userId);
    UserRest userRest = new UserRest();
        BeanUtils.copyProperties(userDto, userRest);
    return userRest;


    }


}
