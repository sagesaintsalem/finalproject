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
    public ResponseEntity<List<NPCs>> getAllNpcs() {
        return new ResponseEntity<>(npcRepository.findAll(), HttpStatus.OK);
    }


    @GetMapping(value = "/npcs/{id}")
    public ResponseEntity getNpc(@PathVariable Long id) {
        return new ResponseEntity<>(npcRepository.findById(id), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<NPCs> takeDamage(@RequestBody NPCs npc, @PathVariable Long id) {
        NPCs updatedNpc = npcRepository.findById(id).get();
        updatedNpc.setName(npc.getName());
        updatedNpc.setArmour(npc.getArmour());
        updatedNpc.setAttackPoints(npc.getAttackPoints());
        updatedNpc.setMagicPoints(npc.getMagicPoints());
        updatedNpc.setHealthPoints(npc.getHealthPoints());
        updatedNpc.setStatus(npc.getStatus());
        updatedNpc.setPlayerClass(npc.getPlayerClass());
        return new ResponseEntity<>(updatedNpc, HttpStatus.OK);
    }
}