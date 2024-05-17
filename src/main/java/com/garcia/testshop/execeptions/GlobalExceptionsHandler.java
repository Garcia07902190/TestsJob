package com.garcia.testshop.execeptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

/**
 * The type Global exceptions handler.
 */
@ControllerAdvice
public class GlobalExceptionsHandler {

    /**
     * Hander resource not found ex response entity.
     *
     * @param ex         the ex
     * @param webRequest the web request
     * @return the response entity
     */
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorDetail> handerResourceNotFoundEx(ResourceNotFoundException ex, WebRequest webRequest){
        ErrorDetail errorDetail= new ErrorDetail(
                LocalDateTime.now(), ex.getMessage(), webRequest.getDescription(false),"Not Found----");

     return  new ResponseEntity<>(errorDetail, HttpStatus.NOT_FOUND);
    }

}
