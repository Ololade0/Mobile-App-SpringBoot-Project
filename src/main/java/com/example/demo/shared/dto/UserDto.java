package com.example.demo.shared.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
public class UserDto implements Serializable {
    private static final long serialVersionUid = 1L;

    private long id;
     private String userId;
     private  String firstName;
    private  String lastName;
    private  String email;
    private  String password;
    private  String encryptedPassword;
    private  String emailVerification;
    private  Boolean emailVerificationStatus = false;
}
