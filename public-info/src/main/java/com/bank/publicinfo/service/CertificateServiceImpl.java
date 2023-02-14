package com.bank.publicinfo.service;

import com.bank.publicinfo.entity.BankDetails;
import com.bank.publicinfo.entity.Certificate;
import com.bank.publicinfo.exception.NotFoundException;
import com.bank.publicinfo.repository.CertificateRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
public class CertificateServiceImpl implements CertificateService {

    private final CertificateRepository certificateRepository;

    public CertificateServiceImpl(CertificateRepository certificateRepository) {
        this.certificateRepository = certificateRepository;
    }

    @Override
    public Certificate findById(Long id) {
        log.debug("Вызов метода findById() |id = " + id + "| в сервисе " + this.getClass());
        return certificateRepository.findById(id).orElseThrow(() -> new NotFoundException(this.getClass() + " findById(), id = " + id));
    }

    @Override
    public Certificate findByBankDetails(BankDetails bankDetails) {
        log.debug("Вызов метода findByBankDetails() |Bank details = " + bankDetails + "| в сервисе " + this.getClass());
        return certificateRepository.findByBankDetails(bankDetails).orElseThrow(
                () -> new NotFoundException(this.getClass() + " findByBankDetails(), bank details = " + bankDetails));
    }

    @Override
    public List<Certificate> findAll() {
        log.debug("Вызов метода findAll() в сервисе " + this.getClass());
        return certificateRepository.findAll();
    }

    @Override
    @Transactional
    public void delete(Long id) {
        log.debug("Вызов метода deleteById() |id = " + id + "| в сервисе " + this.getClass());
        certificateRepository.delete(findById(id));
    }

    @Override
    @Transactional
    public void save(Certificate certificate) {
        log.debug("Вызов метода save() |Entity = " + certificate + "| в сервисе " + this.getClass());
        certificateRepository.save(certificate);
    }
}