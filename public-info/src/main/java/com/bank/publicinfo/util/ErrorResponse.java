package com.bank.publicinfo.util;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * Класс ErrorResponse - используется в ErrorHandler для возвращения объекта ошибки
 *
 * @author UnsleepingOwl (Lev Yakolin)
 */

@Getter
@Setter
@AllArgsConstructor
public class ErrorResponse {

    private String response;

    private Long timestamp;
}
