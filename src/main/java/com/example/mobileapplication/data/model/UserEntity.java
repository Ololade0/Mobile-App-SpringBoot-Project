package com.example.mobileapplication.data.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;


@Setter
    @Getter
    @Entity(name = "users")
    public class UserEntity implements Serializable {
        private static final long serialVersionUid = 1L;
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private long id;

        @Column(nullable = false)
        private String userId;

        @Column(nullable = false, length = 50)
        private  String firstName;

        @Column(nullable = false, length = 50)
        private  String lastName;

        @Column(nullable = false, length = 1200, unique = true)
        private  String email;

        @Column(nullable = false)
        private  String encryptedPassword;
        private String password;

        private  String emailVerificationToken;

        @Column(nullable = false)
        private  Boolean emailVerificationStatus = false ;
    }

