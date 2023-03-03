package com.seacleaver.example.project.controllers;

import com.seacleaver.example.project.models.NPCs;
import com.seacleaver.example.project.repositories.NPCRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class NpcController {

    @Autowired
    NPCRepository npcRepository;

    @GetMapping(value = "/npcs")
    public ResponseEntity<List<NPCs>> getAllNpcs(){
        return new ResponseEntity<>(npcRepository.findAll(), HttpStatus.OK);
        }
    }

