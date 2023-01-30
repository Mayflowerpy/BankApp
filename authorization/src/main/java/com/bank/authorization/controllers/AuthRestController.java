package com.bank.authorization.controllers;

import com.bank.authorization.entity.Role;
import com.bank.authorization.entity.User;
import com.bank.authorization.service.RoleService;
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
import java.util.List;

@RestController
public class AuthRestController {

    private final UserService userService;
    private final RoleService roleService;
    private final ErrBindingResult errBindingResult;
    @Autowired
    public AuthRestController(UserService userService, RoleService roleService, ErrBindingResult errBindingResult) {
        this.userService = userService;
        this.roleService = roleService;
        this.errBindingResult = errBindingResult;
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> showAllUsers() {
        return new ResponseEntity<>(userService.getUsersList(), HttpStatus.OK);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") long id) {
        return new ResponseEntity<>(userService.getById(id), HttpStatus.OK);
    }

    @PostMapping("/users")
    public ResponseEntity<String> authAddUser(@RequestBody User user,
                                              BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(errBindingResult.getErrorsFromBindingResult(bindingResult),
                    HttpStatus.BAD_REQUEST);
        }

        userService.addUser(user);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/users/{id}")
    public  ResponseEntity<String> authEditUser(@PathVariable("id") long id,
                                               @RequestBody User user,
                                               BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(errBindingResult.getErrorsFromBindingResult(bindingResult),
                    HttpStatus.BAD_REQUEST);
        }

        userService.updateUser(id, user);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<String> authDeleteUser (@PathVariable("id") long id) {

        userService.deleteUser(id);
        return new ResponseEntity<>(String.format("User with id-%s was deleted", id), HttpStatus.OK);
    }

//    @GetMapping("/authUser")
//    public ResponseEntity<User> showUser(Authentication auth) {
//        return  new ResponseEntity<>(userService.getUserByEmail(auth.getName()).get(), HttpStatus.OK);
//    }

    @GetMapping("/users/roles")
    public ResponseEntity<List<Role>> getAllRoles() {
        return new ResponseEntity<>(roleService.getRoles(), HttpStatus.OK);
    }

    @GetMapping("/users/roles/{id}")
    ResponseEntity<Role> getRoleById(@PathVariable("id") long id){
        return new ResponseEntity<>(roleService.roleByID(id), HttpStatus.OK);
    }

    @PostMapping("/users/roles")
    public ResponseEntity<String> authAddRole(@RequestBody Role role,
                                              BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(errBindingResult.getErrorsFromBindingResult(bindingResult),
                    HttpStatus.BAD_REQUEST);
        }

        roleService.addRole(role);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}