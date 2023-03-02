package com.seacleaver.example.project.models;

import com.seacleaver.example.project.enums.DoA;

import javax.persistence.Entity;
import java.util.ArrayList;

@Entity
public class NPCs extends Player{

    public NPCs(String name, int armour, int attackPoints, int magicPoints, int healthPoints, DoA status) {
        super(name, armour, attackPoints, magicPoints, healthPoints, status);
    }

    public NPCs() {
    }
    // What else can I add?

}
