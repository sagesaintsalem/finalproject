package com.seacleaver.example.project.controllers;

import com.seacleaver.example.project.models.Raid;

import com.seacleaver.example.project.repositories.RaidRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class RaidController {

    @Autowired
    RaidRepository raidRepository;

    @GetMapping(value = "raids")
    public ResponseEntity<List<Raid>> Raids() {
        return new ResponseEntity<>(raidRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/raids/{id}")
    public ResponseEntity getRaid(@PathVariable Long id){
        return new ResponseEntity<>(raidRepository.findById(id), HttpStatus.OK);
    }


    @PutMapping(value = "raids/loot/{id}")
    public ResponseEntity<Raid> lootRouge(@RequestBody Raid updatedPort, @PathVariable Long id) {
        Raid raidtoChange = raidRepository.findById(id).get();
        raidtoChange.setLoot(updatedPort.getLoot());
        raidtoChange.setSpecialWeapon(updatedPort.getSpecialWeapon());
        raidRepository.save(raidtoChange);
        return new ResponseEntity<>(raidtoChange, HttpStatus.OK);
    }
//
//    @PutMapping(value = "raids/{id}")
//    public ResponseEntity<Raid> getSecretWeapon(@RequestBody Raid updatedPort, @PathVariable Long id) {
//        Raid raidtoChange = raidRepository.findById(id).get();
//        raidtoChange.setSpecialWeapon(updatedPort.getSpecialWeapon());
//        raidRepository.save(raidtoChange);
//        return new ResponseEntity<>(raidtoChange, HttpStatus.OK);
    }
