package com.bank.account.repository;

import com.bank.account.model.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Интерфейс, реализующий репозиторий для обращения к БД для сущности Account
 *
 * @author Dina Petrashova
 * @om 2023-01-30
 */

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

}
