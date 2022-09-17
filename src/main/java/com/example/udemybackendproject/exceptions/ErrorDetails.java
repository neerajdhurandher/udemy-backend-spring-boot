package com.example.udemybackendproject.exceptions;

import java.util.Date;

public class ErrorDetails {
    String message;
    String details;
    String time_stamp;

    public ErrorDetails(String message, String details) {
        this.message = message;
        this.details = details;
        this.time_stamp = new Date().toString();
    }
}
