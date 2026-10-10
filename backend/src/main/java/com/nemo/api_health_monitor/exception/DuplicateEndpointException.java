package com.nemo.api_health_monitor.exception;

public class DuplicateEndpointException extends RuntimeException{
    public DuplicateEndpointException(String url) {
        super("Endpoint with URL '" + url + "' already exists");
    }
}
