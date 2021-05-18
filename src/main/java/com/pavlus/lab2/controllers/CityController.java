package com.pavlus.lab2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.pavlus.lab2.models.City;
import com.pavlus.lab2.services.CityService;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:9191")
@RestController
@RequestMapping("/cities")
public class CityController {

    @Autowired
    private CityService cityService;

    @GetMapping("/")
    public List<City> getAllCities() {
        return cityService.getAllCities();
    }

    @GetMapping(value = "/cityByCode/{code}")
    public Optional<City> findCityByCode(@PathVariable int code) {
        return cityService.findCityByCode(code);
    }

    @GetMapping(value = "/cityByCountry/{countryName}")
    public List<Optional<City>> findCityByCountryName(@PathVariable String countryName) {
        return cityService.findCityByCountryName(countryName);
    }

    @PostMapping("/")
    public City createCity(@RequestBody City city) {
        return cityService.createCity(city);
    }

//    @PutMapping("/")
//    public City updateCity(@RequestBody City city) {
//        return cityService.updateCity(city);
//    }

    @PutMapping("/{code}")
    public City updateCity(@PathVariable int code, @RequestBody City city)
    {
        Optional<City> cities = cityService.findCityByCode(code);
        City city_new = cities.get();
        city_new.setCityName(city.getCityName());
        city_new.setCountryName(city.getCountryName());
        return cityService.updateCity(city_new);
    }

    @DeleteMapping("/")
    public void deleteCityByCode(@PathVariable int cityCode) {
        cityService.deleteCityByCode(cityCode);
    }

}

