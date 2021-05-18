package com.pavlus.lab2.services;

import com.pavlus.lab2.models.Tourist;
import com.pavlus.lab2.repositories.TouristRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TouristService implements ITourist {

    TouristRepository touristRepository;
    @Autowired
    public TouristService(TouristRepository touristRepo) {
        this.touristRepository = touristRepo;
    }

    @Override
    public List<Tourist> getAllTourists() {
        // TODO Auto-generated method stub
        return touristRepository.findAll();
    }

    @Override
    public Optional<Tourist> findTouristById(int touristID) {
        // TODO Auto-generated method stub
        return touristRepository.findById(touristID);
    }

    @Override
    public Tourist createTourist(Tourist tourist) {
        // TODO Auto-generated method stub
        return touristRepository.save(tourist);
    }

    @Override
    public Tourist updateTourist(Tourist tourist) {
        // TODO Auto-generated method stub
        return touristRepository.save(tourist);
    }

    @Override
    public void deleteTouristById(int touristID) {
        // TODO Auto-generated method stub
        touristRepository.deleteById(touristID);
    }

    @Override
    public List<Optional<Tourist>> findTouristByLastName(String lastName) {
        // TODO Auto-generated method stub
        return touristRepository.findTouristByLastName(lastName);
    }

    @Override
    public Optional<Tourist> findTouristByEmail(String email) {
        // TODO Auto-generated method stub
        return touristRepository.findTouristByEmail(email);
    }

    @Override
    public Optional<Tourist> findTouristByPhoneNumber(String phoneNumber) {
        // TODO Auto-generated method stub
        return touristRepository.findTouristByPhoneNumber(phoneNumber);
    }

}

