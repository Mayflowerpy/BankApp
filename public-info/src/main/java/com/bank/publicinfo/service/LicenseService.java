package com.bank.publicinfo.service;

import com.bank.publicinfo.entity.BankDetails;
import com.bank.publicinfo.entity.License;

import java.util.List;

public interface LicenseService {

    License findById(Long id);

    License findByBankDetails(BankDetails bankDetails);

    List<License> findAll();

    void delete(Long id);

    void save(License license);

}
