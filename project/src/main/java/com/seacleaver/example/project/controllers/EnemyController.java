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

    @PutMapping(value = "/enemies/{id}")
    public ResponseEntity<Enemy> takeDamage(@RequestBody Enemy hitEnemy, @PathVariable Long id){
        Enemy existingEnemy = enemyRepository.findById(id).get();
        existingEnemy.setName(hitEnemy.getName());
        existingEnemy.setArmour(hitEnemy.getArmour());
        existingEnemy.setAttackPoints(hitEnemy.getAttackPoints());
        existingEnemy.setMagicPoints(hitEnemy.getMagicPoints());
        existingEnemy.setHealthPoints(hitEnemy.getHealthPoints());
        existingEnemy.setStatus(hitEnemy.getStatus());
        return new ResponseEntity<>(existingEnemy, HttpStatus.OK);
    }
}
