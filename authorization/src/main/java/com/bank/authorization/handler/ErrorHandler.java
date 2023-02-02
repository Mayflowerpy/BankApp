package com.bank.authorization.handler;

import com.bank.authorization.exception.RoleNotCreatedException;
import com.bank.authorization.exception.RoleNotFoundException;
import com.bank.authorization.exception.UserNotCreatedException;
import com.bank.authorization.exception.UserNotFoundException;
import com.bank.authorization.util.RoleErrorResponse;
import com.bank.authorization.util.UserErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Handler для обработки ошибок RestController
 * При возникновении ошибки создает объект класса ErrorResponse(message, currentTimeMillis)
 * Возвращает ResponseEntity(ErrorResponse, HttpStatus)
 * Аннотация ControllerAdvice - для создания бина ErrorHandler и указания, что это обработчик ошибок
 *
 * @author Vladislav Shilov
 */

@ControllerAdvice
public class ErrorHandler {

    @ExceptionHandler
    public ResponseEntity<UserErrorResponse> handlerException(UserNotFoundException e) {
        final UserErrorResponse userErrorResponse =
                new UserErrorResponse("User with this id not found", System.currentTimeMillis());
        return new ResponseEntity<>(userErrorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<UserErrorResponse> handlerException(UserNotCreatedException e) {
        final UserErrorResponse userErrorResponse = new UserErrorResponse(e.getMessage(), System.currentTimeMillis());
        return new ResponseEntity<>(userErrorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity<RoleErrorResponse> handlerException(RoleNotFoundException e) {
        final RoleErrorResponse roleErrorResponse =
                new RoleErrorResponse("Role with this id not found", System.currentTimeMillis());
        return new ResponseEntity<>(roleErrorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<RoleErrorResponse> handlerException(RoleNotCreatedException e) {
        final RoleErrorResponse roleErrorResponse = new RoleErrorResponse(e.getMessage(), System.currentTimeMillis());
        return new ResponseEntity<>(roleErrorResponse, HttpStatus.BAD_REQUEST);
    }
}
