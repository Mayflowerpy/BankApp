package com.bank.publicinfo.service;

import com.bank.publicinfo.entity.Atm;
import com.bank.publicinfo.entity.Branch;
import com.bank.publicinfo.exception.NotFoundException;
import com.bank.publicinfo.repository.AtmRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AtmServiceImpl implements AtmService {

    private final AtmRepository atmRepository;

    public AtmServiceImpl(AtmRepository atmRepository) {
        this.atmRepository = atmRepository;
    }

    @Override
    public Atm findById(Long id) {
        return atmRepository.findById(id).orElseThrow(NotFoundException::new);
    }

    @Override
    public Atm findByBranch(Branch branch) {
        return atmRepository.findByBranch(branch).orElseThrow(NotFoundException::new);
    }

    @Override
    public List<Atm> findAll() {
        return atmRepository.findAll();
    }

    @Override
    @Transactional
    public void delete(Long id) {
        atmRepository.delete(findById(id));
    }

    @Override
    @Transactional
    public void save(Atm atm) {
        atmRepository.save(atm);
    }
}
