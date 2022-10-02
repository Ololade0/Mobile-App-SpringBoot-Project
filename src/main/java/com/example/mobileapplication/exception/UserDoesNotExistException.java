package com.example.mobileapplication.exception;

public class UserDoesNotExistException extends RuntimeException{
        public UserDoesNotExistException(String message) {
            super(message);
        }
    }

