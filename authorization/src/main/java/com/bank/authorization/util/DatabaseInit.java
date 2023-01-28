package com.bank.authorization.util;

import com.bank.authorization.entity.Role;
import com.bank.authorization.entity.User;
import com.bank.authorization.service.RoleService;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import com.bank.authorization.service.UserService;
import javax.annotation.PostConstruct;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Component
public class DatabaseInit {
    private final UserService userService;
    private final RoleService roleService;
    @Autowired
    public DatabaseInit(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @PostConstruct
    public void initDbUsers() {

        Role roleAdmin = new Role("ROLE_ADMIN");
        Role roleUser = new Role("ROLE_USER");

        if (roleService.getRoles().isEmpty()) {
            roleService.addRole(roleAdmin);
            roleService.addRole(roleUser);
        }

        if (userService.getUsersList().isEmpty()) {
            Set<Role> adminRoles = new HashSet<>();
            Collections.addAll(adminRoles, roleService.roleByID(1L), roleService.roleByID(2L));
            User admin = new User(adminRoles, 1L, "admin");
            userService.addUser(admin);

            Set<Role> userRoles = new HashSet<>();
            Collections.addAll(userRoles, roleService.roleByID(2L));
            User user = new User(userRoles, 2L, "user");
            userService.addUser(user);
        }
    }
}
