package com.pavlus.lab2.repositories;

import com.pavlus.lab2.models.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CityRepository extends JpaRepository<City, Integer> {
    // Query method
    List<Optional<City>> findCityByCountryName(String countryName);
}

