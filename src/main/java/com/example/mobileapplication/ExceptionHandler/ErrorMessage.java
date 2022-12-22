package com.example.mobileapplication.ExceptionHandler;

import java.util.Date;

public class ErrorMessage {
    private String message;
    private Date timeStamp;

    public ErrorMessage(String message, Date timeStamp) {
        this.message = message;
        this.timeStamp = timeStamp;
    }
    public ErrorMessage() {

    }



    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}