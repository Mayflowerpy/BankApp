package com.bank.authorization.util;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * Класс для создания объекта ошибки сущности User, включающий в себя message и timestamp
 * Используется в ErrorHandler, при возникновении ошибок
 *
 * @author Vladislav Shilov
 */

@Getter
@Setter
@AllArgsConstructor
public class UserErrorResponse {
    private String message;
    private Long timestamp;
}
