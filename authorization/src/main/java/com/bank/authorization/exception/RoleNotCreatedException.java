package com.bank.authorization.exception;

/**
 * Ошибка создания объекта Role в POST, PUT методах RoleRestController
 *
 * @author Vladislav Shilov
 */

public class RoleNotCreatedException extends RuntimeException {
    public RoleNotCreatedException(String message) {
        super(message);
    }
}
