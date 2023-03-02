package com.seacleaver.example.project.models.charClasses;

import com.seacleaver.example.project.enums.DoA;
import com.seacleaver.example.project.interfaces.IWarrior;
import com.seacleaver.example.project.models.Player;

public class Warrior extends Player implements IWarrior {

    public Warrior(String name, int armour, int attackPoints, int magicPoints, int healthPoints, DoA status) {
        super(name, armour, attackPoints, magicPoints, healthPoints, status);
    }

    public Warrior() {
    }

    @Override
    public int trueStrike() {
        return this.getAttackPoints()*2;

    }
}
