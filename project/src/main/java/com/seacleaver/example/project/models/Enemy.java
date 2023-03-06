package com.seacleaver.example.project.models;

import com.seacleaver.example.project.enums.DoA;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "enemies")


public class Enemy extends Player{
    public Enemy(String name, int armour, int attackPoints, int magicPoints, int healthPoints, DoA status) {
        super(name, armour, attackPoints, magicPoints, healthPoints, status);
    }

    public Enemy() {
    }



    public void dive(Player pc){
       int pcHP = pc.getHealthPoints();
       int attk = this.attackPoints * 2;
       int damage = pcHP - attk;
       pc.setHealthPoints(damage);
       if (pc.getHealthPoints() <= 0){
           pc.setStatus(DoA.DEAD);
       }

    }

}
