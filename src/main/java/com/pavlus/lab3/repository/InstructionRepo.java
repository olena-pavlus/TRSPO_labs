package com.pavlus.lab3.repository;

import com.pavlus.lab3.model.Instruction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstructionRepo extends JpaRepository<Instruction, Integer>{
}
