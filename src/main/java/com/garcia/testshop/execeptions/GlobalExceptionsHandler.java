package com.garcia.testshop.execeptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionsHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorDetail> handerResourceNotFoundEx(ResourceNotFoundException ex, WebRequest webRequest){
        ErrorDetail errorDetail= new ErrorDetail(
                LocalDateTime.now(), ex.getMessage(), webRequest.getDescription(false),"Not Found----");

     return  new ResponseEntity<>(errorDetail, HttpStatus.NOT_FOUND);
    }

}
