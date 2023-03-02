package com.seacleaver.example.project.models;

import com.seacleaver.example.project.enums.DoA;
import com.seacleaver.example.project.enums.PlayerClasses;
import com.seacleaver.example.project.models.Player;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.Random;

@Entity
public class UserCharacter extends Player {

    private int str;
    private int mag;
    private int con;
    private int luck;

    @Enumerated(value = EnumType.STRING)
    private PlayerClasses playerClass;

    public UserCharacter(String name, int armour, int attackPoints, int magicPoints, int healthPoints, DoA status, int str, int mag, int con, int luck, PlayerClasses playerClass) {
        super(name, armour, attackPoints, magicPoints, healthPoints, status);
        this.str = str;
        this.mag = mag;
        this.con = con;
        this.luck = luck;
        this.playerClass = playerClass;
    }

    public UserCharacter() {

    }

    public int getStr() {
        return str;
    }

    public void setStr(int str) {
        this.str = str;
    }

    public int getMag() {
        return mag;
    }

    public void setMag(int mag) {
        this.mag = mag;
    }

    public int getCon() {
        return con;
    }

    public void setCon(int con) {
        this.con = con;
    }

    public int getLuck() {
        return luck;
    }

    public void setLuck(int luck) {
        this.luck = luck;
    }

    public void setUserHealthPoints(int con, int luck){
        this.setHealthPoints(con * 4);
    }

    public PlayerClasses getPlayerClass() {
        return playerClass;
    }

    public void setPlayerClass(PlayerClasses playerClass) {
        this.playerClass = playerClass;
    }

    public void rollStats(){
        Random random = new Random();
        int str = random.nextInt((18 - 5)) + 5;
        int magic = random.nextInt((18 - 5)) + 5;
        int consti = random.nextInt((18 - 5)) + 5;
        int luckk = random.nextInt((18 - 5)) + 5;
        this.setStr(str);
        this.setMag(magic);
        this.setCon(consti);
        this.setLuck(luckk);
    }

    public void determineArmourClass(){
        int userArmour = this.con + 3;
        this.setArmour(userArmour);
    }

    public void determineAttkAndMagic(){
        this.setAttackPoints(str);
        this.setMagicPoints(mag);
    }



    public PlayerClasses determineClass(int magicPoints, int attackPoints){
        if (magicPoints > attackPoints){
            this.setPlayerClass(PlayerClasses.MAGE);
        } else if (attackPoints > magicPoints){
            this.setPlayerClass(PlayerClasses.WARRIOR);
        }
        return this.playerClass;
    }

    public void buildCharacter(){
        this.rollStats();
        this.determineAttkAndMagic();
        this.determineArmourClass();
        this.setUserHealthPoints(con, luck);
        this.determineClass(mag, str);
        this.setStatus(DoA.ALIVE);
    }

//    public void determineSpecialMove(){
//        if (this.playerClass == PlayerClasses.MAGE){
//
//        }

    public void restartCharacter(){
        this.setMagicPoints(0);
        this.setArmour(0);
        this.setMag(0);
        this.setMagicPoints(0);
        this.setLuck(0);
        this.setStr(0);
        this.setCon(0);
        this.setAttackPoints(0);
        this.setHealthPoints(0);
    }


    }


