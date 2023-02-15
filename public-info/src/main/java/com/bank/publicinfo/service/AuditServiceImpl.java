package com.bank.publicinfo.service;

import com.bank.publicinfo.entity.Audit;
import com.bank.publicinfo.exception.NotFoundException;
import com.bank.publicinfo.repository.AuditRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
public class AuditServiceImpl implements AuditService {

    private final AuditRepository auditRepository;

    public AuditServiceImpl(AuditRepository auditRepository) {
        this.auditRepository = auditRepository;
    }

    @Override
    public Audit findById(Long id) {
        log.debug("Вызов метода findById() |id = " + id + "| в сервисе " + this.getClass());
        return auditRepository.findById(id).orElseThrow(
                () -> new NotFoundException("Not found: " + this.getClass().getSimpleName() + ", findById(), id = " + id));
    }

    @Override
    public List<Audit> findAll() {
        log.debug("Вызов метода findAll() в сервисе " + this.getClass());
        return auditRepository.findAll();
    }

    @Override
    @Transactional
    public void delete(Long id) {
        log.debug("Вызов метода deleteById() |id = " + id + "| в сервисе " + this.getClass());
        auditRepository.delete(findById(id));
    }

    @Override
    @Transactional
    public void save(Audit audit) {
        log.debug("Вызов метода save() |Entity = " + audit + "| в сервисе " + this.getClass());
        auditRepository.save(audit);
    }
}
