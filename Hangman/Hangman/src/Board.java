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
		if(e.getActionCommand().equals("A")) {
			if (!word.contains("a"))
			{
				h.addWrong();
				h.changeImage();
			}
			while (word.contains("a"))
			{
				letters.get(word.indexOf("a")).setVisible(true);
				word = word.substring(0, word.indexOf("a")) + "!" + word.substring(word.indexOf("a") + 1);
			}
			buttons.get(0).setVisible(false);	
		}
	
		if(e.getActionCommand().equals("B"))
		{
			if (!word.contains("b"))
			{
				h.addWrong();
				h.changeImage();
			}
			while (word.contains("b"))
			{
				letters.get(word.indexOf("b")).setVisible(true);
				word = word.substring(0, word.indexOf("b")) + "!" + word.substring(word.indexOf("b") + 1);
			}	
			
			buttons.get(1).setVisible(false);
		}
		
		if(e.getActionCommand().equals("C")) {
			if (!word.contains("c"))
			{
				h.addWrong();
				h.changeImage();
			}
			while (word.contains("c"))
			{
				letters.get(word.indexOf("c")).setVisible(true);
				word = word.substring(0, word.indexOf("c")) + "!" + word.substring(word.indexOf("c") + 1);
			}	
			buttons.get(2).setVisible(false);
		}
		
		if(e.getActionCommand().equals("D")) {
			if (!word.contains("d"))
			{
				h.addWrong();
				h.changeImage();
			}
			while (word.contains("d"))
			{
				letters.get(word.indexOf("d")).setVisible(true);
				word = word.substring(0, word.indexOf("d")) + "!" + word.substring(word.indexOf("d") + 1);
			}	
			
			buttons.get(3).setVisible(false);
		
		}
		
		if(e.getActionCommand().equals("E")) {
			if (!word.contains("e"))
			{
				h.addWrong();
				h.changeImage();
			}
			while (word.contains("e"))
			{
				letters.get(word.indexOf("e")).setVisible(true);
				word = word.substring(0, word.indexOf("e")) + "!" + word.substring(word.indexOf("e") + 1);
			 
			}	
			buttons.get(4).setVisible(false);
			
		}
		
		if(e.getActionCommand().equals("F")) {
			if (!word.contains("f"))
			{
				h.addWrong();
				h.changeImage();
			}
			while (word.contains("f"))
			{
				letters.get(word.indexOf("f")).setVisible(true);
				word = word.substring(0, word.indexOf("f")) + "!" + word.substring(word.indexOf("f") + 1);
			}	
			buttons.get(5).setVisible(false);
		
		}
		
		if(e.getActionCommand().equals("G")) {
			if (!word.contains("g"))
			{
				h.addWrong();
				h.changeImage();
			}
			while (word.contains("g"))
			{
				letters.get(word.indexOf("g")).setVisible(true);
				word = word.substring(0, word.indexOf("g")) + "!" + word.substring(word.indexOf("g") + 1);
			}	
			buttons.get(6).setVisible(false);
		
		}
		
		if(e.getActionCommand().equals("H")) {
			if (!word.contains("h"))
			{
				h.addWrong();
				h.changeImage();
			}
			while (word.contains("h"))
			{
				letters.get(word.indexOf("h")).setVisible(true);
				word = word.substring(0, word.indexOf("h")) + "!" + word.substring(word.indexOf("h") + 1);
			}	
			buttons.get(7).setVisible(false);	
		}
		
		if(e.getActionCommand().equals("I")) {
			if (!word.contains("i"))
			{
				h.addWrong();
				h.changeImage();
			}
			while (word.contains("i"))
			{
				letters.get(word.indexOf("i")).setVisible(true);
				word = word.substring(0, word.indexOf("i")) + "!" + word.substring(word.indexOf("i") + 1);		 
			}			
			buttons.get(8).setVisible(false);		
		}
		
		if(e.getActionCommand().equals("J")) {
			if (!word.contains("j"))
			{
				h.addWrong();
				h.changeImage();
			}
			while (word.contains("j"))
			{
				letters.get(word.indexOf("j")).setVisible(true);
				word = word.substring(0, word.indexOf("j")) + "!" + word.substring(word.indexOf("j") + 1);
			}	
			buttons.get(9).setVisible(false);
		
		}
		
		if(e.getActionCommand().equals("K")) {
			if (!word.contains("k"))
			{
				h.addWrong();
				h.changeImage();
			}
			while (word.contains("k"))
			{
				letters.get(word.indexOf("k")).setVisible(true);
				word = word.substring(0, word.indexOf("k")) + "!" + word.substring(word.indexOf("k") + 1);
			}	
			buttons.get(10).setVisible(false);
		
		}
		
		if(e.getActionCommand().equals("L")) {
			if (!word.contains("l"))
			{
				h.addWrong();
				h.changeImage();
			}
			while (word.contains("l"))
			{
				letters.get(word.indexOf("l")).setVisible(true);
				word = word.substring(0, word.indexOf("l")) + "!" + word.substring(word.indexOf("l") + 1);
			}	
				buttons.get(11).setVisible(false);
		}
		
		if(e.getActionCommand().equals("M")) {
			if (!word.contains("m"))
			{
				h.addWrong();
				h.changeImage();
			}
			while (word.contains("m"))
			{
				letters.get(word.indexOf("m")).setVisible(true);
				word = word.substring(0, word.indexOf("m")) + "!" + word.substring(word.indexOf("m") + 1);
			}	
			buttons.get(12).setVisible(false);
		}
		
		if(e.getActionCommand().equals("N")) {
			if (!word.contains("n"))
			{
				h.addWrong();
				h.changeImage();
			}
			while (word.contains("n"))
			{
				letters.get(word.indexOf("n")).setVisible(true);
				word = word.substring(0, word.indexOf("n")) + "!" + word.substring(word.indexOf("n") + 1);
			}	
			buttons.get(13).setVisible(false);
		}
		
		if(e.getActionCommand().equals("O")) {
			if (!word.contains("o"))
			{
				h.addWrong();
				h.changeImage();
			}
			while (word.contains("o"))
			{
				letters.get(word.indexOf("o")).setVisible(true);
				word = word.substring(0, word.indexOf("o")) + "!" + word.substring(word.indexOf("o") + 1);
		 
			}	
			buttons.get(14).setVisible(false);
		}
		
		if(e.getActionCommand().equals("P")) {
			if (!word.contains("p"))
			{
				h.addWrong();
				h.changeImage();
			}
			while (word.contains("p"))
			{
			letters.get(word.indexOf("p")).setVisible(true);
			word = word.substring(0, word.indexOf("p")) + "!" + word.substring(word.indexOf("p") + 1);
			}	
			buttons.get(15).setVisible(false);
		}
		
		if(e.getActionCommand().equals("Q")) {
			if (!word.contains("q"))
			{
				h.addWrong();
				h.changeImage();
			}
			while (word.contains("q"))
			{
				letters.get(word.indexOf("q")).setVisible(true);
				word = word.substring(0, word.indexOf("q")) + "!" + word.substring(word.indexOf("q") + 1);
		}	
		buttons.get(16).setVisible(false);
		}
		
		if(e.getActionCommand().equals("R")) {
			if (!word.contains("r"))
			{
				h.addWrong();
				h.changeImage();
			}
			while (word.contains("r"))
			{
					letters.get(word.indexOf("r")).setVisible(true);
					word = word.substring(0, word.indexOf("r")) + "!" + word.substring(word.indexOf("r") + 1);
			}	
			buttons.get(17).setVisible(false);
		}
		
		if(e.getActionCommand().equals("S")) {
			if (!word.contains("s"))
			{
				h.addWrong();
				h.changeImage();
			}
			while (word.contains("s"))
			{
				letters.get(word.indexOf("s")).setVisible(true);
				word = word.substring(0, word.indexOf("s")) + "!" + word.substring(word.indexOf("s") + 1);
			}	
			buttons.get(18).setVisible(false);
		}
		
		if(e.getActionCommand().equals("T"))
		{
			if (!word.contains("t"))
			{
				h.addWrong();
				h.changeImage();
			}
			while (word.contains("t"))
			{
				letters.get(word.indexOf("t")).setVisible(true);
				word = word.substring(0, word.indexOf("t")) + "!" + word.substring(word.indexOf("t") + 1);
			}	
			buttons.get(19).setVisible(false);
		}
		
		if(e.getActionCommand().equals("U")) {
			if (!word.contains("u"))
			{
				h.addWrong();
				h.changeImage();
			}
			while (word.contains("u"))
			{
				letters.get(word.indexOf("u")).setVisible(true);
				word = word.substring(0, word.indexOf("u")) + "!" + word.substring(word.indexOf("u") + 1);
		 
			}	
			buttons.get(20).setVisible(false);
		}
		
		if(e.getActionCommand().equals("V"))
		{
			if (!word.contains("v"))
			{
				h.addWrong();
				h.changeImage();
			}
			while (word.contains("v"))
			{
				letters.get(word.indexOf("v")).setVisible(true);
				word = word.substring(0, word.indexOf("v")) + "!" + word.substring(word.indexOf("v") + 1);
			}	
			buttons.get(21).setVisible(false);
		}
		
		if(e.getActionCommand().equals("W"))
		{
			if (!word.contains("w"))
			{
				h.addWrong();
				h.changeImage();
			}
			while (word.contains("w"))
			{
				letters.get(word.indexOf("w")).setVisible(true);
				word = word.substring(0, word.indexOf("w")) + "!" + word.substring(word.indexOf("w") + 1);
			}	
				buttons.get(22).setVisible(false);
		}
		
		if(e.getActionCommand().equals("X")) {
			if (!word.contains("x"))
			{
				h.addWrong();
				h.changeImage();
			}
			while (word.contains("x"))
			{
				letters.get(word.indexOf("x")).setVisible(true);
				word = word.substring(0, word.indexOf("x")) + "!" + word.substring(word.indexOf("x") + 1);
			}	
			
			
			buttons.get(23).setVisible(false);
		}
		
		if(e.getActionCommand().equals("Y")) {
			if (!word.contains("y"))
			{
				h.addWrong();
				h.changeImage();
			}
			while (word.contains("y"))
			{
				letters.get(word.indexOf("y")).setVisible(true);
				word = word.substring(0, word.indexOf("y")) + "!" + word.substring(word.indexOf("y") + 1);
			}	
			buttons.get(24).setVisible(false);
		}
		
		if(e.getActionCommand().equals("Z"))
		{
			if (!word.contains("z"))
			{
				h.addWrong();
				h.changeImage();
			}
			while (word.contains("z"))
			{
				letters.get(word.indexOf("z")).setVisible(true);
				word = word.substring(0, word.indexOf("z")) + "!" + word.substring(word.indexOf("z") + 1);
			}	
			buttons.get(25).setVisible(false);
		
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