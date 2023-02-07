package com.bank.publicinfo.service;

import com.bank.publicinfo.entity.BankDetails;
import com.bank.publicinfo.exception.NotFoundException;
import com.bank.publicinfo.repository.BankDetailsRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BankDetailsServiceImpl implements BankDetailsService {

    private final BankDetailsRepository bankDetailsRepository;

    public BankDetailsServiceImpl(BankDetailsRepository bankDetailsRepository) {
        this.bankDetailsRepository = bankDetailsRepository;
    }

    @Override
    public BankDetails findById(Long id) {
        return bankDetailsRepository.findById(id).orElseThrow(NotFoundException::new);
    }

    @Override
    public List<BankDetails> findAll() {
        return bankDetailsRepository.findAll();
    }

    @Override
    @Transactional
    public void delete(Long id) {
        bankDetailsRepository.delete(findById(id));
    }

    @Override
    @Transactional
    public void save(BankDetails bankDetails) {
        bankDetailsRepository.save(bankDetails);
    }
}
