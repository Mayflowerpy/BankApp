package com.bank.authorization.util;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Класс для создания объекта ошибки сущности Audit, включающий в себя message и timestamp
 * Используется в ErrorHandler, при возникновении ошибок
 *
 * @author Vladislav Shilov
 */

@Data
@AllArgsConstructor
public class AuditErrorResponse {
    private String message;
    private Long timestamp;
}
