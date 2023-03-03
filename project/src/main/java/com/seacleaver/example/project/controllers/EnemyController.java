package com.seacleaver.example.project.controllers;

import com.seacleaver.example.project.models.Enemy;
import com.seacleaver.example.project.repositories.EnemyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class EnemyController {
    @Autowired
    EnemyRepository enemyRepository;

    @GetMapping(value = "/enemies")
    public ResponseEntity<List<Enemy>> getAllEnemies(){
        return new ResponseEntity<>(enemyRepository.findAll(), HttpStatus.OK);
    }
}
