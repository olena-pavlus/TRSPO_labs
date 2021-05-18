package com.pavlus.lab2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.pavlus.lab2.models.Tourist;
import com.pavlus.lab2.services.TouristService;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:9191")
@RestController
@RequestMapping("/tourists")
public class TouristController {

    @Autowired
    private TouristService touristService;

    @GetMapping("/")
    public List<Tourist> getAllTourists() {
        return touristService.getAllTourists();
    }

    @GetMapping(value = "/userById/{id}")
    public Optional<Tourist> findTouristById(@PathVariable int id) {
        return touristService.findTouristById(id);
    }

    @GetMapping(value = "/userByLastName/{lastName}")
    public List<Optional<Tourist>> findTouristByLastName(@PathVariable String lastName) {
        return touristService.findTouristByLastName(lastName);
    }

    @GetMapping(value = "/userByEmail/{email}")
    public Optional<Tourist> findTouristByEmail(@PathVariable String email) {
        return touristService.findTouristByEmail(email);
    }

    @GetMapping(value = "/userByPhoneNumber/{phoneNumber}")
    public Optional<Tourist> findTouristByPhoneNumber(@PathVariable String phoneNumber) {
        return touristService.findTouristByPhoneNumber(phoneNumber);
    }

    @PostMapping("/")
    public Tourist createTourist(@RequestBody Tourist tourist) {
        return touristService.createTourist(tourist);
    }

//    @PutMapping(value="/")
//    public Tourist updateTourist(@RequestBody Tourist tourist) {
//        return touristService.updateTourist(tourist);
//    }

    @PutMapping("/{id}")
    public Tourist updateTourist(@PathVariable int id, @RequestBody Tourist tourist)
    {
        Optional<Tourist> tourists = touristService.findTouristById(id);
        Tourist tourist_new = tourists.get();
        tourist_new.setFirstName(tourist.getFirstName());
        tourist_new.setLastName(tourist.getLastName());
        tourist_new.setEmail(tourist.getEmail());
        tourist_new.setPhoneNumber(tourist.getPhoneNumber());
        return touristService.updateTourist(tourist_new);
    }

    @DeleteMapping("/{id}")
    public void deleteTouristById(@PathVariable int id) {
        touristService.deleteTouristById(id);
    }

}

