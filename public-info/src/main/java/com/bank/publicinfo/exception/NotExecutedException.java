package com.bank.publicinfo.exception;


import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * NotExecutedException - исключение, выбрасываемое при ошибке сохранения/обновления объекта
 *
 * @author UnsleepingOwl (Lev Yakolin)
 */

@Getter
@NoArgsConstructor
public class NotExecutedException extends RuntimeException {

    public NotExecutedException(String message) {
        super(message);
    }
}
