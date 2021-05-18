package com.pavlus.lab2.services;

import com.pavlus.lab2.models.City;
import com.pavlus.lab2.models.Tour;
import com.pavlus.lab2.models.Tourist;
import com.pavlus.lab2.repositories.CityRepository;
import com.pavlus.lab2.repositories.TourRepository;
import com.pavlus.lab2.repositories.TouristRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TourService implements ITour {

    TourRepository tourRepository;
    TouristRepository touristRepository;
    CityRepository cityRepository;

    @Autowired
    public TourService(TourRepository tourRepository, TouristRepository touristRepository, CityRepository cityRepository) {
        this.tourRepository = tourRepository;
        this.touristRepository = touristRepository;
        this.cityRepository = cityRepository;
    }

    @Override
    public List<Tour> getAllTours() {
        // TODO Auto-generated method stub
        return tourRepository.findAll();
    }

    @Override
    public Optional<Tour> findTourByCode(int tourCode) {
        // TODO Auto-generated method stub
        return tourRepository.findById(tourCode);
    }

    @Override
    public Tour createTour(Tour tour) {
        // TODO Auto-generated method stub
        Tourist tourist = touristRepository.findById(tour.getTourist().getTouristID()).orElse(null);
        if(tourist == null){
            tourist = new Tourist();
        }
        tourist.setFirstName(tour.getTourist().getFirstName());
        tourist.setLastName(tour.getTourist().getLastName());
        tourist.setEmail(tour.getTourist().getEmail());
        tourist.setPhoneNumber(tour.getTourist().getPhoneNumber());
        tour.setTourist(tourist);

        City city = cityRepository.findById(tour.getCity().getCityCode()).orElse(null);
        if(city == null){
            city = new City();
        }
        city.setCityName(tour.getCity().getCityName());
        city.setCountryName(tour.getCity().getCountryName());
        tour.setCity(city);

        return tourRepository.save(tour);
    }

    @Override
    public Tour updateTour(Tour tour) {
        // TODO Auto-generated method stub
        return tourRepository.save(tour);
    }

    @Override
    public void deleteTourByCode(int tourCode) {
        // TODO Auto-generated method stub
        tourRepository.deleteById(tourCode);
    }

    @Override
    public Optional<Tour> findTourByTourName(String tourName) {
        // TODO Auto-generated method stub
        return tourRepository.findTourByTourName(tourName);
    }

    @Override
    public List<Optional<Tour>> findTourByPrice(int price) {
        // TODO Auto-generated method stub
        return tourRepository.findTourByPrice(price);
    }

}

