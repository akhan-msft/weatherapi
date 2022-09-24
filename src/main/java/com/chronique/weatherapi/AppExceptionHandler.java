package com.chronique.weatherapi;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class AppExceptionHandler {
    
     /** Provides handling for exceptions throughout this service. */
     @ExceptionHandler(value = Exception.class)
     public ResponseEntity<ErrorMessage> handleException(Exception ex, WebRequest request) {
        
        ErrorMessage error = new ErrorMessage();
        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setMessage(ex.getMessage());
        error.setDate(new Date());
    
        return new ResponseEntity<ErrorMessage>(error, HttpStatus.BAD_REQUEST);
        }
     }
 
