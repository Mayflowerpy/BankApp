package com.bank.publicinfo.service;

import com.bank.publicinfo.entity.BankDetails;
import com.bank.publicinfo.exception.NotFoundException;
import com.bank.publicinfo.repository.BankDetailsRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
public class BankDetailsServiceImpl implements BankDetailsService {

    private final BankDetailsRepository bankDetailsRepository;

    public BankDetailsServiceImpl(BankDetailsRepository bankDetailsRepository) {
        this.bankDetailsRepository = bankDetailsRepository;
    }

    @Override
    public BankDetails findById(Long id) {
        log.debug("Вызов метода findById() |id = " + id + "| в сервисе " + this.getClass());
        return bankDetailsRepository.findById(id).orElseThrow(() -> new NotFoundException(this.getClass() + " findById(), id = " + id));
    }

    @Override
    public List<BankDetails> findAll() {
        log.debug("Вызов метода findAll() в сервисе " + this.getClass());
        return bankDetailsRepository.findAll();
    }

    @Override
    @Transactional
    public void delete(Long id) {
        log.debug("Вызов метода deleteById() |id = " + id + "| в сервисе " + this.getClass());
        bankDetailsRepository.delete(findById(id));
    }

    @Override
    @Transactional
    public void save(BankDetails bankDetails) {
        log.debug("Вызов метода save() |Entity = " + bankDetails + "| в сервисе " + this.getClass());
        bankDetailsRepository.save(bankDetails);
    }
}