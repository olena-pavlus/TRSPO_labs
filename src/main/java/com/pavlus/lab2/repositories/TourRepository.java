package com.pavlus.lab2.repositories;

import com.pavlus.lab2.models.Tour;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TourRepository extends JpaRepository<Tour, Integer> {
    // Query method
    Optional<Tour> findTourByTourName(String tourName);
    List<Optional<Tour>> findTourByPrice(int price);
}

