package com.bank.publicinfo.handler;

import com.bank.publicinfo.exception.NotFoundException;
import com.bank.publicinfo.util.ErrorResponse;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

class ErrorHandlerTest {

    private final ErrorHandler handler = new ErrorHandler();

    @Test
    void testHandlerException() {

        final ResponseEntity<ErrorResponse> result = handler.handlerException(new NotFoundException());

        assert(result.getStatusCode().equals(HttpStatus.NOT_FOUND));
    }
}
