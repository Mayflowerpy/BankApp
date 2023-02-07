package com.bank.publicinfo.service;

import com.bank.publicinfo.entity.Audit;

import java.util.List;

public interface AuditService {

    Audit findById(Long id);

    List<Audit> findAll();

    void delete(Long id);

    void save(Audit audit);
}
