package com.bank.publicinfo.handler;

import com.bank.publicinfo.exception.NotFoundException;
import com.bank.publicinfo.util.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
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
 * @see NotFoundException
 */

@Slf4j
@ControllerAdvice
public class ErrorHandler {

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handlerException(NotFoundException e) {
        log.error("Объект не найден: " + e + " " + e.getMessage());
        return new ResponseEntity<>(new ErrorResponse("Объект не найден: " + e.getMessage(), System.currentTimeMillis()), HttpStatus.NOT_FOUND);
    }
}


