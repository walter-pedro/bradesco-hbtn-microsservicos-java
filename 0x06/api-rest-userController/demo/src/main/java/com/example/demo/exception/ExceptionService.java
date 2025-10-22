package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionService {

    @ExceptionHandler
    ResponseEntity<CPFException> handleUserIdException(UserIdException err){
        UserErrorResponse uer = new UserErrorResponse();
        uer.setStatus(HttpStatus.BAD_REQUEST.value()); 
        uer.setMessage(err.getMessage());
        return new ResponseEntity(uer,HttpStatus.BAD_REQUEST); 
    }

    @ExceptionHandler
    ResponseEntity<CPFException> handleUserNameException(CPFException err){
        UserErrorResponse uer = new UserErrorResponse();
        uer.setStatus(HttpStatus.BAD_REQUEST.value()); 
        uer.setMessage(err.getMessage());
        return new ResponseEntity(uer,HttpStatus.BAD_REQUEST); 
    }

    @ExceptionHandler
    ResponseEntity<CPFException> handleCpfException(CPFException err){
        UserErrorResponse uer = new UserErrorResponse();
        uer.setStatus(HttpStatus.BAD_REQUEST.value()); 
        uer.setMessage(err.getMessage());
        return new ResponseEntity(uer,HttpStatus.BAD_REQUEST); 
    }
}