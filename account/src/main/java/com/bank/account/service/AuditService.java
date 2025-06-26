package com.bank.account.service;

import com.bank.account.model.dto.AuditDTO;
import com.bank.account.model.entity.Audit;

import java.util.List;

/**
 * Интерфейс, содержащий методы CRUD-операций для сущности Account.
 *
 * @author Dina Petrashova
 * @om 2023-02-01
 */

public interface AuditService {
    List<Audit> getAll();

    Audit getByID(Long id);

    void save(AuditDTO auditDTO);

    void update(AuditDTO auditDTO, Long id);

    void delete(Long id);
}
