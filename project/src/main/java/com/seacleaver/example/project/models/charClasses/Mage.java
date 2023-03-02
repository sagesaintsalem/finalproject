package com.seacleaver.example.project.models.charClasses;

import com.seacleaver.example.project.enums.DoA;
import com.seacleaver.example.project.interfaces.IMage;
import com.seacleaver.example.project.models.Enemy;
import com.seacleaver.example.project.models.Player;

public class Mage extends Player implements IMage {

    public Mage(String name, int armour, int attackPoints, int magicPoints, int healthPoints, DoA status) {
        super(name, armour, attackPoints, magicPoints, healthPoints, status);
    }

    public Mage() {
    }


}
