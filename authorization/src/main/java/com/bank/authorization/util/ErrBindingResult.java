package com.bank.authorization.util;

import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.stereotype.Component;
import java.util.stream.Collectors;

@Component
public class ErrBindingResult {

    public String getErrorsFromBindingResult(org.springframework.validation.BindingResult bindingResult) {
        return bindingResult.getFieldErrors()
                .stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .collect(Collectors.joining("; "));
    }
}
