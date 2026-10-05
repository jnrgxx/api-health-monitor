package com.nemo.api_health_monitor.exception;

public class ResultNotFoundException extends RuntimeException{
    public ResultNotFoundException(String message) {
        super(message);
    }
}
