package com.pavlus.lab2.services;

import com.pavlus.lab2.models.City;

import java.util.List;
import java.util.Optional;

public interface ICity {

    List<City> getAllCities();
    Optional<City> findCityByCode(int cityCode);
    City createCity(City city);
    City updateCity(City city);
    void deleteCityByCode(int cityCode);
    List<Optional<City>> findCityByCountryName(String countryName);

}
