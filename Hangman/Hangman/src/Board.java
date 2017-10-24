import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.*;

import javax.swing.*;

class Board implements ActionListener
{
	private ArrayList<JButton> buttons;
	private ArrayList<JLabel> letters;
	private JLabel word1, gameover, winner;
	private Difficulty d;
	private String word;
	private Hangman h;
	private boolean gameWon = true;
	
	/**
	 * constructs Board with default parameters
	 */
	public Board()
	{
		buttons = new ArrayList<>();
		letters = new ArrayList<>();
		
		for(int i = 65; i <= 90; i++) //Creating Alphabet Letters
		{
			String name = (char)i + "";
			buttons.add(new JButton(name));	
		}
	}
	
	/**
	 * returns easy board
	 * @return easy board
	 * @throws FileNotFoundException
	 */
	public JPanel getEasyPanel()throws FileNotFoundException
	{
		d = new Difficulty("easy"); //calling other classes
		h = new Hangman("easy");
		word = d.getPhrase();
		
		JPanel game = new JPanel(new GridLayout(2,2)); //Game Panel 
		JPanel key = new JPanel(new GridLayout(1,1)); //Keyboard
		JPanel top = new JPanel(new GridLayout(1,2)); //Hangman Box and Images
		
		game.setBackground(new Color(51, 153, 255));
	
		top.add(hangmanBox());
		key.add(getKeyboard());
		
		top.add(h.getPanel()); //Hangman
		
		game.add(top);
		game.add(key);
	
		return game;
	}
	
	/**
	 * returns medium board	
	 * @return medium board
	 * @throws FileNotFoundException
	 */
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
	
	/**
	 * returns hard board
	 * @return hard board
	 * @throws FileNotFoundException
	 */
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
	
	/**
	 * returns entire board
	 * @return entire board
	 */
	private JPanel hangmanBox()
	{
		int spaces = word.length() + 4; //Formatting 
		JPanel p = new JPanel(new GridLayout(spaces,1)); //Entire Hangman Box
		
		JPanel winner = new JPanel(new GridLayout(1,1)); //Game Won panel
		JPanel phrase = new JPanel(new GridLayout(1,spaces)); //Actual Letters
		JPanel blanks = new JPanel(new GridLayout(1,spaces)); //Blanks		
		
		System.out.println(word);
		
		winner.setBackground(new Color(153,204,255));
		phrase.setBackground(new Color(153,204,255));
		blanks.setBackground(new Color(153,204,255));
		
		word1 = new JLabel("THE CORRECT WORD IS", SwingConstants.CENTER); //Appears when the user wins or loses
		winner.add(word1, SwingConstants.CENTER);
		word1.setVisible(false);
		word1.setFont(new Font("ChalkBoard", Font.BOLD, 30));
		word1.setForeground(new Color(204,0,153));
		
		p.setPreferredSize(new Dimension(150,150));
		p.setBackground(new Color(153,204,255));
	
		for(int i = -2; i < word.length() + 2; i++) //Adding Letters of Actual word to Panel
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
	
		for(int i = -2; i < word.length() + 2; i++) //Adding Blanks for every letter in the phrase
		{
			JLabel space;
			if(i < word.length() && i > -1)
				space = new JLabel("_"); 
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
	
	/**
	 * returns keyboard
	 * @return keyboard
	 */
	public JPanel getKeyboard()
	{
		JPanel keys = new JPanel(new CardLayout());
		
		JPanel keyboard = new JPanel();
		keyboard.setBackground(new Color(153,204,255));
		keyboard.setPreferredSize(new Dimension(300,300));
		keyboard.setLayout(new GridLayout(5,4));
		keyboard.setLocation(600,600);
		
		for(JButton i: buttons) //Calls array of entire alphabet, adds to panel
		{
			keyboard.add(i);
			i.setPreferredSize(new Dimension(40,40));
			i.setFont(new Font("ChalkBoard", Font.BOLD, 24)); 
			i.addActionListener(this);
		}
		
		gameover = new JLabel("GAME OVER", SwingConstants.CENTER);
		gameover.setFont(new Font("ChalkBoard", Font.BOLD,60));
		gameover.setForeground(new Color(204,0,153));
		
		winner = new JLabel("YOU WIN", SwingConstants.CENTER);
		winner.setFont(new Font("ChalkBoard", Font.BOLD,60));
		winner.setForeground(new Color(204,0,153));
		
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
		if(!e.getActionCommand().equals(null))
		{
			String input = e.getActionCommand().toLowerCase();
			
			if(!word.contains(input))
			{
				h.addWrong();
				h.changeImage();
			}
			while(word.contains(input))
			{
				letters.get(word.indexOf(input)).setVisible(true);
				word = word.substring(0, word.indexOf(input)) + "!" + word.substring(word.indexOf(input) + 1);
			}
			
			buttons.get((int) input.charAt(0) - 97).setVisible(false);
		}
		
		for(JLabel l:letters)
		{
			if(!l.isVisible())
				gameWon = false;
		}

		if (gameWon)
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