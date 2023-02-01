package com.bank.authorization.service;

import com.bank.authorization.entity.Role;
import com.bank.authorization.exception.RoleNotFoundException;
import com.bank.authorization.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

/**
 * Сервисный слой бизнес-логики сущности Role
 * Реализует методы интерфейса RoleService
 * Реализуется посредством JpaRepository класса RoleRepository
 * Методы:
 * getRoles() - возвращает список объектов Role
 * roleByID(id) - возвращает объект Role или бросает исключение RoleNotFoundException если в Optional - null
 * addRole(role) - добавляет объект Role в базу данных
 * updateRole(id, role) - обновляет объект Role в данных по id
 * deleteRole(id) - удаляет объект Role из базы данных по id
 *
 * @author Vladislav Shilov
 */

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

    @Override
    public Role roleByID(Long id) throws RoleNotFoundException {
        Optional<Role> role = roleRepository.findById(id);
        role.orElseThrow(RoleNotFoundException::new);
        return role.get();
    }

    @Transactional
    @Override
    public void addRole(Role role) {
        roleRepository.saveAndFlush(role);
    }

    @Override
    public void updateRole(long id, Role roleForUpdate) {
        roleForUpdate.setId(id);
        roleRepository.saveAndFlush(roleForUpdate);
    }

    @Override
    public void deleteRole(Long id) {
        roleRepository.deleteById(id);
    }
}
