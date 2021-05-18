package com.pavlus.lab3.controller;


import com.pavlus.lab3.mapper.OwnerMapper;
import com.pavlus.lab3.model.Instruction;
import com.pavlus.lab3.model.Owner;
import com.pavlus.lab3.model.dto.OwnerDTO;
import com.pavlus.lab3.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:9191")
@RestController
@RequestMapping("/owners")
public class OwnerController {

    OwnerService ownerService;

    @Autowired
    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @GetMapping("/")
    public ResponseEntity<List<OwnerDTO>> findAll() {
        return ResponseEntity.ok(OwnerMapper.INSTANCE.ownerToOwnerDTOs(ownerService.findAll()));
    }

    @PostMapping("/")
    public ResponseEntity<OwnerDTO> create(@RequestBody OwnerDTO ownerDTO) {
        ownerService.save(OwnerMapper.INSTANCE.toOwner(ownerDTO));

        return ResponseEntity.status(HttpStatus.CREATED).body(ownerDTO);
    }

    @GetMapping(value = "/ownerByID/{ownerID}")
    public ResponseEntity<OwnerDTO> findById(@PathVariable int ownerID) {
        Optional<Owner> owner = ownerService.findById(ownerID);

        return ResponseEntity.ok(OwnerMapper.INSTANCE.toDTO(owner.get()));
    }

    @PutMapping("/{ownerID}")
    public ResponseEntity<OwnerDTO> update(@PathVariable int ownerID, @RequestBody OwnerDTO ownerDTO) {
        Owner owner = OwnerMapper.INSTANCE.toOwner(ownerDTO);
        owner.setOwnerID(ownerID);

        ownerService.save(owner);

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(ownerDTO);
    }

    @DeleteMapping("/{ownerID}")
    public ResponseEntity delete(@PathVariable int ownerID) {
        ownerService.removeById(ownerID);

        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

}
