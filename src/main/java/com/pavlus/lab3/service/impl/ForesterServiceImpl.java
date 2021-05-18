package com.pavlus.lab3.service.impl;

import com.pavlus.lab3.model.Forester;
import com.pavlus.lab3.repository.ForesterRepo;
import com.pavlus.lab3.service.ForesterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ForesterServiceImpl implements ForesterService {

    ForesterRepo foresterRepo;

    @Autowired
    public ForesterServiceImpl(ForesterRepo foresterRepo) {
        this.foresterRepo = foresterRepo;
    }

    @Override
    public Forester save(Forester forester) {
        return foresterRepo.save(forester);
    }

    @Override
    public void removeById(Integer id) {
        foresterRepo.deleteById(id);
    }

    @Override
    public Optional<Forester> findById(Integer id) {
        return foresterRepo.findById(id);
    }

    @Override
    public List<Forester> findAll() {
        return foresterRepo.findAll();
    }

}
