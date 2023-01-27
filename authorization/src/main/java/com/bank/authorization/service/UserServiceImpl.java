package com.bank.authorization.service;

import com.bank.authorization.entity.User;
import com.bank.authorization.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;
    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User getById(long id) {
        Optional<User> userById = userRepository.findById(id);
        userById.orElseThrow(() -> new UsernameNotFoundException(String.format("User with id %s not found", id)));
        return userById.get();
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

    @Override
    public List<User> getUsersList() {
        return userRepository.findAll();
    }
}
