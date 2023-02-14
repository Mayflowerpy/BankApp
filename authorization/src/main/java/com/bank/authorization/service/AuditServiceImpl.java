package com.bank.authorization.service;

import com.bank.authorization.dto.AuditDTO;
import com.bank.authorization.entity.Audit;
import com.bank.authorization.exception.AuditNotFoundException;
import com.bank.authorization.mapper.AuditMapper;
import com.bank.authorization.repository.AuditRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

/**
 * Сервисный слой бизнес-логики сущности Audit
 * Реализует методы интерфейса AuditService
 * Реализуется посредством JpaRepository класса AuditRepository
 * Методы:
 * getUsers() - возвращает список объектов AuditDTO
 * getById(id) - возвращает объект AuditDTO или бросает исключение AuditNotFoundException если в Optional - null
 * add(audit) - добавляет объект Audit в базу данных
 * update(id, audit) - обновляет объект Audit в данных по id
 * delete(id) - удаляет объект Audit из базы данных по id
 *
 * @author Vladislav Shilov
 */

@Service
@Transactional(readOnly = true)
public class AuditServiceImpl implements AuditService {

    private final AuditRepository auditRepository;
    private final AuditMapper auditMapper;
    @Autowired
    public AuditServiceImpl(AuditRepository auditRepository, AuditMapper auditMapper) {
        this.auditRepository = auditRepository;
        this.auditMapper = auditMapper;
    }

    @Override
    public List<AuditDTO> getAll() {
        return auditMapper.toDTOList(auditRepository.findAll());
    }

    @Override
    public AuditDTO getById(Long id) {
        final Optional<Audit> auditById = auditRepository.findById(id);
        return auditMapper.toDTO(auditById.orElseThrow(AuditNotFoundException::new));
    }

    @Transactional
    @Override
    public void add(AuditDTO auditDTO) {
        auditRepository.saveAndFlush(auditMapper.toAudit(auditDTO));
    }

    @Transactional
    @Override
    public void update(AuditDTO auditDTO, Long id) {
        auditDTO.setId(id);
        auditRepository.saveAndFlush(auditMapper.toAudit(auditDTO));
    }

    @Override
    public void delete(Long id) {
        auditRepository.deleteById(id);
    }
}
