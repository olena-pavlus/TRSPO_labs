package com.pavlus.lab3.repository;

import com.pavlus.lab3.model.Tree;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TreeRepo extends JpaRepository<Tree, Integer>{
}
