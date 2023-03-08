package com.seacleaver.example.project.components;

import com.seacleaver.example.project.enums.DoA;
import com.seacleaver.example.project.enums.PlayerClasses;
import com.seacleaver.example.project.enums.ShipStatus;
import com.seacleaver.example.project.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import com.seacleaver.example.project.repositories.PlayerRepository;
import com.seacleaver.example.project.repositories.ShipRepository;
import com.seacleaver.example.project.repositories.RaidRepository;
import com.seacleaver.example.project.repositories.BossRepository;
import com.seacleaver.example.project.repositories.NPCRepository;
import com.seacleaver.example.project.repositories.EnemyRepository;
import com.seacleaver.example.project.repositories.UserCharRepository;


@Profile("!test") //Run every time EXCEPT Tests
@Component
public class DataLoader implements ApplicationRunner{
    @Autowired
    UserCharRepository userCharRepository;

    @Autowired
    ShipRepository shipRepository;

    @Autowired
    RaidRepository raidRepository;

    @Autowired
    BossRepository bossRepository;

    @Autowired
    NPCRepository npcRepository;

    @Autowired
    EnemyRepository enemyRepository;

    public DataLoader() {

    }

    public void run(ApplicationArguments args){
        Ship seacleaver = new Ship("The Seacleaver", 0, 200, 17, 40, ShipStatus.SAILING);
        shipRepository.save(seacleaver);

        Ship ursula = new Ship("Ursula's Revenge", 1000, 160, 12, 20, ShipStatus.SAILING);
        shipRepository.save(ursula);

        Raid rouge = new Raid("Port Rouge", 3000, null);
        raidRepository.save(rouge);

        Raid raven = new Raid("Port Raven", 1500, "gunblade");
        raidRepository.save(raven);

        NPCs barnacles = new NPCs("Barnaby 'Barnacles' Higgins",12,16,5,70, DoA.ALIVE, PlayerClasses.WARRIOR);
        npcRepository.save(barnacles);

        NPCs patches = new NPCs("Patrick 'Patches' Mulaney", 14, 6, 15, 50, DoA.ALIVE, PlayerClasses.MAGE);
        npcRepository.save(patches);

        Enemy seagull1 = new Enemy("Seagull 1", 1, 4, 0, 16, DoA.ALIVE);
        enemyRepository.save(seagull1);

        Enemy seagull2 = new Enemy("Seagull 2", 1, 4, 0, 16, DoA.ALIVE);
        enemyRepository.save(seagull2);

        Enemy seagull3 = new Enemy("Seagull 3", 1, 4, 0, 16, DoA.ALIVE);
        enemyRepository.save(seagull3);

        Enemy seagull4 = new Enemy("Seagull 4", 1, 4, 0, 16, DoA.ALIVE);
        enemyRepository.save(seagull4);

        Kraken kraken = new Kraken("Kraken", 14, 12, 100, 12, DoA.ALIVE);
        bossRepository.save(kraken);

        UserCharacter userCharacter = new UserCharacter();
        userCharRepository.save(userCharacter);
    }
}
