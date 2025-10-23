package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionService {

    @ExceptionHandler(UserIdException.class)
    ResponseEntity<UserIdException> handleUserIdException(UserIdException err){
        UserErrorResponse uer = new UserErrorResponse();
        uer.setStatus(HttpStatus.BAD_REQUEST.value()); 
        uer.setMessage("You have entered invalid ID");
        return new ResponseEntity(uer,HttpStatus.BAD_REQUEST); 
    }

    @ExceptionHandler(UserNameException.class)
    ResponseEntity<UserNameException> handleUserNameException(UserNameException err){
        UserErrorResponse uer = new UserErrorResponse();
        uer.setStatus(HttpStatus.BAD_REQUEST.value()); 
        uer.setMessage(err.getMessage());
        return new ResponseEntity(uer,HttpStatus.BAD_REQUEST); 
    }

    @ExceptionHandler(CPFException.class)
    ResponseEntity<CPFException> handleCpfException(CPFException err){
        UserErrorResponse uer = new UserErrorResponse();
        uer.setStatus(HttpStatus.BAD_REQUEST.value()); 
        uer.setMessage(err.getMessage());
        return new ResponseEntity(uer,HttpStatus.BAD_REQUEST); 
    }
}