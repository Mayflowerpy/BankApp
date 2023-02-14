package com.bank.authorization.service;

import com.bank.authorization.dto.UserDTO;
import java.util.List;

/**
 * Сервисный интерфейс бизнес-логики сущности User
 * Реализация в классе UserServiceImpl
 *
 * @author Vladislav Shilov
 */

public interface UserService {
    List<UserDTO> getAll();
    UserDTO getById(long id);
    UserDTO getByProfileId(long id);
    void add(UserDTO newUser);
    void delete(Long id);
    void update(long id, UserDTO userForUpdate);
}
