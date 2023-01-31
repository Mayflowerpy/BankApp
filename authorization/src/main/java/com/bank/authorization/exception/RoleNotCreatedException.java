package com.bank.authorization.exception;

public class RoleNotCreatedException extends RuntimeException{
    RoleNotCreatedException(String message) {
        super(message);
    }
}
