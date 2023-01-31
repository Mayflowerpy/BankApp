package com.bank.authorization.service;

import com.bank.authorization.entity.Role;
import java.util.List;

public interface RoleService {
    List<Role> getRoles();
    void addRole(Role role);
    Role roleByID(Long id);
    void deleteRole(Long id);
    void updateRole(long id, Role roleForUpdate);
}
