package com.seacleaver.example.project.models.charClasses;

import com.seacleaver.example.project.enums.DoA;
import com.seacleaver.example.project.models.Enemy;
import com.seacleaver.example.project.models.Player;

public abstract class CharClass extends Player {

    public CharClass(String name, int armour, int attackPoints, int magicPoints, int healthPoints, DoA status) {
        super(name, armour, attackPoints, magicPoints, healthPoints, status);
    }

    public CharClass() {
    }

    public abstract void attack(Enemy enemy);
}
