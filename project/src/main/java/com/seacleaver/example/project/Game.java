package com.seacleaver.example.project;

import javax.swing.*;
import javax.swing.border.Border;
import com.seacleaver.example.project.models.Area;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import com.seacleaver.example.project.models.Player;
import com.seacleaver.example.project.models.UserCharacter;
import com.seacleaver.example.project.repositories.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;


public class Game {

    Random random = new Random();
    JFrame window;
    Container con;
    JPanel titleNamePanel;
    JLabel titleNameLabel;

    JPanel mainTextPanel;
    JPanel statPanel;
    JPanel statBlox;
    JPanel startButtonPanel;
    JPanel storyStartPanel;
    JPanel storyStartButton;

    JButton button;
    JButton button2;

    Font titleFont = new Font("Arial", Font.PLAIN, 90);
    Font buttonFont = new Font("Arial", Font.PLAIN, 40);
    Font generalFont = new Font("Arial", Font.PLAIN, 20);

    JTextArea storyText;
    JTextArea statText;
    JTextArea characterStatText;
    JTextField inputText;
    JTextArea storyStartText;


    JTextField strNo;
    JTextField conNo;
    JTextField magNo;
    JTextField luckNo;

    UserCharacter userCharacter = new UserCharacter();

    @Autowired
    PlayerRepository playerRepository;





    public static void main(String[] args) {
        new Game();
    }
    	public Game(){
		window = new JFrame();
		window.setSize(800,600);
		window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		window.getContentPane().setBackground(Color.BLUE);
		window.setLayout(null);
		con = window.getContentPane();

		titleNamePanel = new JPanel();
		titleNamePanel.setBounds(100, 100, 600, 150);
		titleNamePanel.setBackground(Color.BLUE);
		titleNameLabel = new JLabel("ArrrrPG!");
		titleNameLabel.setForeground(Color.YELLOW);
		titleNameLabel.setFont(titleFont);

		titleNamePanel.add(titleNameLabel);
		con.add(titleNamePanel);

		startButtonPanel = new JPanel();
		startButtonPanel.setBounds(300, 400, 200, 100);
		startButtonPanel.setBackground(Color.BLUE);

		button = new JButton("Starrrrt!");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                System.out.println("It click");
                introScreen();
            }
        });
        button.setBackground(Color.BLUE);
        button.setForeground(Color.YELLOW);
        button.setFont(buttonFont);

		startButtonPanel.add(button);
		con.add(startButtonPanel);

		window.setVisible(true);
	}

    public void introScreen(){
        titleNamePanel.setVisible(false);
        startButtonPanel.setVisible(false);

        mainTextPanel = new JPanel();
        mainTextPanel.setBounds(100, 100, 600, 300);
        mainTextPanel.setBackground(Color.BLUE);
        con.add(mainTextPanel);

        storyText = new JTextArea();
        storyText.setEditable(false);
        storyText.setBounds(100, 100, 600, 200);
        storyText.setBackground(Color.BLUE);
        storyText.setForeground(Color.YELLOW);
        storyText.setFont(generalFont);
        storyText.setLineWrap(true);
        storyText.setText("You are the Captain of the pirate ship, The Seacleaver! \n What is your name?");
        mainTextPanel.add(storyText);

        inputText = new JTextField(28);
        inputText.setBackground(Color.white);
        inputText.setForeground(Color.black);
        mainTextPanel.add(inputText);

        button = new JButton("Enter");
        button.setForeground(Color.YELLOW);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                userCharacter = new UserCharacter();
                String name = inputText.getText();
                userCharacter.setName(name);
                statRollScreen();
//                System.out.println(userCharacter.getName());
            }
        });
        mainTextPanel.add(button);



    }
    public void statRollScreen(){
        mainTextPanel.setVisible(false);

        statPanel = new JPanel();
        statPanel.setBounds(100, 100, 600, 100);
        statPanel.setBackground(Color.BLUE);
        statPanel.setForeground(Color.YELLOW);
        statPanel.setFont(generalFont);
        con.add(statPanel);

        statText = new JTextArea();
        statText.setBackground(Color.BLUE);
        statText.setForeground(Color.YELLOW);
        statText.setFont(generalFont);
        statText.setText("Here are your stats!");
        statPanel.add(statText);

        statBlox = new JPanel();
        statBlox.setBounds(100, 200, 600, 400);
        statBlox.setBackground(Color.BLUE);
        statBlox.setFont(generalFont);

        characterStatText = new JTextArea();
        characterStatText.setBackground(Color.BLUE);
        characterStatText.setForeground(Color.YELLOW);
        characterStatText.setFont(generalFont);
        userCharacter.buildCharacter();
        characterStatText.setText("Captain " + userCharacter.getName() + "\n Class: " + userCharacter.getPlayerClass()
         + "\n Attack Points: " + userCharacter.getAttackPoints() + "\n Magic Points: " + userCharacter.getMagicPoints()
        + "\n Health Points: " + userCharacter.getHealthPoints() + "\n Luck: " + userCharacter.getLuck());
        characterStatText.setEditable(false);
        statBlox.add(characterStatText);

        button = new JButton("Accept");
        button.setForeground(Color.YELLOW);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                storyStart();
//                playerRepository.save(userCharacter);
            }
        });

        button2 = new JButton("Reroll");
        button2.setForeground(Color.YELLOW);
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                userCharacter.restartCharacter();
                statRollScreen();
            }
        });

        statBlox.add(button);
        statBlox.add(button2);


        con.add(statBlox);

        window.setVisible(true);
    }

    public void storyStart(){
        statBlox.setVisible(false);
        statPanel.setVisible(false);

        storyStartPanel = new JPanel();
        storyStartPanel.setBackground(Color.BLUE);
        storyStartPanel.setBounds(50,50, 700, 500);
        storyStartText = new JTextArea();
        storyStartText.setBounds(50,50, 700, 500);
        storyStartText.setBackground(Color.BLUE);
        storyStartText.setForeground(Color.YELLOW);
        storyStartText.setFont(generalFont);
        storyStartText.setLineWrap(true);
        storyStartText.setEditable(false);
        storyStartText.setText(
                "You leave your cabin and step out on deck. You are greeted by a man with an octopus head.\n" +
                        "\n Barnacles: 'Good morning, Captain " + userCharacter.getName() + "!' \n "
                        + "\n Barnacles is your mild-mannered First Mate. He is a warrior, a great \n swordsman, and cursed to look like an octopus after spurning a sea witch's\n advances."
        + "\n Behind Barnacles, you see another, smirking man and a parrot on his \n shoulder. \n" +
                "\n Patches (through Polly Pickpocket): '<SQUAWK> COLD MORNING!' \n" +
                "Patches is a mage who can summon lightning. He lost the ability to speak after a vicious fight. He now speaks through his parrot. \n" +
                "Barnacles and Patches have a cordial but tense relationship given Patches' \n voracious appetite for seafood.");

        storyStartPanel.add(storyStartText);
        con.add(storyStartPanel);

        storyStartButton = new JPanel();
        storyStartButton.setBackground(Color.BLUE);
        storyStartButton.setBounds(350, 700, 100, 100);
        storyStartPanel.add(storyStartButton);

        button = new JButton("Continue");
        button.setForeground(Color.YELLOW);
        storyStartButton.add(button);
    }




}
