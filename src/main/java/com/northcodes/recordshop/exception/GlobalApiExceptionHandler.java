package com.northcodes.recordshop.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZoneId;
import java.time.ZonedDateTime;


// https://www.youtube.com/watch?v=PzK4ZXa2Tbc&ab_channel=Amigoscode
@ControllerAdvice
public class GlobalApiExceptionHandler {

    @ExceptionHandler(EndpointRequestNotFoundException.class)
    public ResponseEntity<Object> handleEndpointNotFoundException(EndpointRequestNotFoundException enfe) {

        // 1. Create payload containing exception details
        HttpStatus badRequest = HttpStatus.NOT_FOUND;
        EndpointNotFoundException noEndpointException = new EndpointNotFoundException(
                enfe.getMessage(),
                badRequest,
                ZonedDateTime.now(ZoneId.of("Z"))
        );
        // 2. Return response entity
        return new ResponseEntity<>(noEndpointException, badRequest);
        // Customize the response body as needed
//        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Please check endpoint: " + enfe.getMessage());
    }
    @ExceptionHandler(value = {ApiRequestException.class})
    public ResponseEntity<Object> handleApiRequestException(ApiRequestException e) {
        // 1. Create payload containing exception details
        HttpStatus badRequest = HttpStatus.BAD_REQUEST;
        ApiException apiException = new ApiException(
                e.getMessage(),
                badRequest,
                ZonedDateTime.now(ZoneId.of("Z"))
        );
        // 2. Return response entity
        return new ResponseEntity<>(apiException, badRequest);
    }
}
