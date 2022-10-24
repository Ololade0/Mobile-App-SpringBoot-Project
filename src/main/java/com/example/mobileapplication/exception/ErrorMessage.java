package com.example.mobileapplication.exception;

public enum ErrorMessage {
    MISSING_REQUIRED_FIELD("Missing required field. Please check documentation for required field"),
    RECORD_ALREADY_EXIST("Record already exist"),
    INTERNAL_SERVER_ERROR("Internal server error");


    private String errorMessage;

    ErrorMessage(String message) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
