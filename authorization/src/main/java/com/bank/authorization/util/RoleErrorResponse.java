package com.bank.authorization.util;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * Класс для создания объекта ошибки сущности Role, включающий в себя message и timestamp
 * Используется в ErrorHandler, при возникновении ошибок
 *
 * @author Vladislav Shilov
 */

@Getter
@Setter
@AllArgsConstructor
public class RoleErrorResponse {
    private String message;
    private Long timestamp;
}
