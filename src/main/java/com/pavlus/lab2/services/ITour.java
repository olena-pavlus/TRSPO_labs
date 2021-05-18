package com.pavlus.lab2.services;

import com.pavlus.lab2.models.Tour;

import java.util.List;
import java.util.Optional;

public interface ITour {

    List<Tour> getAllTours();
    Optional<Tour> findTourByCode(int tourCode);
    Tour createTour(Tour city);
    Tour updateTour(Tour city);
    void deleteTourByCode(int tourCode);
    Optional<Tour> findTourByTourName(String tourName);
    List<Optional<Tour>> findTourByPrice(int price);

}
