package com.seacleaver.example.project.models;

import javax.persistence.Entity;

@Entity
public class Enemy extends Player{
    public Enemy(String name, int armour, int attackPoints, int magicPoints, int healthPoints) {
        super(name, armour, attackPoints, magicPoints, healthPoints);
    }

    public Enemy() {
    }
// What else can I add?

}
