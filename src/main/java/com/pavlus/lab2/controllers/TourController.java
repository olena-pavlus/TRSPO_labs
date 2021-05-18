package com.pavlus.lab2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.pavlus.lab2.models.Tour;
import com.pavlus.lab2.services.TourService;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:9191")
@RestController
@RequestMapping("/tours")
public class TourController {

    @Autowired
    private TourService tourService;

    @GetMapping("/")
    public List<Tour> getAllTours() {
        return tourService.getAllTours();
    }

    @GetMapping(value = "/tourByCode/{code}")
    public Optional<Tour> findTourByCode(@PathVariable int code) {
        return tourService.findTourByCode(code);
    }

    @GetMapping(value = "/tourByName/{name}")
    public Optional<Tour> findTourByTourName(@PathVariable String name) {
        return tourService.findTourByTourName(name);
    }

    @GetMapping(value = "/tourByPrice/{price}")
    public List<Optional<Tour>> findTourByPrice(@PathVariable int price) {
        return tourService.findTourByPrice(price);
    }

    @PostMapping("/")
    public Tour createTour(@RequestBody Tour tour) {
        return tourService.createTour(tour);
    }

//    @PutMapping
//    public Tour updateTour(@RequestBody Tour tour) {
//        return tourService.updateTour(tour);
//    }

    @PutMapping("/{code}")
    public Tour updateTour(@PathVariable int code, @RequestBody Tour tour)
    {
        Optional<Tour> tours = tourService.findTourByCode(code);
        Tour tour_new = tours.get();
        tour_new.setTourName(tour.getTourName());
        tour_new.setDuration(tour.getDuration());
        tour_new.setPrice(tour.getPrice());
        tour_new.setDescription(tour.getDescription());
        return tourService.updateTour(tour_new);
    }

    @DeleteMapping("/{code}")
    public void deleteTourByCode(@PathVariable int tourCode) {
        tourService.deleteTourByCode(tourCode);
    }


}

