package com.bank.authorization.controllers;

import com.bank.authorization.dto.UserDTO;
import com.bank.authorization.service.UserService;
import com.bank.authorization.util.ErrBindingResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class UserRestController {

    private final UserService userService;
    private final ErrBindingResult errBindingResult;
    @Autowired
    public UserRestController(UserService userService, ErrBindingResult errBindingResult) {
        this.userService = userService;
        this.errBindingResult = errBindingResult;
    }

    @GetMapping("/users")
    public ResponseEntity<List<UserDTO>> showAllUsers() {
        return new ResponseEntity<>(userService.getUsersList()
                .stream()
                .map(userService::mapToUserDTO)
                .collect(Collectors.toList()), HttpStatus.OK);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable("id") long id) {
        return new ResponseEntity<>(userService.mapToUserDTO(userService.getById(id)), HttpStatus.OK);
    }

    @PostMapping("/users")
    public ResponseEntity<String> authAddUser(@RequestBody @Valid UserDTO userDTO,
                                              BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(errBindingResult.getErrorsFromBindingResult(bindingResult),
                    HttpStatus.BAD_REQUEST);
        }

        userService.addUser(userService.mapToUser(userDTO));
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/users/{id}")
    public  ResponseEntity<String> authEditUser(@PathVariable("id") long id,
                                               @RequestBody @Valid UserDTO userDTO,
                                               BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(errBindingResult.getErrorsFromBindingResult(bindingResult),
                    HttpStatus.BAD_REQUEST);
        }

        userService.updateUser(id, userService.mapToUser(userDTO));
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<String> authDeleteUser (@PathVariable("id") long id) {

        userService.deleteUser(id);
        return new ResponseEntity<>(String.format("User with id-%s was deleted", id), HttpStatus.OK);
    }

//    @GetMapping("/userView")
//    public ResponseEntity<User> showUser(Authentication auth) {
//        return  new ResponseEntity<>(userService.getUserByEmail(auth.getName()).get(), HttpStatus.OK);
//    }
}