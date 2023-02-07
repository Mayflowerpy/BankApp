package com.bank.publicinfo.handler;

import com.bank.publicinfo.exception.NotFoundException;
import com.bank.publicinfo.util.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Класс ErrorHandler - обработчик ошибок RestController.
 * При возникновении ошибки создает объект класса ErrorResponse(message, currentTimeMillis)
 * Возвращает ResponseEntity(ErrorResponse, HttpStatus)
 * Аннотация ControllerAdvice - для создания бина ErrorHandler и указания, что это обработчик ошибок
 *
 * @author UnsleepingOwl (Lev Yakolin)
 */

@ControllerAdvice
public class ErrorHandler {

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handlerException(NotFoundException e) {
        return new ResponseEntity<>(new ErrorResponse(e.getMessage(), System.currentTimeMillis()), HttpStatus.NOT_FOUND);
    }
}


