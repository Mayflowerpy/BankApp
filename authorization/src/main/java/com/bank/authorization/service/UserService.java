package com.bank.authorization.service;

import com.bank.authorization.dto.UserDTO;
import com.bank.authorization.entity.User;
import java.util.List;

/**
 * Сервисный интерфейс бизнес-логики сущности User
 * Реализация в классе UserServiceImpl
 *
 * @author Vladislav Shilov
 */

public interface UserService {
    User getById(long id);
    List<User> getUsersList();
    void addUser(User newUser);
    void deleteUser(Long id);
    void updateUser(long id, User userForUpdate);
    User mapToUser(UserDTO userDTO);
    UserDTO mapToUserDTO(User user);
}
