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
    User getByProfileId(long id);
    List<User> getAll();
    void add(User newUser);
    void delete(Long id);
    void update(long id, User userForUpdate);
    User mapToUser(UserDTO userDTO);
    UserDTO mapToDTO(User user);
}
