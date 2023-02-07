package com.bank.publicinfo.service;

import com.bank.publicinfo.entity.Atm;
import com.bank.publicinfo.entity.Branch;

import java.util.List;

public interface AtmService {

    Atm findById(Long id);

    Atm findByBranch(Branch branch);

    List<Atm> findAll();

    void delete(Long id);

    void save(Atm atm);
}
