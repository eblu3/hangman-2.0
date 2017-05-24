import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.*;

import javax.swing.*;
import javax.swing.text.TabSet;

public class Board implements ActionListener
{
	private ArrayList<JButton> buttons;
	private ArrayList<JLabel> letters;
	private ArrayList<String> alphabet;
	private JLabel word1, word2, gameover, winner;
	private JPanel keys;
	private Difficulty d;
	private String word;
	private Hangman h;
	boolean gameWon = true;
	
	public Board()
	{
		buttons = new ArrayList<JButton>();
		letters = new ArrayList<JLabel>();
		
		for(int i = 65; i <= 90; i++) //Creating Alphabet Letters
		{
			String name = (char)i + "";
			buttons.add(new JButton(name));	
		}
	}
	
	public JPanel getEasyPanel()throws FileNotFoundException
	{
		d = new Difficulty("easy");
		h = new Hangman("easy");
		word = d.getPhrase();
		
		JPanel game = new JPanel(new GridLayout(2,2)); //Game Consel
		JPanel key = new JPanel(new GridLayout(1,1));
		JPanel top = new JPanel(new GridLayout(1,2));
		
		game.setBackground(new Color(51, 153, 255));
	
		top.add(hangmanBox());
		key.add(getKeyboard());
		
		top.add(h.getPanel()); //Hangman
		
		game.add(top);
		game.add(key);
	
		System.out.println(word);
		return game;
	}
		
	public JPanel getMediumPanel()throws FileNotFoundException
	{
		d = new Difficulty("medium");
		word = d.getPhrase();
		h = new Hangman("medium");
		JPanel game = new JPanel(new GridLayout(2,2)); //Game Consel
		JPanel key = new JPanel(new GridLayout(1,1)); //Keyboard's panel
		JPanel top = new JPanel(new GridLayout(1,2)); //Hangman Box, and Hangman Images
		
		game.setBackground(new Color(51, 153, 255));
	
		top.add(hangmanBox());
		key.add(getKeyboard());
		
		top.add(h.getPanel()); //Hangman
		
		game.add(top);
		game.add(key);
	
		return game;
	}
	
	public JPanel getHardPanel()throws FileNotFoundException
	{
		d = new Difficulty("hard");
		h = new Hangman("hard");
		word = d.getPhrase();
		JPanel game = new JPanel(new GridLayout(2,2)); //Game Consel
		JPanel key = new JPanel(new GridLayout(1,1));
		JPanel top = new JPanel(new GridLayout(1,2));
		
		game.setBackground(new Color(51, 153, 255));
		
	
		top.add(hangmanBox());
		key.add(getKeyboard());
		
		top.add(h.getPanel()); //Hangman
		
		game.add(top);
		game.add(key);
	
		return game;
	}
	
	private JPanel hangmanBox()
	{
		int spaces = word.length() + 4;
		JPanel p = new JPanel(new GridLayout(spaces,1)); //Entire Hangman Box
		
		JPanel winner = new JPanel(new GridLayout(1,1)); //Game Won panel
		JPanel phrase = new JPanel(new GridLayout(1,spaces)); //Actual Letters
		JPanel blanks = new JPanel(new GridLayout(1,spaces)); //Blanks		
		
		winner.setBackground(new Color(153,204,255));
		phrase.setBackground(new Color(153,204,255));
		blanks.setBackground(new Color(153,204,255));
		
		word1 = new JLabel("THE CORRECT WORD IS", SwingConstants.CENTER);
		winner.add(word1, SwingConstants.CENTER);
		word1.setVisible(false);
		word1.setFont(new Font("ChalkBoard", Font.BOLD, 30));
		
		p.setPreferredSize(new Dimension(150,150));
		p.setBackground(new Color(153,204,255));
	
		for(int i = -2; i < word.length() + 2; i++)
		{
			JLabel let;
			if(i < word.length() && i > -1)
			{
				let = new JLabel(word.substring(i,i+1)); 
				letters.add(let); //add to array
			}
			else
				let = new JLabel(); 
			let.setFont(new Font("ChalkBoard", Font.BOLD, 40)); 
			phrase.add(let); //Add to word panel
			let.setVisible(false);
		
		}
	
		for(int i = -2; i < word.length() + 2; i++)
		{
			JLabel space;
			if(i < word.length() && i > -1)
				space = new JLabel("-"); 
			else
				space = new JLabel();
			space.setFont(new Font("ChalkBoard", Font.BOLD,40));
			blanks.add(space); 
		}
		
		//Filler Panels added to create Illusion of "Blank Lines"
		JPanel filler1 = new JPanel();
		filler1.setBackground(new Color(153,204,255));
		JPanel filler2 = new JPanel();
		filler2.setBackground(new Color(153,204,255));
		p.add(filler2);
		p.add(winner);
		p.add(filler1);
		p.add(phrase);
		p.add(blanks);
		
		return p;
	}
	
