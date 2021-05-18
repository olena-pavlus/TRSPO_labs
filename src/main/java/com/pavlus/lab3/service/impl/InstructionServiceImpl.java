package com.pavlus.lab3.service.impl;

import com.pavlus.lab3.model.Instruction;
import com.pavlus.lab3.repository.ForesterRepo;
import com.pavlus.lab3.repository.InstructionRepo;
import com.pavlus.lab3.service.InstructionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InstructionServiceImpl implements InstructionService {

    InstructionRepo instructionRepo;

    @Autowired
    public InstructionServiceImpl(InstructionRepo instructionRepo) {
        this.instructionRepo = instructionRepo;
    }

    @Override
    public Instruction save(Instruction instruction) {
        return instructionRepo.save(instruction);
    }

    @Override
    public void removeById(Integer id) {
        instructionRepo.deleteById(id);
    }

    @Override
    public Optional<Instruction> findById(Integer id) {
        return instructionRepo.findById(id);
    }

    @Override
    public List<Instruction> findAll() {
        return instructionRepo.findAll();
    }

}
