package com.seacleaver.example.project.controllers;


import com.seacleaver.example.project.models.Ship;
import com.seacleaver.example.project.repositories.ShipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ShipController {

    @Autowired
    ShipRepository shipRepository;

    @GetMapping(value = "/ships")
    public ResponseEntity<List<Ship>> getAllShips(){
        return new ResponseEntity<>(shipRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/ships/{id}")
    public ResponseEntity getShip(@PathVariable Long id){
        return new ResponseEntity<>(shipRepository.findById(id), HttpStatus.OK);
    }

    @PutMapping(value = "/ships/{id}")
    public ResponseEntity<Ship> addToCoffers(@RequestBody Ship richerShip, @PathVariable Long id){
        Ship shipToChange = shipRepository.findById(id).get();
        shipToChange.setName(richerShip.getName());
        shipToChange.setCoffers(richerShip.getCoffers());
        shipToChange.setHealthPoints(richerShip.getHealthPoints());
        shipToChange.setArmour(richerShip.getArmour());
        shipToChange.setAttkPoints(richerShip.getAttkPoints());
        shipToChange.setStatus(richerShip.getStatus());
        shipRepository.save(shipToChange);
        return new ResponseEntity<>(shipToChange, HttpStatus.OK);
    }

//    @PutMapping(value = "/ships/{id}")
//    public ResponseEntity<Ship> takeDamage(@RequestBody Ship hitShip, @PathVariable Long id){
//        Ship shipToChange = shipRepository.findById(id).get();
//        shipToChange.setHealthPoints(hitShip.getHealthPoints());
//        shipRepository.save(shipToChange);
//        return new ResponseEntity<>(shipToChange, HttpStatus.OK);
//    }
//
//    @PutMapping(value = "/ships/{id}")
//    public ResponseEntity<Ship> sinkShip(@RequestBody Ship sunkShip, @PathVariable Long id){
//        Ship shipToChange = shipRepository.findById(id).get();
//        shipToChange.setStatus(sunkShip.getStatus());
//        shipRepository.save(shipToChange);
//        return new ResponseEntity<>(shipToChange, HttpStatus.OK);
//    }

}
