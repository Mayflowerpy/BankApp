package com.bank.authorization.service;

import com.bank.authorization.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.Optional;

/**
 * Класс необходимый для аутентификации и авторизации в приложении
 * Метод loadUserByUsername(String username) - подгружает пользователя из базы данных по полю Username
 * В случае если пользователь отсутствует - выбрасывает исключение UsernameNotFoundException
 * Метод возвращает объект UserDetails, включающий username, password, roles(authorities)
 *
 * @author Vladislav Shilov
 */

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserService userService;
    @Autowired
    public UserDetailsServiceImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        Optional<User> user = userService.getUserByEmail(username);
//        if (user.isEmpty()) {
//            throw new UsernameNotFoundException(String.format("User with mail %s not found", username));
//        } else {
//            return new org.springframework.security.core.userdetails.User(user.get().getEmail(), user.get().getPassword(), user.get().getAuthorities());
//        }
        return null; // Удалить!
    }
}
