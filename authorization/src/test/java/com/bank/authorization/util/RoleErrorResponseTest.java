package com.bank.authorization.util;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RoleErrorResponseTest {

    private RoleErrorResponse expectedResult;

    @BeforeEach
    void setUp() {
        expectedResult = new RoleErrorResponse("message", 0L);
    }

    @Test
    void createResponse() {
        RoleErrorResponse actualResult = new RoleErrorResponse("message", 0L);

        Assertions.assertThat(expectedResult).isEqualTo(actualResult);
    }
}
