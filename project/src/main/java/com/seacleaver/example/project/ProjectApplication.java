package com.seacleaver.example.project;

import com.seacleaver.example.project.models.Area;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Time;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

@SpringBootApplication
public class ProjectApplication {

	public static void main(String[] args) throws InterruptedException {
		SpringApplication.run(ProjectApplication.class, args);

		Area area = new Area(1);
		String command = " ";
		Scanner sc = new Scanner(System.in);
//		area = 1;
		boolean southVisited = false;
		boolean westVisited = false;
		boolean eastVisited = false;
		boolean northVisited = false;

		while(area.getArea() == 1) {
			System.out.println("> Barnacles: ");
			System.out.println("> Where shall we sail, Cap'n?");
			command = sc.nextLine();

			if (command.equals("south")) {
				area.setArea(2);
				TimeUnit.SECONDS.sleep(3);
				System.out.println("> Barnacles: ");
				System.out.println("> Ahoy! I see Port Rouge! \n");
				TimeUnit.SECONDS.sleep(2);
				System.out.println("> Patches: ");
				System.out.println("> *SQUAWK* LAWFUL AND RICH! LAWFUL AND RICH! \n");
				TimeUnit.SECONDS.sleep(2);
				System.out.println("> Barnacles: ");
				System.out.println("> Hmm...shall we raid them, Cap'n?");
				command = sc.nextLine();
				if (command.equals("raid") || command.equals("yes")) {
					System.out.println("> Your crew yells in excitement!");
					System.out.println("> You all launch a raid on Port Rouge!");
					TimeUnit.SECONDS.sleep(3);
					System.out.println("You plunder 2000 gold!");
					southVisited = true;
					TimeUnit.SECONDS.sleep(3);
					area.setArea(1);
				} else if (command.equals("no")) {
					System.out.println("> Barnacles: ");
					System.out.println("> I see. Very well, Cap'n! ");
					TimeUnit.SECONDS.sleep(3);
					area.setArea(1);
				}
			} else if (command.equals("west")) {
				area.setArea(3);
				TimeUnit.SECONDS.sleep(3);
				System.out.println("> Barnacles: ");
				System.out.println("> Ahoy! I see Port Raven! \n");
				TimeUnit.SECONDS.sleep(2);
				System.out.println("> Patches: ");
				System.out.println("> *SQUAWK* HIDDEN TREASURES! \n");
				TimeUnit.SECONDS.sleep(2);
				System.out.println("> Barnacles: ");
				System.out.println("> Hmm...shall we raid them, Cap'n?");
				command = sc.nextLine();
				if (command.equals("raid") || command.equals("yes")) {
					System.out.println("> Your crew yells in excitement!");
					System.out.println("> You all launch a raid on Port Raven!");
					TimeUnit.SECONDS.sleep(3);
					System.out.println("You plunder 1000 gold!");
					westVisited = true;
					TimeUnit.SECONDS.sleep(3);
					area.setArea(1);

				} else if (command.equals("no")) {
					System.out.println("> Barnacles: ");
					System.out.println("> I see. Very well, Cap'n! ");
					TimeUnit.SECONDS.sleep(3);
					area.setArea(1);
				}

			}
		}
	}




}
