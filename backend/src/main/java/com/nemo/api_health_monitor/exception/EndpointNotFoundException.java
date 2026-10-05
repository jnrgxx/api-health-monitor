package com.nemo.api_health_monitor.exception;

public class EndpointNotFoundException extends RuntimeException{
    public EndpointNotFoundException(String message) {
        super(message);
    }
}
