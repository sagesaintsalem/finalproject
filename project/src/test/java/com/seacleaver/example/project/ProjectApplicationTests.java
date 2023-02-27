package com.seacleaver.example.project;

import com.seacleaver.example.project.models.Enemy;
import com.seacleaver.example.project.models.NPCs;
import com.seacleaver.example.project.repositories.PlayerRepository;
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



	@Test
	void contextLoads() {
	}

	@Test
	public void createCharacter(){
		NPCs barnacles = new NPCs("Barnaby 'Barnacles' Higgins", 14, 10, 2, 60);
		playerRepository.save(barnacles);
	}

	@Test
	public void createEnemy(){
		Enemy seagull = new Enemy("seagull", 4, 4, 0, 12 );
		playerRepository.save(seagull);
	}
}
