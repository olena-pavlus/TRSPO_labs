package com.pavlus.lab3.controller;

import com.pavlus.lab3.mapper.ForesterMapper;
import com.pavlus.lab3.model.Forester;
import com.pavlus.lab3.service.ForesterService;
import com.pavlus.lab3.model.dto.ForesterDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:9191")
@RestController
@RequestMapping("/foresters")
public class ForesterController {

    ForesterService foresterService;

    @Autowired
    public ForesterController(ForesterService foresterService) {
        this.foresterService = foresterService;
    }

    @GetMapping("/")
    public ResponseEntity<List<ForesterDTO>> findAll() {
        return ResponseEntity.ok(ForesterMapper.INSTANCE.foresterToForesterDTOs(foresterService.findAll()));
    }

    @PostMapping("/")
    public ResponseEntity<ForesterDTO> create(@RequestBody ForesterDTO foresterDTO) {
        foresterService.save(ForesterMapper.INSTANCE.toForester(foresterDTO));

        return ResponseEntity.status(HttpStatus.CREATED).body(foresterDTO);
    }

    @GetMapping(value = "/foresterByID/{foresterID}")
    public ResponseEntity<ForesterDTO> findById(@PathVariable int foresterID) {
        Optional<Forester> forester = foresterService.findById(foresterID);

        return ResponseEntity.ok(ForesterMapper.INSTANCE.toDTO(forester.get()));
    }

    @PutMapping("/{foresterID}")
    public ResponseEntity<ForesterDTO> update(@PathVariable int foresterID, @RequestBody ForesterDTO foresterDTO) {
        Forester forester = ForesterMapper.INSTANCE.toForester(foresterDTO);
        forester.setForesterID(foresterID);

        foresterService.save(forester);

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(foresterDTO);
    }

    @DeleteMapping("/{foresterID}")
    public ResponseEntity delete(@PathVariable int foresterID) {
        foresterService.removeById(foresterID);

        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

}
