package com.seacleaver.example.project.enums;

import com.seacleaver.example.project.models.Player;

public enum PlayerClasses {

    MAGE,
    WARRIOR;


    public void castThunderbolt(Player enemy, Player caster) {

        int enemyHP = enemy.getHealthPoints();
        int attk = caster.getMagicPoints() * 2;
        int damage = enemyHP - attk;
        enemy.setHealthPoints(damage);
        if (enemy.getHealthPoints() <= 0) {
            enemy.setStatus(DoA.DEAD);
        }
    }


}
