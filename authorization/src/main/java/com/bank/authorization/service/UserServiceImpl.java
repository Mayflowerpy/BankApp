package com.bank.authorization.service;

import com.bank.authorization.dto.UserDTO;
import com.bank.authorization.entity.User;
import com.bank.authorization.exception.UserNotFoundException;
import com.bank.authorization.mapper.UserMapper;
import com.bank.authorization.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

/**
 * Сервисный слой бизнес-логики сущности User
 * Реализует методы интерфейса UserService
 * Реализуется посредством JpaRepository класса UserRepository
 * Методы:
 * getUsers() - возвращает список объектов User
 * userByID(id) - возвращает объект User или бросает исключение RoleNotFoundException если в Optional - null
 * addUser(role) - добавляет объект User в базу данных, шифрует поле password посредством BCryptPasswordEncoder
 * updateUser(id, role) - обновляет объект User в данных по id, если пароль был изменен - повторно шифрует поле
 * deleteUser(id) - удаляет объект User из базы данных по id
 * mapToUser(userDTO) - преобразует объект UserDTO в объект User
 * mapToUserDTO(user) - преобразует объект User в объект UserDTO
 *
 * @author Vladislav Shilov
 */

@Service
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    @Autowired
    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public List<User> getUsersList() {
        return userRepository.findAll();
    }

    @Override
    public User getById(long id) {
        Optional<User> userById = userRepository.findById(id);
        userById.orElseThrow(UserNotFoundException::new);
        return userById.get();
    }

    @Transactional
    @Override
    public void addUser(User newUser) {
        newUser.setPassword(new BCryptPasswordEncoder().encode(newUser.getPassword()));
        userRepository.saveAndFlush(newUser);
    }

    @Transactional
    @Override
    public void updateUser(long id, User userForUpdate) {
        if (!getById(id).getPassword().equals(userForUpdate.getPassword())) {
            userForUpdate.setPassword(new BCryptPasswordEncoder().encode(userForUpdate.getPassword()));
        }
        userForUpdate.setId(id);
        userRepository.saveAndFlush(userForUpdate);
    }

    @Transactional
    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    public User mapToUser(UserDTO userDTO) {
        return userMapper.toUser(userDTO);
    }

    public UserDTO mapToUserDTO(User user) {
        return userMapper.toUserDTO(user);
    }
}
