package com.bank.authorization.util;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class RoleErrorResponse {
    private String message;
    private Long timestamp;
}
