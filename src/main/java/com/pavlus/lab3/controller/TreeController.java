package com.pavlus.lab3.controller;

import com.pavlus.lab3.mapper.ReportMapper;
import com.pavlus.lab3.mapper.TreeMapper;
import com.pavlus.lab3.model.Report;
import com.pavlus.lab3.model.Tree;
import com.pavlus.lab3.model.dto.ReportDTO;
import com.pavlus.lab3.model.dto.TreeDTO;
import com.pavlus.lab3.service.ReportService;
import com.pavlus.lab3.service.TreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:9191")
@RestController
@RequestMapping("/trees")
public class TreeController {

    TreeService treeService;

    @Autowired
    public TreeController(TreeService treeService) {
        this.treeService = treeService;
    }

    @GetMapping("/")
    public ResponseEntity<List<TreeDTO>> findAll() {
        return ResponseEntity.ok(TreeMapper.INSTANCE.treeToTreeDTOs(treeService.findAll()));
    }

    @PostMapping("/")
    public ResponseEntity<TreeDTO> create(@RequestBody TreeDTO treeDTO) {
        treeService.save(TreeMapper.INSTANCE.toTree(treeDTO));

        return ResponseEntity.status(HttpStatus.CREATED).body(treeDTO);
    }

    @GetMapping(value = "/treeByNumber/{treeNumber}")
    public ResponseEntity<TreeDTO> findById(@PathVariable int treeNumber) {
        Optional<Tree> tree = treeService.findById(treeNumber);

        return ResponseEntity.ok(TreeMapper.INSTANCE.toDTO(tree.get()));
    }

    @PutMapping("/{treeNumber}")
    public ResponseEntity<TreeDTO> update(@PathVariable int treeNumber, @RequestBody TreeDTO treeDTO) {
        Tree tree = TreeMapper.INSTANCE.toTree(treeDTO);
        tree.setNumber(treeNumber);

        treeService.save(tree);

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(treeDTO);
    }

    @DeleteMapping("/{treeNumber}")
    public ResponseEntity delete(@PathVariable int treeNumber) {
        treeService.removeById(treeNumber);

        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

}
