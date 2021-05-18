package com.pavlus.lab3.service.impl;

import com.pavlus.lab3.model.Tree;
import com.pavlus.lab3.repository.TreeRepo;
import com.pavlus.lab3.service.TreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TreeServiceImpl implements TreeService {

    TreeRepo treeRepo;

    @Autowired
    public TreeServiceImpl(TreeRepo treeRepo) {
        this.treeRepo = treeRepo;
    }

    @Override
    public Tree save(Tree tree) {
        return treeRepo.save(tree);
    }

    @Override
    public void removeById(Integer id) {
        treeRepo.deleteById(id);
    }

    @Override
    public Optional<Tree> findById(Integer id) {
        return treeRepo.findById(id);
    }

    @Override
    public List<Tree> findAll() {
        return treeRepo.findAll();
    }

}
