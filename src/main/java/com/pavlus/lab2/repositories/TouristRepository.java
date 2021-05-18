package com.pavlus.lab2.repositories;

import com.pavlus.lab2.models.Tourist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TouristRepository extends JpaRepository<Tourist, Integer> {
    // Query method
    List<Optional<Tourist>> findTouristByLastName(String LastName);
    Optional<Tourist> findTouristByEmail(String email);
    Optional<Tourist> findTouristByPhoneNumber(String phoneNumber);
}

