package com.seacleaver.example.project.controllers;

import com.seacleaver.example.project.models.Kraken;
import com.seacleaver.example.project.models.Raid;
import com.seacleaver.example.project.models.Ship;
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
    public ResponseEntity<List<Raid>> Raids(){
        return new ResponseEntity<>(raidRepository.findAll(), HttpStatus.OK);
    }
}
