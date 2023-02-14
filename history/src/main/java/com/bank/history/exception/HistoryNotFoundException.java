package com.bank.history.exception;

/**
 * класс своего исключения для обработки запроса с несуществующим id
 * @author Larisa Ermakova
 */
public class HistoryNotFoundException extends RuntimeException {

    public HistoryNotFoundException (String message) {
        super(message);
    }
}
