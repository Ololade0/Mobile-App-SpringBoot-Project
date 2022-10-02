package com.example.mobileapplication.dto.request;



import lombok.Getter;
import lombok.Setter;

    @Setter
    @Getter
    public class UserDetailsRequestModel {
        private  String firstName;
        private  String lastName;
        private  String email;
        private  String password;
    }

