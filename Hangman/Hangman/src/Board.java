import java.awt.*;
import java.awt.font.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.*;
import javax.swing.*;

public class Board implements ActionListener
{
	private ArrayList<JButton> buttons;
	private ArrayList<JLabel> letters;
	private ArrayList<JLabel> visibleLetters;
	private JLabel word1, word2, gameover;
	private JPanel keys;
	private Difficulty d;
	private String word;
	private Hangman h;
	private Font font = new Font("ChalkBoard", Font.BOLD,40);
	private Map<TextAttribute, Object> map = new Hashtable<TextAttribute, Object>();
	private JLabel let = new JLabel("", SwingConstants.CENTER);
	boolean gameWon = true;
	
	public Board()
	{
		buttons = new ArrayList<JButton>();
		letters = new ArrayList<JLabel>();
		gameWon = true;
		
		
		map.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
		font = font.deriveFont(map);
		
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
		
		for(int i = 0; i < word.length(); i++)
		{
			JLabel add = new JLabel(word.substring(i, i+1), SwingConstants.CENTER);
			add.setFont(font);
			letters.add(add);
		}
		
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
		
		for(int i = 0; i < word.length(); i++)
		{
			letters.add(new JLabel(word.substring(i, i+1)));
		}
		
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
		
		for(int i = 0; i < word.length(); i++)
		{
			letters.add(new JLabel(word.substring(i, i+1)));
		}
		
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
		
		p.setPreferredSize(new Dimension(150,150));
		p.setBackground(new Color(234, 124, 110));
		
		visibleLetters = (ArrayList<JLabel>) letters.clone();
		
		let.setFont(font);
	
		for(int i =0; i < letters.size(); i++)
		{
			
		}
		
		p.add(let);
		
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
			System.out.println("game won");
			
//			for(JButton i: buttons)
//			{
//				i.setVisible(false);
//			}
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