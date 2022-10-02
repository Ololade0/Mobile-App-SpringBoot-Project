package com.example.mobileapplication.dto.request;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class LoginUserRequest {
        private String emailAddress;
        private String password;
    }

