package com.bank.authorization.controllers;

import com.bank.authorization.entity.Role;
import com.bank.authorization.service.RoleService;
import com.bank.authorization.util.ErrBindingResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RoleRestController {

    private final RoleService roleService;
    private final ErrBindingResult errBindingResult;
    @Autowired
    public RoleRestController(RoleService roleService, ErrBindingResult errBindingResult) {
        this.roleService = roleService;
        this.errBindingResult = errBindingResult;
    }

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

    @PutMapping("/users/roles/{id}")
    public  ResponseEntity<String> authEditRole(@PathVariable("id") long id,
                                                @RequestBody Role role,
                                                BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(errBindingResult.getErrorsFromBindingResult(bindingResult),
                    HttpStatus.BAD_REQUEST);
        }

        roleService.updateRole(id, role);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/users/roles/{id}")
    public ResponseEntity<String> authDeleteUser (@PathVariable("id") long id) {

        roleService.deleteRole(id);
        return new ResponseEntity<>(String.format("Role with id-%s was deleted", id), HttpStatus.OK);
    }
}
