package com.bank.account.exception;


/**
 * Нестандартный класс-исключение для обработки запроса с несуществующим id
 *
 * @author Dina Petrashova
 * @om 2023-02-07
 */

public class AccountNotFoundException extends RuntimeException {
    public AccountNotFoundException(String message) {
        super(message);
    }
}
