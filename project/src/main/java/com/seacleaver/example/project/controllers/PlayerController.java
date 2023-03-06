package com.seacleaver.example.project.controllers;


import com.seacleaver.example.project.models.UserCharacter;
import com.seacleaver.example.project.repositories.UserCharRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class PlayerController {

    @Autowired
    UserCharRepository userCharRepository;

    @GetMapping(value = "/players")
    public ResponseEntity<List<UserCharacter>>getAllPlayers(){
        return new ResponseEntity<>(userCharRepository.findAll(), HttpStatus.OK);
    }

    @PostMapping(value = "/players")
    public ResponseEntity<UserCharacter>createPlayer(@RequestBody UserCharacter player){
        userCharRepository.save(player);
        return new ResponseEntity<>(player, HttpStatus.CREATED);
    }
}
