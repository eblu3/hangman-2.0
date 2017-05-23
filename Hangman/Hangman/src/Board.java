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
	private JLabel word1, word2, gameover;
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
		System.out.println(word);
		
		JPanel game = new JPanel(new GridLayout()); //Game Consel
		
		game.setBackground(new Color(51, 153, 255));
		game.setPreferredSize(new Dimension(800,800));
	
		game.add(hangmanBox());
		game.add(getKeyboard());
		game.add(h.getPanel()); //Hangman
	
		return game;
	}
		
	public JPanel getMediumPanel()throws FileNotFoundException
	{
		d = new Difficulty("medium");
		word = d.getPhrase();
		h = new Hangman("medium");
		System.out.println(word);
		 
		JPanel game = new JPanel(new GridLayout()); //Game Consel
		
		game.setBackground(new Color(51, 153, 255));
		game.setPreferredSize(new Dimension(800,800));
	
		game.add(hangmanBox());
		game.add(getKeyboard());
		game.add(h.getPanel()); //Hangman
	
		return game;
	}
	
	public JPanel getHardPanel()throws FileNotFoundException
	{
		d = new Difficulty("hard");
		h = new Hangman("hard");
		word = d.getPhrase();
		System.out.println(word);
		 
		JPanel game = new JPanel(new GridLayout()); //Game Consel
		
		game.setBackground(new Color(51, 153, 255));
		game.setPreferredSize(new Dimension(800,800));
	
		game.add(hangmanBox());
		game.add(getKeyboard());
		game.add(h.getPanel()); //Hangman
	
		return game;
		}
	
	private JPanel hangmanBox()
	{
		JPanel p = new JPanel(new GridLayout(3,word.length() - 1));
		word1 = new JLabel("Game");
		word2 = new JLabel("Won");
		word1.setFont(new Font("ChalkBoard", Font.BOLD, 20));
		word2.setFont(new Font("ChalkBoard", Font.BOLD, 20));
		
		for(int i =0; i < word.length() -1; i++)
		{
			if(i == (word.length() / 2) -1)
				p.add(word1);
			if(i == (word.length() / 2))
				p.add(word2);
			else
				p.add(new JLabel());
		}
		
		word1.setVisible(false);
		word2.setVisible(false);
		
		p.setPreferredSize(new Dimension(150,150));
		p.setBackground(new Color(234, 124, 110));
	
		for(int i =0; i < word.length(); i++)
		{
			JLabel let = new JLabel(word.substring(i,i+1)); 
			let.setFont(new Font("ChalkBoard", Font.BOLD, 40));
			let.setPreferredSize(new Dimension(5,5)); 
			letters.add(let);
		
			p.add(let);
			let.setVisible(false);
		
		}
	
		for(int i = 0; i < word.length(); i++)
		{
			JLabel blank = new JLabel("_"); 
			blank.setFont(new Font("ChalkBoard", Font.BOLD,40));
			blank.setPreferredSize(new Dimension(5,5));
			p.add(blank); 
		}
	
		return p;
	}
	
	public JPanel getKeyboard()
	{
		keys = new JPanel(new CardLayout());
		
		JPanel keyboard = new JPanel();
		keyboard.setBackground(new Color(224, 187, 249));
		keyboard.setLayout(new GridLayout(5,4));
		keyboard.setLocation(600,600);
		for(JButton i: buttons)
		{
			keyboard.add(i);
			i.setFont(new Font("ChalkBoard", Font.BOLD, 20)); 
			i.addActionListener(this);
		}
		
		gameover = new JLabel("GAME OVER", SwingConstants.CENTER);
		gameover.setFont(new Font("ChalkBoard", Font.BOLD,40));
		gameover.setForeground(new Color(0,0,255));
		
		keys.add(gameover);
		keys.add(keyboard);
		keyboard.setVisible(true);
		gameover.setVisible(false);
		
		return keys;
	}
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getActionCommand().equals("A"))
		{	
			if(word.indexOf("a") < 0)
			{
				h.addWrong();
				h.changeImage();
			}
			while(word.indexOf("a") >= 0)
			{
				letters.get(word.indexOf("a")).setVisible(true);
				word = word.substring(0, word.indexOf("a")) + "!" + word.substring(word.indexOf("a") + 1);
			}
			buttons.get(0).setVisible(false);	
		}
	
		if(e.getActionCommand().equals("B"))
		{
			if(word.indexOf("b") < 0)
			{
				h.addWrong();
				h.changeImage();
			}
			while(word.indexOf("b") >= 0)
			{
				letters.get(word.indexOf("b")).setVisible(true);
				word = word.substring(0, word.indexOf("b")) + "!" + word.substring(word.indexOf("b") + 1);
			}	
			
			buttons.get(1).setVisible(false);
		}
		
		if(e.getActionCommand().equals("C"))
		{	
			if(word.indexOf("c") < 0)
			{
				h.addWrong();
				h.changeImage();
			}
			while(word.indexOf("c") >= 0)
			{
				letters.get(word.indexOf("c")).setVisible(true);
				word = word.substring(0, word.indexOf("c")) + "!" + word.substring(word.indexOf("c") + 1);
			}	
			buttons.get(2).setVisible(false);
		}
		
		if(e.getActionCommand().equals("D"))
		{	
			if(word.indexOf("d") < 0)
			{
				h.addWrong();
				h.changeImage();
			}
			while(word.indexOf("d") >= 0)
			{
				letters.get(word.indexOf("d")).setVisible(true);
				word = word.substring(0, word.indexOf("d")) + "!" + word.substring(word.indexOf("d") + 1);
			}	
			
			buttons.get(3).setVisible(false);
		
		}
		
		if(e.getActionCommand().equals("E"))
		{	
			if(word.indexOf("e") < 0)
			{
				h.addWrong();
				h.changeImage();
			}
			while(word.indexOf("e") >= 0)
			{
				letters.get(word.indexOf("e")).setVisible(true);
				word = word.substring(0, word.indexOf("e")) + "!" + word.substring(word.indexOf("e") + 1);
			 
			}	
			buttons.get(4).setVisible(false);
			
		}
		
		if(e.getActionCommand().equals("F"))
		{	
			if(word.indexOf("f") < 0)
			{
				h.addWrong();
				h.changeImage();
			}
			while(word.indexOf("f") >= 0)
			{
				letters.get(word.indexOf("f")).setVisible(true);
				word = word.substring(0, word.indexOf("f")) + "!" + word.substring(word.indexOf("f") + 1);
			}	
			buttons.get(5).setVisible(false);
		
		}
		
		if(e.getActionCommand().equals("G"))
		{	
			if(word.indexOf("g") < 0)
			{
				h.addWrong();
				h.changeImage();
			}
			while(word.indexOf("g") >= 0)
			{
				letters.get(word.indexOf("g")).setVisible(true);
				word = word.substring(0, word.indexOf("g")) + "!" + word.substring(word.indexOf("g") + 1);
			}	
			buttons.get(6).setVisible(false);
		
		}
		
		if(e.getActionCommand().equals("H"))
		{	
			if(word.indexOf("h") < 0)
			{
				h.addWrong();
				h.changeImage();
			}
			while(word.indexOf("h") >= 0)
			{
				letters.get(word.indexOf("h")).setVisible(true);
				word = word.substring(0, word.indexOf("h")) + "!" + word.substring(word.indexOf("h") + 1);
			}	
			buttons.get(7).setVisible(false);	
		}
		
		if(e.getActionCommand().equals("I"))
		{	
			if(word.indexOf("i") < 0)
			{
				h.addWrong();
				h.changeImage();
			}
			while(word.indexOf("i") >= 0)
			{
				letters.get(word.indexOf("i")).setVisible(true);
				word = word.substring(0, word.indexOf("i")) + "!" + word.substring(word.indexOf("i") + 1);		 
			}			
			buttons.get(8).setVisible(false);		
		}
		
		if(e.getActionCommand().equals("J"))
		{	
			if(word.indexOf("j") < 0)
			{
				h.addWrong();
				h.changeImage();
			}
			while(word.indexOf("j") >= 0)
			{
				letters.get(word.indexOf("j")).setVisible(true);
				word = word.substring(0, word.indexOf("j")) + "!" + word.substring(word.indexOf("j") + 1);
			}	
			buttons.get(9).setVisible(false);
		
		}
		
		if(e.getActionCommand().equals("K"))
		{	
			if(word.indexOf("k") < 0)
			{
				h.addWrong();
				h.changeImage();
			}
			while(word.indexOf("k") >= 0)
			{
				letters.get(word.indexOf("k")).setVisible(true);
				word = word.substring(0, word.indexOf("k")) + "!" + word.substring(word.indexOf("k") + 1);
			}	
			buttons.get(10).setVisible(false);
		
		}
		
		if(e.getActionCommand().equals("L"))
		{	
			if(word.indexOf("l") < 0)
			{
				h.addWrong();
				h.changeImage();
			}
			while(word.indexOf("l") >= 0)
			{
				letters.get(word.indexOf("l")).setVisible(true);
				word = word.substring(0, word.indexOf("l")) + "!" + word.substring(word.indexOf("l") + 1);
			}	
				buttons.get(11).setVisible(false);
		}
		
		if(e.getActionCommand().equals("M"))
		{	
			if(word.indexOf("m") < 0)
			{
				h.addWrong();
				h.changeImage();
			}
			while(word.indexOf("m") >= 0)
			{
				letters.get(word.indexOf("m")).setVisible(true);
				word = word.substring(0, word.indexOf("m")) + "!" + word.substring(word.indexOf("m") + 1);
			}	
			buttons.get(12).setVisible(false);
		}
		
		if(e.getActionCommand().equals("N"))
		{	
			if(word.indexOf("n") < 0)
			{
				h.addWrong();
				h.changeImage();
			}
			while(word.indexOf("n") >= 0)
			{
				letters.get(word.indexOf("n")).setVisible(true);
				word = word.substring(0, word.indexOf("n")) + "!" + word.substring(word.indexOf("n") + 1);
			}	
			buttons.get(13).setVisible(false);
		}
		
		if(e.getActionCommand().equals("O"))
		{	
			if(word.indexOf("o") < 0)
			{
				h.addWrong();
				h.changeImage();
			}
			while(word.indexOf("o") >= 0)
			{
				letters.get(word.indexOf("o")).setVisible(true);
				word = word.substring(0, word.indexOf("o")) + "!" + word.substring(word.indexOf("o") + 1);
		 
			}	
			buttons.get(14).setVisible(false);
		}
		
		if(e.getActionCommand().equals("P"))
		{	
			if(word.indexOf("p") < 0)
			{
				h.addWrong();
				h.changeImage();
			}
			while(word.indexOf("p") >= 0)
			{
			letters.get(word.indexOf("p")).setVisible(true);
			word = word.substring(0, word.indexOf("p")) + "!" + word.substring(word.indexOf("p") + 1);
			}	
			buttons.get(15).setVisible(false);
		}
		
		if(e.getActionCommand().equals("Q"))
		{	
			if(word.indexOf("q") < 0)
			{
				h.addWrong();
				h.changeImage();
			}
			while(word.indexOf("q") >= 0)
			{
				letters.get(word.indexOf("q")).setVisible(true);
				word = word.substring(0, word.indexOf("q")) + "!" + word.substring(word.indexOf("q") + 1);
		}	
		buttons.get(16).setVisible(false);
		}
		
		if(e.getActionCommand().equals("R"))
		{	
			if(word.indexOf("r") < 0)
			{
				h.addWrong();
				h.changeImage();
			}
			while(word.indexOf("r") >= 0)
			{
					letters.get(word.indexOf("r")).setVisible(true);
					word = word.substring(0, word.indexOf("r")) + "!" + word.substring(word.indexOf("r") + 1);
			}	
			buttons.get(17).setVisible(false);
		}
		
		if(e.getActionCommand().equals("S"))
		{	
			if(word.indexOf("s") < 0)
			{
				h.addWrong();
				h.changeImage();
			}
			while(word.indexOf("s") >= 0)
			{
				letters.get(word.indexOf("s")).setVisible(true);
				word = word.substring(0, word.indexOf("s")) + "!" + word.substring(word.indexOf("s") + 1);
			}	
			buttons.get(18).setVisible(false);
		}
		
		if(e.getActionCommand().equals("T"))
		{
			if(word.indexOf("t") < 0)
			{
				h.addWrong();
				h.changeImage();
			}
			while(word.indexOf("t") >= 0)
			{
				letters.get(word.indexOf("t")).setVisible(true);
				word = word.substring(0, word.indexOf("t")) + "!" + word.substring(word.indexOf("t") + 1);
			}	
			buttons.get(19).setVisible(false);
		}
		
		if(e.getActionCommand().equals("U"))
		{	
			if(word.indexOf("u") < 0)
			{
				h.addWrong();
				h.changeImage();
			}
			while(word.indexOf("u") >= 0)
			{
				letters.get(word.indexOf("u")).setVisible(true);
				word = word.substring(0, word.indexOf("u")) + "!" + word.substring(word.indexOf("u") + 1);
		 
			}	
			buttons.get(20).setVisible(false);
		}
		
		if(e.getActionCommand().equals("V"))
		{
			if(word.indexOf("v") < 0)
			{
				h.addWrong();
				h.changeImage();
			}
			while(word.indexOf("v") >= 0)
			{
				letters.get(word.indexOf("v")).setVisible(true);
				word = word.substring(0, word.indexOf("v")) + "!" + word.substring(word.indexOf("v") + 1);
			}	
			buttons.get(21).setVisible(false);
		}
		
		if(e.getActionCommand().equals("W"))
		{
			if(word.indexOf("w") < 0)
			{
				h.addWrong();
				h.changeImage();
			}
			while(word.indexOf("w") >= 0)
			{
				letters.get(word.indexOf("w")).setVisible(true);
				word = word.substring(0, word.indexOf("w")) + "!" + word.substring(word.indexOf("w") + 1);
			}	
				buttons.get(22).setVisible(false);
		}
		
		if(e.getActionCommand().equals("X"))
		{			
			if(word.indexOf("x") < 0)
			{
				h.addWrong();
				h.changeImage();
			}
			while(word.indexOf("x") >= 0)
			{
				letters.get(word.indexOf("x")).setVisible(true);
				word = word.substring(0, word.indexOf("x")) + "!" + word.substring(word.indexOf("x") + 1);
			}	
			
			
			buttons.get(23).setVisible(false);
		}
		
		if(e.getActionCommand().equals("Y"))
		{	
			if(word.indexOf("y") < 0)
			{
				h.addWrong();
				h.changeImage();
			}
			while(word.indexOf("y") >= 0)
			{
				letters.get(word.indexOf("y")).setVisible(true);
				word = word.substring(0, word.indexOf("y")) + "!" + word.substring(word.indexOf("y") + 1);
			}	
			buttons.get(24).setVisible(false);
		}
		
		if(e.getActionCommand().equals("Z"))
		{
			if(word.indexOf("z") < 0)
			{
				h.addWrong();
				h.changeImage();
			}
			while(word.indexOf("z") >= 0)
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
		
		if(gameWon == true)
		{
			word1.setVisible(true);
			word2.setVisible(true);
			System.out.println("game won");
		}
		
		if(h.lost())
		{
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