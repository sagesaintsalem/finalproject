package com.seacleaver.example.project.models;

import com.seacleaver.example.project.enums.ShipStatus;

import javax.persistence.*;

@Entity
@Table(name = "ships")
public class Ship {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "coffers")
    private int coffers;
    @Column(name = "HP")
    private int healthPoints;
    @Column(name = "armour")
    private int armour;
    @Column(name = "attkPoints")
    private int attkPoints;

    @Column(name = "status")
    @Enumerated(value = EnumType.STRING)
    private ShipStatus status;

    public Ship(String name, int coffers, int healthPoints, int armour, int attkPoints, ShipStatus status) {
        this.name = name;
        this.coffers = coffers;
        this.healthPoints = healthPoints;
        this.armour = armour;
        this.attkPoints = attkPoints;
        this.status = status;
    }

    public Ship(){};
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCoffers() {
        return coffers;
    }

    public void setCoffers(int coffers) {
        this.coffers = coffers;
    }

    public int getHealthPoints() {
        return healthPoints;
    }

    public void setHealthPoints(int healthPoints) {
        this.healthPoints = healthPoints;
    }

    public int getArmour() {
        return armour;
    }

    public void setArmour(int armour) {
        this.armour = armour;
    }

    public int getAttkPoints() {
        return attkPoints;
    }

    public void setAttkPoints(int attkPoints) {
        this.attkPoints = attkPoints;
    }

    public ShipStatus getStatus() {
        return status;
    }

    public void setStatus(ShipStatus status) {
        this.status = status;
    }

    public void addToCoffers(Raid raid){
        int money = raid.getLoot();
        this.setCoffers(this.coffers + money);
    }

    public void fireCannons(Ship enemyShip){
       int enemyHP = enemyShip.getHealthPoints();
       int attk = this.attkPoints;
       enemyShip.setHealthPoints((enemyHP - attk));
       if (enemyShip.getHealthPoints() <= 0){
           enemyShip.setStatus(ShipStatus.WRECKED);
       }
    }
}
