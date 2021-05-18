package com.pavlus.lab2.services;

import com.pavlus.lab2.models.Tourist;

import java.util.List;
import java.util.Optional;

public interface ITourist {

    List<Tourist> getAllTourists();
    Optional<Tourist> findTouristById(int touristID);
    Tourist createTourist(Tourist tourist);
    Tourist updateTourist(Tourist tourist);
    void deleteTouristById(int touristID);
    List<Optional<Tourist>> findTouristByLastName(String lastName);
    Optional<Tourist> findTouristByEmail(String email);
    Optional<Tourist> findTouristByPhoneNumber(String email);
}
