package com.seacleaver.example.project;


import com.seacleaver.example.project.enums.DoA;
import com.seacleaver.example.project.enums.PlayerClasses;
import com.seacleaver.example.project.enums.ShipStatus;
import com.seacleaver.example.project.models.*;
import com.seacleaver.example.project.repositories.PlayerRepository;
import com.seacleaver.example.project.repositories.ShipRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Random;


@RunWith(SpringRunner.class)
@SpringBootTest
class ProjectApplicationTests {

	@Autowired
	PlayerRepository playerRepository;

	@Autowired
	ShipRepository shipRepository;




	@Test
	void contextLoads() {
	}

	@Test
	public void createCharacter(){
		NPCs barnacles = new NPCs("Barnaby 'Barnacles' Higgins", 14, 10, 2, 60, DoA.ALIVE);
		playerRepository.save(barnacles);
	}

	@Test
	public void createEnemy(){
		Enemy seagull = new Enemy("seagull", 4, 1111, 0, 12, DoA.ALIVE );
		playerRepository.save(seagull);
	}

//	@Test
//	public void createUserPlayer(){
//		UserCharacter me = new UserCharacter();
//		me.setName("It me Cthulu");
//		me.buildCharacter();
//		playerRepository.save(me);
//	}

	@Test
	public void canAttack(){
		NPCs barnacles = new NPCs("Barnaby 'Barnacles' Higgins", 14, 10, 2, 60, DoA.ALIVE);
		playerRepository.save(barnacles);
		Enemy seagull = new Enemy("seagull", 4, 4, 0, 12, DoA.ALIVE );
		playerRepository.save(seagull);
		barnacles.attack(seagull);
		playerRepository.save(seagull);
	}

	@Test
	public void canHeal(){
		NPCs patches = new NPCs("Patrick 'Patches' Mulaney", 10, 5, 15, 50, DoA.ALIVE);
		playerRepository.save(patches);
		Enemy seagull = new Enemy("seagull", 4, 20, 0, 12 , DoA.ALIVE);
		playerRepository.save(seagull);
		seagull.attack(patches);
		playerRepository.save(patches);
		patches.heal();
		playerRepository.save(patches);
	}
	@Test
	public void canThunderbolt(){
		NPCs patches = new NPCs("Patrick 'Patches' Mulaney", 10, 5, 15, 50, DoA.ALIVE);
		playerRepository.save(patches);
		Enemy seagull = new Enemy("seagull", 4, 20, 0, 32 , DoA.ALIVE);
		playerRepository.save(seagull);
		patches.castThunderbolt(seagull);
		playerRepository.save(seagull);
	}

	@Test
	public void canTrueStrike(){
		NPCs barnacles = new NPCs("Barnaby 'Barnacles' Higgins", 14, 10, 2, 60, DoA.ALIVE);
		playerRepository.save(barnacles);
		Enemy seagull = new Enemy("seagull", 4, 4, 0, 23 , DoA.ALIVE);
		playerRepository.save(seagull);
		barnacles.trueStrike(seagull);
		playerRepository.save(seagull);
	}

	@Test
	public void canKillSeagulls(){
		NPCs patches = new NPCs("Patrick 'Patches' Mulaney Junior Jr", 10, 5, 15, 50, DoA.ALIVE);
		playerRepository.save(patches);
		Enemy seagull = new Enemy("seagull", 4, 20, 0, 12 , DoA.ALIVE);
		playerRepository.save(seagull);
		Enemy seagull2 = new Enemy("seagull2", 4, 20, 0, 12 , DoA.ALIVE);
		playerRepository.save(seagull2);
		NPCs barnacles = new NPCs("Barnaby 'Barnacles' Higgins", 14, 10, 2, 60, DoA.ALIVE);
		playerRepository.save(barnacles);
		seagull.attack(patches);
		playerRepository.save(patches);
		patches.castThunderbolt(seagull);
		barnacles.trueStrike(seagull2);
		playerRepository.save(seagull);
		playerRepository.save(seagull2);
	}

	@Test
	public void birdsCanDive(){
		Enemy seagull3 = new Enemy("seagull3", 4, 20, 0, 12 , DoA.ALIVE);
		playerRepository.save(seagull3);
		NPCs barnacles = new NPCs("Barnaby 'Barnacles' Higgins", 14, 10, 2, 60, DoA.ALIVE);
		playerRepository.save(barnacles);
		seagull3.dive(barnacles);
		playerRepository.save(barnacles);
	}

	@Test
	public void canCreateShip(){
		Ship ship = new Ship("The Seacleaver", 0, 20, 100, 25, ShipStatus.SAILING);
		shipRepository.save(ship);
	}

	@Test
	public void canAddToCoffers(){
		Ship ship = new Ship("The Seacleaver", 0, 20, 100, 25, ShipStatus.SAILING);
		ship.addToCoffers(1000);
		shipRepository.save(ship);
	}

	@Test
	public void shipCanTakeDamage(){
		Ship ship = new Ship("The Seacleaver II", 0, 100, 20, 105, ShipStatus.SAILING);
		Ship ship2 = new Ship("Ursula's Revenge", 0, 100, 20, 25, ShipStatus.SAILING);
		ship.fireCannons(ship2);
		shipRepository.save(ship);
		shipRepository.save(ship2);
	}
}
