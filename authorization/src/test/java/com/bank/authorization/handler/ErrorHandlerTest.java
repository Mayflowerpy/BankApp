package com.bank.authorization.handler;

import com.bank.authorization.exception.*;
import com.bank.authorization.util.AuditErrorResponse;
import com.bank.authorization.util.RoleErrorResponse;
import com.bank.authorization.util.UserErrorResponse;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import static org.assertj.core.api.Assertions.assertThat;

public class ErrorHandlerTest {

    private final ErrorHandler errorHandler = new ErrorHandler();

    @Test
    void testUserHandlerNotFoundException() {

        final ResponseEntity<UserErrorResponse> result = errorHandler.handlerException(new UserNotFoundException());

        assertThat(result.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
    }

    @Test
    void testRoleHandlerNotFoundException() {

        final ResponseEntity<RoleErrorResponse> result = errorHandler.handlerException(new RoleNotFoundException());

        assertThat(result.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
    }

    @Test
    void testAuditHandlerNotFoundException() {

        final ResponseEntity<AuditErrorResponse> result = errorHandler.handlerException(new AuditNotFoundException());

        assertThat(result.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
    }

    @Test
    void testUserHandlerNotCreatedException() {

        final ResponseEntity<UserErrorResponse> result = errorHandler.handlerException(new UserNotCreatedException("Error"));

        assertThat(result.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
    }

    @Test
    void testRoleHandlerNotCreatedException() {

        final ResponseEntity<RoleErrorResponse> result = errorHandler.handlerException(new RoleNotCreatedException("Error"));

        assertThat(result.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
    }

    @Test
    void testAuditHandlerNotCreatedException() {

        final ResponseEntity<AuditErrorResponse> result = errorHandler.handlerException(new AuditNotCreatedException("Error"));

        assertThat(result.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
    }
}
