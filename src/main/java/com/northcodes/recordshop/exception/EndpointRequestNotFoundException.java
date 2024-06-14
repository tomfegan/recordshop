package com.northcodes.recordshop.exception;

//@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class EndpointRequestNotFoundException extends RuntimeException {
    public EndpointRequestNotFoundException(String message) {
        super(message);
    }
}
