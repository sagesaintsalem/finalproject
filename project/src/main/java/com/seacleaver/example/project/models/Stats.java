package com.seacleaver.example.project.models;

public class Stats {

    private int strength;
    private int magic;
    private int constitution;
    private int luck;

    public Stats(int strength, int magic, int constitution, int luck) {
        this.strength = strength;
        this.magic = magic;
        this.constitution = constitution;
        this.luck = luck;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getMagic() {
        return magic;
    }

    public void setMagic(int magic) {
        this.magic = magic;
    }

    public int getConstitution() {
        return constitution;
    }

    public void setConstitution(int constitution) {
        this.constitution = constitution;
    }

    public int getLuck() {
        return luck;
    }

    public void setLuck(int luck) {
        this.luck = luck;
    }
}
