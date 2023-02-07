package com.bank.publicinfo.service;

import com.bank.publicinfo.entity.Audit;
import com.bank.publicinfo.exception.NotFoundException;
import com.bank.publicinfo.repository.AuditRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AuditServiceImpl implements AuditService {

    private final AuditRepository auditRepository;

    public AuditServiceImpl(AuditRepository auditRepository) {
        this.auditRepository = auditRepository;
    }

    @Override
    public Audit findById(Long id) {
        return auditRepository.findById(id).orElseThrow(NotFoundException::new);
    }

    @Override
    public List<Audit> findAll() {
        return auditRepository.findAll();
    }

    @Override
    @Transactional
    public void delete(Long id) {
        auditRepository.delete(findById(id));
    }

    @Override
    @Transactional
    public void save(Audit audit) {
        auditRepository.save(audit);
    }
}
