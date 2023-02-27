package com.seacleaver.example.project.models;

import javax.persistence.Entity;

@Entity
public class NPCs extends Player{


    public NPCs(String name, int armour, int attackPoints, int magicPoints, int healthPoints) {
        super(name, armour, attackPoints, magicPoints, healthPoints);

    }

    public NPCs() {
    }
    // What else can I add?

}
