package com.example.demo.dto.request;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class userDetailsRequestModel {
    private  String firstName;
    private  String lastName;
    private  String email;
    private  String password;
}
