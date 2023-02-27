package com.seacleaver.example.project.models;

import javax.persistence.*;


@MappedSuperclass
@Table(name="players")
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
    private int attackPoints;
    @Column(name = "mag_points")
    private int magicPoints;
    @Column(name = "hp")
    private int healthPoints;

    public Player(String name, int armour, int attackPoints, int magicPoints, int healthPoints) {
        this.name = name;
        this.armour = armour;
        this.attackPoints = attackPoints;
        this.magicPoints = magicPoints;
        this.healthPoints = healthPoints;
    }

    public Player(){}

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
}
