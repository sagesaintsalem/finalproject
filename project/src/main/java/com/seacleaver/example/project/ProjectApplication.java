package com.seacleaver.example.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Time;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

@SpringBootApplication
public class ProjectApplication {

	public static void main(String[] args) throws InterruptedException {
		SpringApplication.run(ProjectApplication.class, args);



		String command = " ";
		Scanner sc = new Scanner(System.in);

		System.out.println("> Barnacles: ");
		System.out.println("> Where shall we sail, Cap'n?");
		command = sc.nextLine();

		if(command.equals("south")){
			System.out.println("> Barnacles: ");
			System.out.println("> Ahoy! I see Port Rouge! \n");
			TimeUnit.SECONDS.sleep(2);
			System.out.println("> Patches: ");
			System.out.println("> *SQUAWK* LAWFUL AND RICH! LAWFUL AND RICH! \n");
			TimeUnit.SECONDS.sleep(2);
			System.out.println("> Barnacles: ");
			System.out.println("> Hmm...shall we raid them, Cap'n?");
			command = sc.nextLine();
			if(command.equals("raid")||command.equals("yes")){
				System.out.println("> Your crew yells in excitement!");
				System.out.println("> You all launch a raid on Port Rouge!");
				TimeUnit.SECONDS.sleep(3);
				System.out.println("You plunder 2000 gold!");
			} else if (command.equals("no")) {
				System.out.println("> Barnacles: ");
				System.out.println("> I see. Very well, Cap'n! ");
			}
		} else if(command.equals("west")){
			System.out.println("> Barnacles: ");
			System.out.println("> Ahoy! I see Port Raven! \n");
			TimeUnit.SECONDS.sleep(2);
			System.out.println("> Patches: ");
			System.out.println("> *SQUAWK* HIDDEN TREASURES! \n");
			TimeUnit.SECONDS.sleep(2);
			System.out.println("> Barnacles: ");
			System.out.println("> Hmm...shall we raid them, Cap'n?");
			command = sc.nextLine();
			if(command.equals("raid")||command.equals("yes")){
				System.out.println("> Your crew yells in excitement!");
				System.out.println("> You all launch a raid on Port Raven!");
				TimeUnit.SECONDS.sleep(3);
				System.out.println("You plunder 1000 gold!");
			} else if (command.equals("no")) {
				System.out.println("> Barnacles: ");
				System.out.println("> I see. Very well, Cap'n! ");
			}

		}
	}




}
