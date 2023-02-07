package com.bank.publicinfo.service;

import com.bank.publicinfo.entity.BankDetails;

import java.util.List;

public interface BankDetailsService {

    BankDetails findById(Long id);

    List<BankDetails> findAll();

    void delete(Long id);

    void save(BankDetails bankDetails);
}
