package com.bank.transfer.services;

import com.bank.transfer.entities.AuditEntity;
import com.bank.transfer.entities.AuditOperationType;
import com.bank.transfer.entities.AbstractTransfer;
import com.bank.transfer.exceptions.TransferFailedException;

import java.util.List;

/**
 * Интерфейс по работе с записями аудита
 */
public interface AuditService {
    /**
     * Метод, выполняющий аудит банковской транзакции
     * @param auditedObject объект банковской транзакции, подлежащий аудиту
     * @param type - результат выполнения банковского перевода
     * @throws TransferFailedException - если запись аудита не была выполнена
     */
    void toAudit(AbstractTransfer auditedObject, AuditOperationType type) throws TransferFailedException;

    /**
     * Метод, возвращающий список записей аудита по id
     * @param id технический идентификатор записи аудита
     * @return запись аудита
     */
    AuditEntity getAuditById(Long id);
    /**
     * Метод, возвращающий список всех записей аудита
     * @return список записей аудита
     */
    List<AuditEntity> getAllAudits();
    /**
     * Метод, возвращающий список записей аудита по типу результата транзакций(успешная, неуспешная)
     * @param operationType тип результата выполнения транзакции
     * @return список записей аудита
     */
    List<AuditEntity> getAuditsByType(AuditOperationType operationType);
}
