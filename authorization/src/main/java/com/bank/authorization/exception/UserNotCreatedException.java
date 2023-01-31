package com.bank.authorization.exception;

public class UserNotCreatedException extends RuntimeException{
    UserNotCreatedException(String message) {
        super(message);
    }
}
