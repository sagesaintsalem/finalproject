package com.seacleaver.example.project.models;

import com.seacleaver.example.project.enums.DoA;
import com.seacleaver.example.project.enums.PlayerClasses;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.ArrayList;

@Entity
public class NPCs extends Player{

    @Enumerated(value = EnumType.STRING)
    private PlayerClasses playerClass;
    public NPCs(String name, int armour, int attackPoints, int magicPoints, int healthPoints, DoA status, PlayerClasses playerClass) {
        super(name, armour, attackPoints, magicPoints, healthPoints, status);
        this.playerClass = playerClass;
    }

    public NPCs() {
    }

    public void castThunderbolt(Enemy enemy) {
        if(this.playerClass == PlayerClasses.MAGE) {
            int enemyHP = enemy.getHealthPoints();
            int attk = this.magicPoints * 2;
            int damage = enemyHP - attk;
            enemy.setHealthPoints(damage);
            if (enemy.getHealthPoints() <= 0) {
                enemy.setStatus(DoA.DEAD);
            }
        }
    }

    public void trueStrike(Enemy enemy) {
        if(this.playerClass == PlayerClasses.WARRIOR) {
            int enemyHP = enemy.getHealthPoints();
            int attk = this.attackPoints * 2;
            enemy.setHealthPoints(enemyHP - attk);
            if (enemy.getHealthPoints() <= 0) {
                enemy.setStatus(DoA.DEAD);
            }
        }
    }



}
