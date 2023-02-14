package com.bank.publicinfo.util;

import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.validation.BindingResult;

import java.util.stream.Collectors;

/**
 * Класс ErrorResponse - используется в контроллерах для получения ошибок
 *
 * @author UnsleepingOwl (Lev Yakolin)
 */

public class ErrorBindingResult {

    public static String getBindingResultErrors(BindingResult bindingResult) {
        return bindingResult.getFieldErrors().stream().map(DefaultMessageSourceResolvable::getDefaultMessage).collect(Collectors.joining("; <br />"));
    }
}
