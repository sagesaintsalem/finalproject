package com.seacleaver.example.project.models;

import com.seacleaver.example.project.enums.DoA;
import com.seacleaver.example.project.enums.ShipStatus;

import javax.persistence.*;

@Entity
@Table(name = "bosses")
public class Kraken{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "armour")
    private int armour;
    @Column(name = "attkPoints")
    private int attkPoints;
    @Column(name = "hp")
    private int healthPoints;
    @Column(name = "magicPoints")
    private int magicPoints;

    @Column(name = "status")
    @Enumerated(value = EnumType.STRING)
    private DoA status;

    public Kraken(String name, int armour, int attkPoints, int healthPoints, int magicPoints, DoA status) {
        this.name = name;
        this.armour = armour;
        this.attkPoints = attkPoints;
        this.healthPoints = healthPoints;
        this.magicPoints = magicPoints;
        this.status = status;
    }

    public Kraken (){}

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

    public int getAttkPoints() {
        return attkPoints;
    }

    public void setAttkPoints(int attkPoints) {
        this.attkPoints = attkPoints;
    }

    public int getHealthPoints() {
        return healthPoints;
    }

    public void setHealthPoints(int healthPoints) {
        this.healthPoints = healthPoints;
    }

    public int getMagicPoints() {
        return magicPoints;
    }

    public void setMagicPoints(int magicPoints) {
        this.magicPoints = magicPoints;
    }

    public void tentaclePC(Player player){
        int playerHP = player.getHealthPoints();
        int attk = this.attkPoints;
        int afterHit = (playerHP - attk);
        player.setHealthPoints(afterHit);
        if(player.getHealthPoints() <= 0){
            player.setStatus(DoA.DEAD);
        }
    }

    public void tentacleShip(Ship ship){
        int shipHP = ship.getHealthPoints();
        int attk = this.attkPoints;
        int afterHit = (shipHP - attk);
        ship.setHealthPoints(afterHit);
        if(ship.getHealthPoints() <= 0){
            ship.setStatus(ShipStatus.WRECKED);
        }
    }

    public void tidalWave(Ship ship){
        int shipHP = ship.getHealthPoints();
        int magic = this.magicPoints;
        int afterSpell = (shipHP - magic);
        ship.setHealthPoints(afterSpell);
        if(ship.getHealthPoints() <= 0){
            ship.setStatus(ShipStatus.WRECKED);
        }
    }
}
