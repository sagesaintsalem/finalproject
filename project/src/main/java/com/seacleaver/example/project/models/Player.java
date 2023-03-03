package com.seacleaver.example.project.models;



import com.seacleaver.example.project.enums.DoA;
import com.seacleaver.example.project.enums.PlayerClasses;
import com.seacleaver.example.project.repositories.PlayerRepository;

import javax.persistence.*;
import java.util.ArrayList;



@MappedSuperclass
//@Table(name="players")
public abstract class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "armour")
    private int armour;
    @Column(name = "attk_points")
    int attackPoints;
    @Column(name = "mag_points")
    int magicPoints;
    @Column(name = "hp")
    private int healthPoints;

    @Column(name = "status")
    @Enumerated(value = EnumType.STRING)
    private DoA status;

    public Player(String name, int armour, int attackPoints, int magicPoints, int healthPoints, DoA status) {
        this.name = name;
        this.armour = armour;
        this.attackPoints = attackPoints;
        this.magicPoints = magicPoints;
        this.healthPoints = healthPoints;
        this.status = status;


    }

    public Player() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public int getArmour() {
        return armour;
    }

    public void setArmour(int armour) {
        this.armour = armour;
    }

    public int getAttackPoints() {
        return attackPoints;
    }

    public void setAttackPoints(int attackPoints) {
        this.attackPoints = attackPoints;
    }

    public int getMagicPoints() {
        return magicPoints;
    }

    public void setMagicPoints(int magicPoints) {
        this.magicPoints = magicPoints;
    }

    public int getHealthPoints() {
        return healthPoints;
    }

    public void setHealthPoints(int healthPoints) {
        this.healthPoints = healthPoints;
    }

    public DoA getStatus() {
        return status;
    }

    public void setStatus(DoA status) {
        this.status = status;
    }

    public void attack(Player player) {
        int enemyHP = player.getHealthPoints();
        int attk = this.attackPoints;
        player.setHealthPoints((enemyHP - attk));
    }

    public void heal() {
        int HP = this.healthPoints;
        int magic = this.magicPoints;
        this.setHealthPoints(HP + magic);
    }


}

