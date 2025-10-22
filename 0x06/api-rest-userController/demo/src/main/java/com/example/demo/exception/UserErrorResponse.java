package com.example.demo.exception;

public class UserErrorResponse {

    public UserErrorResponse(int status, String message) {
        this.status = status;
        this.message = message;
    }

    public UserErrorResponse() {
    }

    private int status;
    private String message;
    
    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
}
