package com.bank.publicinfo.service;

import com.bank.publicinfo.entity.Branch;
import com.bank.publicinfo.exception.NotFoundException;
import com.bank.publicinfo.repository.BranchRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
public class BranchServiceImpl implements BranchService {

    private final BranchRepository branchRepository;

    public BranchServiceImpl(BranchRepository branchRepository) {
        this.branchRepository = branchRepository;
    }

    @Override
    public Branch findById(Long id) {
        log.debug("Вызов метода findById() |id = " + id + "| в сервисе " + this.getClass());
        return branchRepository.findById(id).orElseThrow(
                () -> new NotFoundException("Not found: " + this.getClass().getSimpleName() + ", findById(), id = " + id));
    }

    @Override
    public List<Branch> findAll() {
        log.debug("Вызов метода findAll() в сервисе " + this.getClass());
        return branchRepository.findAll();
    }

    @Override
    @Transactional
    public void delete(Long id) {
        log.debug("Вызов метода deleteById() |id = " + id + "| в сервисе " + this.getClass());
        branchRepository.delete(findById(id));
    }

    @Override
    @Transactional
    public void save(Branch branch) {
        log.debug("Вызов метода save() |Entity = " + branch + "| в сервисе " + this.getClass());
        branchRepository.save(branch);
    }

}
