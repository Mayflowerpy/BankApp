package com.bank.authorization.util;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Класс для создания объекта ошибки сущности User, включающий в себя message и timestamp
 * Используется в ErrorHandler, при возникновении ошибок
 *
 * @author Vladislav Shilov
 */

@Data
@AllArgsConstructor
public class UserErrorResponse {
    private String message;
    private Long timestamp;
}
