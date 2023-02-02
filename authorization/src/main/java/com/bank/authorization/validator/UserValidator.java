package com.bank.authorization.validator;

import com.bank.authorization.entity.User;
import com.bank.authorization.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * Углубленная валидация данных сущности User
 * На данный момент здесь нет ни одной валидации
 *
 * @author Vladislav Shilov
 */

@Component
public class UserValidator implements Validator {

    UserServiceImpl userService;

    @Autowired
    public UserValidator(UserServiceImpl userService) {
        this.userService = userService;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        final User user = (User) target;

        //Валидация email, если существует в базе данных - reject
//        if(userService.getUserByEmail(user.getEmail() != null)) {
//            errors.rejectValue("email", "This email is already taken");
//        }
    }
}
