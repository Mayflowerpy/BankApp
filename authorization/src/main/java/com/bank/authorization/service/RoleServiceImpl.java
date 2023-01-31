package com.bank.authorization.service;

import com.bank.authorization.entity.Role;
import com.bank.authorization.exception.RoleNotFoundException;
import com.bank.authorization.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class RoleServiceImpl implements RoleService{
    private final RoleRepository roleRepository;
    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public List<Role> getRoles() {
        return roleRepository.findAll();
    }

    @Transactional
    @Override
    public void addRole(Role role) {
        roleRepository.saveAndFlush(role);
    }

    @Override
    public Role roleByID(Long id) {
        Optional<Role> role = roleRepository.findById(id);
        role.orElseThrow(RoleNotFoundException::new);
        return role.get();
    }

    @Override
    public void deleteRole(Long id) {
        roleRepository.deleteById(id);
    }

    @Override
    public void updateRole(long id, Role roleForUpdate) {
        roleForUpdate.setId(id);
        roleRepository.saveAndFlush(roleForUpdate);
    }
}
