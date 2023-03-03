package com.seacleaver.example.project.controllers;

import com.seacleaver.example.project.models.Kraken;
import com.seacleaver.example.project.repositories.BossRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class BossController {

    @Autowired
    BossRepository bossRepository;

    @GetMapping(value = "bosses")
    public ResponseEntity<List<Kraken>> getAllBosses(){
        return new ResponseEntity<>(bossRepository.findAll(), HttpStatus.OK);
    }
}
