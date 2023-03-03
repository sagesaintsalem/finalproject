package com.seacleaver.example.project;


import com.seacleaver.example.project.enums.DoA;
import com.seacleaver.example.project.enums.PlayerClasses;
import com.seacleaver.example.project.enums.ShipStatus;
import com.seacleaver.example.project.models.*;
import com.seacleaver.example.project.repositories.*;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;



@RunWith(SpringRunner.class)
@SpringBootTest
class ProjectApplicationTests {

	@Autowired
	PlayerRepository playerRepository;

	@Autowired
	ShipRepository shipRepository;

	@Autowired
	RaidRepository raidRepository;

	@Autowired
	BossRepository bossRepository;

	@Autowired
	NPCRepository npcRepository;

	@Autowired
	UserCharRepository userCharRepository;

	@Autowired
	EnemyRepository enemyRepository;



	@Test
	void contextLoads() {
	}

	@Test
	public void createCharacter(){
		NPCs barnacles = new NPCs("Barnaby 'Barnacles' Higgins", 14, 10, 2, 60, DoA.ALIVE, PlayerClasses.WARRIOR);
		npcRepository.save(barnacles);
	}

	@Test
	public void createEnemy(){
		Enemy seagull = new Enemy("Clive", 4, 1111, 0, 12, DoA.ALIVE );
		enemyRepository.save(seagull);
	}

	@Test
	public void createUserPlayer(){
		UserCharacter me = new UserCharacter();
		me.setName("It me Cthulu");
		me.buildCharacter();
		userCharRepository.save(me);
	}

	@Test
	public void canAttack(){
		NPCs barnacles = new NPCs("Barnaby 'Barnacles' Higgins", 14, 10, 2, 60, DoA.ALIVE, PlayerClasses.WARRIOR);
		playerRepository.save(barnacles);
		Enemy seagull = new Enemy("seagull", 4, 4, 0, 12, DoA.ALIVE );
		playerRepository.save(seagull);
		barnacles.attack(seagull);
		playerRepository.save(seagull);
	}

	@Test
	public void canHeal(){
		NPCs patches = new NPCs("Patrick 'Patches' Mulaney", 10, 5, 15, 50, DoA.ALIVE, PlayerClasses.MAGE);
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
		NPCs patches = new NPCs("Patrick 'Patches' Mulaney", 10, 5, 15, 50, DoA.ALIVE, PlayerClasses.MAGE);
		playerRepository.save(patches);
		Enemy seagull = new Enemy("seagull", 4, 20, 0, 32 , DoA.ALIVE);
		playerRepository.save(seagull);
		patches.castThunderbolt(seagull);
		playerRepository.save(seagull);
	}

	@Test
	public void canTrueStrike(){
		NPCs barnacles = new NPCs("Barnaby 'Barnacles' Higgins", 14, 10, 2, 60, DoA.ALIVE, PlayerClasses.WARRIOR);
		playerRepository.save(barnacles);
		Enemy seagull = new Enemy("seagull", 4, 4, 0, 23 , DoA.ALIVE);
		playerRepository.save(seagull);
		barnacles.trueStrike(seagull);
		playerRepository.save(seagull);
	}

	@Test
	public void canKillSeagulls(){
		NPCs patches = new NPCs("Patrick 'Patches' Mulaney Junior Jr", 10, 5, 15, 50, DoA.ALIVE, PlayerClasses.MAGE);
		playerRepository.save(patches);
		Enemy seagull = new Enemy("seagull", 4, 20, 0, 12 , DoA.ALIVE);
		playerRepository.save(seagull);
		Enemy seagull2 = new Enemy("seagull2", 4, 20, 0, 12 , DoA.ALIVE);
		playerRepository.save(seagull2);
		NPCs barnacles = new NPCs("Barnaby 'Barnacles' Higgins", 14, 10, 2, 60, DoA.ALIVE, PlayerClasses.WARRIOR);
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
		NPCs barnacles = new NPCs("Barnaby 'Barnacles' Higgins", 14, 10, 2, 60, DoA.ALIVE, PlayerClasses.WARRIOR);
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
		Raid raid = new Raid("Port Rouge", 3000, "gunblade");
		ship.addToCoffers(raid);
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

	@Test
	public void canAddRaid(){
		Raid raid = new Raid("Port Rouge", 3000, "gunblade");
		raidRepository.save(raid);
	}

	@Test
	public void canEquipGunblade(){
		Raid raid = new Raid("Port Rouge", 3000, "gunblade");
		raidRepository.save(raid);
		UserCharacter me = new UserCharacter("meow", 10,10,10,30,DoA.ALIVE,17,17,17,10,PlayerClasses.WARRIOR,"cutlass");
		raid.changePlayerWeapon(me);
		playerRepository.save(me);
	}

	@Test
	public void canMakeKraken(){
		Kraken kraken = new Kraken("Kraken", 14, 12, 100, 12, DoA.ALIVE);
		bossRepository.save(kraken);
	}
}
