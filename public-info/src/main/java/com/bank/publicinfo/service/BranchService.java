package com.bank.publicinfo.service;

import com.bank.publicinfo.entity.Branch;

import java.util.List;

public interface BranchService {

    Branch findById(Long id);

    List<Branch> findAll();

    void delete(Long id);

    void save(Branch branch);
}
