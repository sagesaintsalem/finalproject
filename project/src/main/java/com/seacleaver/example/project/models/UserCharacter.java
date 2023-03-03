package com.seacleaver.example.project.models;

import com.seacleaver.example.project.enums.DoA;
import com.seacleaver.example.project.enums.PlayerClasses;
import com.seacleaver.example.project.models.Player;

import javax.persistence.*;
import java.util.Random;

@Entity
@Table(name = "player")
public class UserCharacter extends Player {

    @Column(name = "str")
    private int str;
    @Column(name = "mag")
    private int mag;
    @Column(name = "con")
    private int con;
    @Column(name = "luck")
    private int luck;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "player_class")
    private PlayerClasses playerClass;

    @Column(name = "weapon")
    private String weapon;

    public UserCharacter(String name, int armour, int attackPoints, int magicPoints, int healthPoints, DoA status, int str, int mag, int con, int luck, PlayerClasses playerClass, String weapon) {
        super(name, armour, attackPoints, magicPoints, healthPoints, status);
        this.str = str;
        this.mag = mag;
        this.con = con;
        this.luck = luck;
        this.playerClass = playerClass;
        this.weapon = weapon;
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

    public String getWeapon() {
        return weapon;
    }

    public void setWeapon(String weapon) {
        this.weapon = weapon;
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

    public void starterWeapon(){
        if(this.playerClass == PlayerClasses.MAGE){
            this.setWeapon("staff");
        } else if (this.playerClass == PlayerClasses.WARRIOR){
            this.setWeapon("cutlass");
        }
    }

    public void buildCharacter(){
        this.rollStats();
        this.determineAttkAndMagic();
        this.determineArmourClass();
        this.setUserHealthPoints(con, luck);
        this.determineClass(mag, str);
        this.setStatus(DoA.ALIVE);
        this.starterWeapon();
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

    public void withGunblade(){
        int attk = this.getAttackPoints();
        int magic = this.getMagicPoints();
        if(this.weapon == "gunblade"){
            this.setAttackPoints(attk+5);
            this.setMagicPoints(magic+5);
        }
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


