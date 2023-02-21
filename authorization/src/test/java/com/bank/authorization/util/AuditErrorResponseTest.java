package com.bank.authorization.util;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AuditErrorResponseTest {

    private AuditErrorResponse expectedResult;

    @BeforeEach
    void setUp() {
        expectedResult = new AuditErrorResponse("message", 0L);
    }

    @Test
    void createResponse() {
        AuditErrorResponse actualResult = new AuditErrorResponse("message", 0L);

        Assertions.assertThat(expectedResult).isEqualTo(actualResult);
    }
}
