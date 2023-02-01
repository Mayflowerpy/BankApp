package com.bank.authorization.repository;

import com.bank.authorization.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * JPA-репозиторий для сущности User
 *
 * @author Vladislav Shilov
 */

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
