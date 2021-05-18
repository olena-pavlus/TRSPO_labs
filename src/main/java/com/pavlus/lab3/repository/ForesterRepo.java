package com.pavlus.lab3.repository;

import com.pavlus.lab3.model.Forester;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ForesterRepo extends JpaRepository<Forester, Integer>{
}
