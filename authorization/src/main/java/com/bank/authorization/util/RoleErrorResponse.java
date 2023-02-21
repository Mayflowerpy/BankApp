package com.bank.authorization.util;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Класс для создания объекта ошибки сущности Role, включающий в себя message и timestamp
 * Используется в ErrorHandler, при возникновении ошибок
 *
 * @author Vladislav Shilov
 */

@Data
@AllArgsConstructor
public class RoleErrorResponse {
    private String message;
    private Long timestamp;
}
