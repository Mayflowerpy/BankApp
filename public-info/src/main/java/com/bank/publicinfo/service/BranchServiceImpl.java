package com.bank.publicinfo.service;

import com.bank.publicinfo.entity.Branch;
import com.bank.publicinfo.exception.NotFoundException;
import com.bank.publicinfo.repository.BranchRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BranchServiceImpl implements BranchService {

    private final BranchRepository branchRepository;

    public BranchServiceImpl(BranchRepository branchRepository) {
        this.branchRepository = branchRepository;
    }

    @Override
    public Branch findById(Long id) {
        return branchRepository.findById(id).orElseThrow(NotFoundException::new);
    }

    @Override
    public List<Branch> findAll() {
        return branchRepository.findAll();
    }

    @Override
    @Transactional
    public void delete(Long id) {
        branchRepository.delete(findById(id));
    }

    @Override
    @Transactional
    public void save(Branch branch) {
        branchRepository.save(branch);
    }

}
