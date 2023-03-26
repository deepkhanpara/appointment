package com.medical.appointment.service;

public class ApiResponse {
    String message;

    public String getMessage() {
        return message;
    }

    public ApiResponse(String message) {
        this.message = message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
