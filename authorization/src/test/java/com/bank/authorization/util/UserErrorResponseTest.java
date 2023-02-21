package com.bank.authorization.util;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UserErrorResponseTest {

    private UserErrorResponse expectedResult;

    @BeforeEach
    void setUp() {
        expectedResult = new UserErrorResponse("message", 0L);
    }

    @Test
    void createResponse() {
        UserErrorResponse actualResult = new UserErrorResponse("message", 0L);

        Assertions.assertThat(expectedResult).isEqualTo(actualResult);
    }
}