	public JPanel getKeyboard()
	{
		keys = new JPanel(new CardLayout());
		
		JPanel keyboard = new JPanel();
		keyboard.setBackground(new Color(153,204,255));
		keyboard.setPreferredSize(new Dimension(300,300));
		keyboard.setLayout(new GridLayout(5,4));
		keyboard.setLocation(600,600);
		for(JButton i: buttons)
		{
			keyboard.add(i);
			i.setPreferredSize(new Dimension(40,40));
			i.setFont(new Font("ChalkBoard", Font.BOLD, 24)); 
			i.addActionListener(this);
		}
		
		gameover = new JLabel("GAMEOVER", SwingConstants.CENTER);
		gameover.setFont(new Font("ChalkBoard", Font.BOLD,60));
		gameover.setForeground(Color.BLACK);
		
		winner = new JLabel("CONGRAGULATIONS, YOU WIN!", SwingConstants.CENTER);
		winner.setFont(new Font("ChalkBoard", Font.BOLD,60));
		winner.setForeground(Color.BLACK);
		
		keys.add(gameover);
		keys.add(winner);
		keys.add(keyboard);
	
		
		keyboard.setVisible(true);
		gameover.setVisible(false);
		winner.setVisible(false);
		
		return keys;
	}
	
	public void actionPerformed(ActionEvent e) 
	{
		String input = e.getActionCommand().toLowerCase(); //changes letter of button clicked to lowercase, makes it compatible with all methods
		
		if(word.indexOf(input) < 0) //if button clicked is not in word
		{
			h.addWrong();
			h.changeImage();
		}
		
		while(word.indexOf(input) >= 0) //if button clicked is in word (IN PROGRESS)
		{
			letters.get(word.indexOf(input)).setVisible(false);
			word = word.substring(0, word.indexOf(input)) + "!" + word.substring(word.indexOf(input)+1);
		}
		
		switch(input) //making buttons disappear on click
		{
		case "a":
			buttons.get(0).setVisible(false);
			break;
		case "b":
			buttons.get(1).setVisible(false);
			break;
		case "c":
			buttons.get(2).setVisible(false);
			break;
		case "d":
			buttons.get(3).setVisible(false);
			break;
		case "e":
			buttons.get(4).setVisible(false);
			break;
		case "f":
			buttons.get(5).setVisible(false);
			break;
		case "g":
			buttons.get(6).setVisible(false);
			break;
		case "h":
			buttons.get(7).setVisible(false);
			break;
		case "i":
			buttons.get(8).setVisible(false);
			break;
		case "j":
			buttons.get(9).setVisible(false);
			break;
		case "k":
			buttons.get(10).setVisible(false);
			break;
		case "l":
			buttons.get(11).setVisible(false);
			break;
		case "m":
			buttons.get(12).setVisible(false);
			break;
		case "n":
			buttons.get(13).setVisible(false);
			break;
		case "o":
			buttons.get(14).setVisible(false);
			break;
		case "p":
			buttons.get(15).setVisible(false);
			break;
		case "q":
			buttons.get(16).setVisible(false);
			break;
		case "r":
			buttons.get(17).setVisible(false);
			break;
		case "s":
			buttons.get(18).setVisible(false);
			break;
		case "t":
			buttons.get(19).setVisible(false);
			break;
		case "u":
			buttons.get(20).setVisible(false);
			break;
		case "v":
			buttons.get(21).setVisible(false);
			break;
		case "w":
			buttons.get(22).setVisible(false);
			break;
		case "x":
			buttons.get(23).setVisible(false);
			break;
		case "y":
			buttons.get(24).setVisible(false);
			break;
		case "z":
			buttons.get(25).setVisible(false);
		}
		
		for(JLabel l:letters)
		{
			if(!l.isVisible())
				gameWon = false;
		}
		
		if(gameWon == true)
		{
			word1.setVisible(true);
			for(JButton i: buttons)
			{
				i.setVisible(false);
			}
			winner.setVisible(true);
			//gameover.setVisible(false);
		}
		
		if(h.lost())
		{
			word1.setVisible(true);
			for(JButton i: buttons)
			{
				i.setVisible(false);
			}
			for(JLabel i: letters)
			{
				i.setVisible(true);
			}
			
			gameover.setVisible(true);
		}
		
		gameWon = true;
	}

}