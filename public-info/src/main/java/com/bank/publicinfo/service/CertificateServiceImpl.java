package com.bank.publicinfo.service;

import com.bank.publicinfo.entity.BankDetails;
import com.bank.publicinfo.entity.Certificate;
import com.bank.publicinfo.exception.NotFoundException;
import com.bank.publicinfo.repository.CertificateRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CertificateServiceImpl implements CertificateService {

    private final CertificateRepository certificateRepository;

    public CertificateServiceImpl(CertificateRepository certificateRepository) {
        this.certificateRepository = certificateRepository;
    }

    @Override
    public Certificate findById(Long id) {
        return certificateRepository.findById(id).orElseThrow(NotFoundException::new);
    }

    @Override
    public Certificate findByBankDetails(BankDetails bankDetails) {
        return certificateRepository.findByBankDetails(bankDetails).orElseThrow(NotFoundException::new);
    }

    @Override
    public List<Certificate> findAll() {
        return certificateRepository.findAll();
    }

    @Override
    @Transactional
    public void delete(Long id) {
        certificateRepository.delete(findById(id));
    }

    @Override
    @Transactional
    public void save(Certificate certificate) {
        certificateRepository.save(certificate);
    }
}
