package com.example.activity_tracker.exception;

public class CustomAppException extends RuntimeException{
    public CustomAppException(String message) {
        super(message);
    }
}
