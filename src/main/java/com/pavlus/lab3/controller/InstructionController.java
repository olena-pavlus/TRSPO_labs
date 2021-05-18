package com.pavlus.lab3.controller;

import com.pavlus.lab3.mapper.InstructionMapper;
import com.pavlus.lab3.model.Instruction;
import com.pavlus.lab3.model.dto.InstructionDTO;
import com.pavlus.lab3.service.InstructionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:9191")
@RestController
@RequestMapping("/instructions")
public class InstructionController {

    InstructionService instructionService;

    @Autowired
    public InstructionController(InstructionService instructionService) {
        this.instructionService = instructionService;
    }

    @GetMapping("/")
    public ResponseEntity<List<InstructionDTO>> findAll() {
        return ResponseEntity.ok(InstructionMapper.INSTANCE.instructionToInstructionDTOs(instructionService.findAll()));
    }

    @PostMapping("/")
    public ResponseEntity<InstructionDTO> create(@RequestBody InstructionDTO instructionDTO) {
        instructionService.save(InstructionMapper.INSTANCE.toInstruction(instructionDTO));

        return ResponseEntity.status(HttpStatus.CREATED).body(instructionDTO);
    }

    @GetMapping(value = "/instructionByCode/{instructionCode}")
    public ResponseEntity<InstructionDTO> findById(@PathVariable int instructionCode) {
        Optional<Instruction> instruction = instructionService.findById(instructionCode);

        return ResponseEntity.ok(InstructionMapper.INSTANCE.toDTO(instruction.get()));
    }

    @PutMapping("/{instructionCode}")
    public ResponseEntity<InstructionDTO> update(@PathVariable int instructionCode, @RequestBody InstructionDTO instructionDTO) {
        Instruction instruction = InstructionMapper.INSTANCE.toInstruction(instructionDTO);
        instruction.setInstructionCode(instructionCode);

        instructionService.save(instruction);

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(instructionDTO);
    }

    @DeleteMapping("/{instructionCode}")
    public ResponseEntity delete(@PathVariable int instructionCode) {
        instructionService.removeById(instructionCode);

        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

}
