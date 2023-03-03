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


@Profile("!test") //Run every time EXCEPT Tests
@Component
public class DataLoader implements ApplicationRunner{
    @Autowired
    PlayerRepository playerRepository;

    @Autowired
    ShipRepository shipRepository;

    @Autowired
    RaidRepository raidRepository;

    @Autowired
    BossRepository bossRepository;

    public DataLoader() {

    }

    public void run(ApplicationArguments args){
        Ship seacleaver = new Ship("The Seacleaver", 0, 200, 18, 20, ShipStatus.SAILING);
        shipRepository.save(seacleaver);

        Ship ursula = new Ship("Ursula's Revenge", 1000, 150, 15, 20, ShipStatus.SAILING);
        shipRepository.save(ursula);

        Raid rouge = new Raid("Port Rouge", 3000, null);
        raidRepository.save(rouge);

        Raid raven = new Raid("Port Raven", 1500, "gunblade");
        raidRepository.save(raven);

        NPCs barnacles = new NPCs("Barnaby 'Barnacles' Higgins",11,16,5,64, DoA.ALIVE, PlayerClasses.WARRIOR);
        playerRepository.save(barnacles);

        NPCs patches = new NPCs("Patrick 'Patches' Mulaney", 14, 6, 15, 50, DoA.ALIVE, PlayerClasses.MAGE);
        playerRepository.save(patches);

        Enemy seagull1 = new Enemy("Seagull 1", 4, 4, 0, 16, DoA.ALIVE);
        playerRepository.save(seagull1);

        Enemy seagull2 = new Enemy("Seagull 2", 4, 4, 0, 16, DoA.ALIVE);
        playerRepository.save(seagull2);

        Enemy seagull3 = new Enemy("Seagull 3", 4, 4, 0, 16, DoA.ALIVE);
        playerRepository.save(seagull3);

        Enemy seagull4 = new Enemy("Seagull 4", 4, 4, 0, 16, DoA.ALIVE);
        playerRepository.save(seagull4);

        Kraken kraken = new Kraken("Kraken", 14, 12, 100, 12, DoA.ALIVE);
        bossRepository.save(kraken);

        UserCharacter userCharacter = new UserCharacter();
        playerRepository.save(userCharacter);
    }
}
