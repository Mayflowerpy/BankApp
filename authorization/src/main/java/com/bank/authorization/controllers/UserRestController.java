package com.bank.authorization.controllers;

import com.bank.authorization.dto.UserDTO;
import com.bank.authorization.exception.ProfileNotFoundException;
import com.bank.authorization.exception.UserNotCreatedException;
import com.bank.authorization.feign.ProfileFeignClient;
import com.bank.authorization.pojos.Profile;
import com.bank.authorization.service.UserService;
import com.bank.authorization.util.ErrBindingResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * REST-Controller для сущности User
 * Все методы возвращают ResponseEntity
 * Методы Post и Put принимают UserDTO
 * Методы Post и Put могут выбросить ошибку UserNotCreatedException(с сообщением, обработанным errBindingResult)
 * Метод GET вернет ошибку UserNotFoundException в случае несуществующей role
 * Выброшенные ошибки обрабатываются ErrorHandler, и возвращают сообщение ошибки и HttpStatus
 * Методы:
 * GET - getAllUsers()
 * GET - getUserById(id)
 * GET - getProfileByUsername(username) - обращение к profile для получения объекта Profile по полю email
 * GET - getAuthUser(authentication) - возвращает объект Profile авторизованного пользователя
 * POST - addUser(user)
 * PUT - editUserById(id, user)
 * DELETE - deleteUserById(id)
 *
 * @author Vladislav Shilov
 */

@RestController
public class UserRestController {

    private final UserService userService;
    private final ErrBindingResult errBindingResult;
    private final ProfileFeignClient profileFeignClient;

    @Autowired
    public UserRestController(UserService userService, ErrBindingResult errBindingResult,
                              ProfileFeignClient profileFeignClient) {
        this.userService = userService;
        this.errBindingResult = errBindingResult;
        this.profileFeignClient = profileFeignClient;
    }

    @GetMapping("/users")
    public ResponseEntity<List<UserDTO>> getAll() {
        return new ResponseEntity<>(userService.getAll()
                .stream()
                .map(userService::mapToDTO)
                .collect(Collectors.toList()), HttpStatus.OK);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable("id") long id) {
        return new ResponseEntity<>(userService.mapToDTO(userService.getById(id)), HttpStatus.OK);
    }

    @GetMapping
    public Optional<Profile> getProfileByUsername(@RequestParam String email) {
        return profileFeignClient.getProfileByUsername(email);
    }

    @GetMapping("/userView")
    public ResponseEntity<Profile> getAuthUser(Authentication auth) {
        return new ResponseEntity<>(getProfileByUsername(auth.getName()).orElseThrow(ProfileNotFoundException::new), HttpStatus.OK);
    }

    @PostMapping("/users")
    public ResponseEntity<String> add(@RequestBody @Valid UserDTO userDTO,
                                              BindingResult bindingResult) throws UserNotCreatedException {
        if (bindingResult.hasErrors()) {
            throw new UserNotCreatedException(errBindingResult.getErrorsFromBindingResult(bindingResult));
        }
        userService.add(userService.mapToUser(userDTO));
        return new ResponseEntity<>("User has been added", HttpStatus.OK);
    }

    @PutMapping("/users/{id}")
    public  ResponseEntity<String> update(@PathVariable("id") long id,
                                               @RequestBody @Valid UserDTO userDTO,
                                               BindingResult bindingResult) throws UserNotCreatedException {
        if (bindingResult.hasErrors()) {
            throw new UserNotCreatedException(errBindingResult.getErrorsFromBindingResult(bindingResult));
        }
        userService.update(id, userService.mapToUser(userDTO));
        return new ResponseEntity<>(String.format("User with id-%s has been updated", id), HttpStatus.OK);
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") long id) {
        userService.delete(id);
        return new ResponseEntity<>(String.format("User with id-%s has been deleted", id), HttpStatus.OK);
    }
}
