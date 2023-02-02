package com.bank.authorization.util;

import com.bank.authorization.entity.Role;
import com.bank.authorization.entity.RoleEnum;
import com.bank.authorization.entity.User;
import com.bank.authorization.service.RoleService;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import com.bank.authorization.service.UserService;
import javax.annotation.PostConstruct;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Класс для инициализации баз данных user и roles, если они пустые
 * Добавляет две роли(Admin и User)
 * Добавляет двух пользователей(одного с ролью Admin, другого с ролью User)
 *
 * @author Vladislav Shilov
 */

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

        final Role roleAdmin = new Role(RoleEnum.ROLE_ADMIN);
        final Role roleUser = new Role(RoleEnum.ROLE_USER);

        if (roleService.getRoles().isEmpty()) {
            roleService.addRole(roleAdmin);
            roleService.addRole(roleUser);
        }

        if (userService.getUsersList().isEmpty()) {
            final Set<Role> adminRoles = new HashSet<>();
            Collections.addAll(adminRoles, roleService.roleByID(1L), roleService.roleByID(2L));
            final User admin = new User(adminRoles, 1L, "Admin1@");
            userService.addUser(admin);

            final Set<Role> userRoles = new HashSet<>();
            Collections.addAll(userRoles, roleService.roleByID(2L));
            final User user = new User(userRoles, 2L, "User1@");
            userService.addUser(user);
        }
    }
}
