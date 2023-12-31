package com.bank.transfer.exceptions;

/**
 * Исключение, выбрасываемое, если аккаунт отправителя/получателя банковского перевода не был найден
 */
public class AccountNotFoundException extends RuntimeException {
    public AccountNotFoundException(String message) {
        super(message);
    }
}
