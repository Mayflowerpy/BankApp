package com.bank.authorization.service;

import com.bank.authorization.dto.UserDTO;
import com.bank.authorization.entity.User;
import com.bank.authorization.exception.UserNotFoundException;
import com.bank.authorization.mapper.UserMapper;
import com.bank.authorization.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    @Autowired
    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public User getById(long id) {
        Optional<User> userById = userRepository.findById(id);
        userById.orElseThrow(UserNotFoundException::new);
        return userById.get();
    }

    @Override
    public List<User> getUsersList() {
        return userRepository.findAll();
    }

    @Transactional
    @Override
    public void addUser(User newUser) {
//        newUser.setPassword(new BCryptPasswordEncoder().encode(newUser.getPassword()));
        userRepository.saveAndFlush(newUser);
    }

    @Transactional
    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    @Transactional
    @Override
    public void updateUser(long id, User userForUpdate) {
//        if (!getById(id).getPassword().equals(userForUpdate.getPassword())) {
//            userForUpdate.setPassword(new BCryptPasswordEncoder().encode(userForUpdate.getPassword()));
//        }
        userForUpdate.setId(id);
        userRepository.saveAndFlush(userForUpdate);
    }

    public User mapToUser(UserDTO userDTO) {
        return userMapper.toUser(userDTO);
    }

    public UserDTO mapToUserDTO(User user) {
        return userMapper.toUserDTO(user);
    }
}
