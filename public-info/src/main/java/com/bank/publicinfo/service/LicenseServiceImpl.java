package com.bank.publicinfo.service;

import com.bank.publicinfo.entity.BankDetails;
import com.bank.publicinfo.entity.License;
import com.bank.publicinfo.exception.NotFoundException;
import com.bank.publicinfo.repository.LicenseRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class LicenseServiceImpl implements LicenseService {

    private final LicenseRepository licenseRepository;

    public LicenseServiceImpl(LicenseRepository licenseRepository) {
        this.licenseRepository = licenseRepository;
    }

    @Override
    public License findById(Long id) {
        return licenseRepository.findById(id).orElseThrow(NotFoundException::new);
    }

    @Override
    public License findByBankDetails(BankDetails bankDetails) {
        return licenseRepository.findByBankDetails(bankDetails).orElseThrow(NotFoundException::new);
    }

    @Override
    public List<License> findAll() {
        return licenseRepository.findAll();
    }

    @Override
    @Transactional
    public void delete(Long id) {
        licenseRepository.delete(findById(id));
    }

    @Override
    @Transactional
    public void save(License license) {
        licenseRepository.save(license);
    }
}
