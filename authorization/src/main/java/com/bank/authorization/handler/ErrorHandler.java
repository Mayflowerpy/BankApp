package com.bank.authorization.handler;

import com.bank.authorization.exception.RoleNotFoundException;
import com.bank.authorization.exception.UserNotFoundException;
import com.bank.authorization.util.RoleErrorResponse;
import com.bank.authorization.util.UserErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorHandler {

    @ExceptionHandler
    public ResponseEntity<UserErrorResponse> handlerException(UserNotFoundException e) {
        UserErrorResponse userErrorResponse = new UserErrorResponse("User with this id not found", System.currentTimeMillis());
        return new ResponseEntity<>(userErrorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<RoleErrorResponse> handlerException(RoleNotFoundException e) {
        RoleErrorResponse roleErrorResponse = new RoleErrorResponse("Role with this id not found", System.currentTimeMillis());
        return new ResponseEntity<>(roleErrorResponse, HttpStatus.NOT_FOUND);
    }
}
