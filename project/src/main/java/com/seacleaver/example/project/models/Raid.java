package com.seacleaver.example.project.models;
import javax.persistence.*;

@Entity
public class Raid {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "portName")
    private String portName;
    @Column(name = "loot")
    private int loot;
    @Column(name = "specialWeapon")
    private String specialWeapon;

    public Raid(String portName, int loot, String specialWeapon) {
        this.portName = portName;
        this.loot = loot;
        this.specialWeapon = specialWeapon;
    }

    public Raid(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPortName() {
        return portName;
    }

    public void setPortName(String portName) {
        this.portName = portName;
    }

    public int getLoot() {
        return loot;
    }

    public void setLoot(int loot) {
        this.loot = loot;
    }

    public String getSpecialWeapon() {
        return specialWeapon;
    }

    public void setSpecialWeapon(String specialWeapon) {
        this.specialWeapon = specialWeapon;
    }

    public void changePlayerWeapon(UserCharacter userCharacter){
        if(userCharacter.getLuck() >= 15 && this.specialWeapon == "gunblade"){
            userCharacter.setWeapon(this.specialWeapon);
        }
    }
}
