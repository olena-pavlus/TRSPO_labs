package com.pavlus.lab3.service.impl;

import com.pavlus.lab3.model.Owner;
import com.pavlus.lab3.repository.OwnerRepo;
import com.pavlus.lab3.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OwnerServiceImpl implements OwnerService {

    OwnerRepo ownerRepo;

    @Autowired
    public OwnerServiceImpl(OwnerRepo ownerRepo) {
        this.ownerRepo = ownerRepo;
    }

    @Override
    public Owner save(Owner owner) {
        return ownerRepo.save(owner);
    }

    @Override
    public void removeById(Integer id) {
        ownerRepo.deleteById(id);
    }

    @Override
    public Optional<Owner> findById(Integer id) {
        return ownerRepo.findById(id);
    }

    @Override
    public List<Owner> findAll() {
        return ownerRepo.findAll();
    }

}
