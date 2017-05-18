import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.*;

import javax.swing.*;
import javax.swing.text.TabSet;

public class Board implements ActionListener
{
	ArrayList<JButton> buttons;
	Difficulty d;
	String word;
	public Board()
	{
		buttons = new ArrayList<JButton>();
		
		for(int i = 65; i <= 90; i++) //Creating Alphabet Letters
		{
			String name = (char)i + "";
			buttons.add(new JButton(name));		
		}
	}
	
	public JPanel getEasyPanel()throws FileNotFoundException
	{
		d = new Difficulty("easy");
		word = d.getPhrase();
		
		JPanel game = new JPanel(new GridLayout(2,2)); //Game Consel
		
		game.setBackground(new Color(51, 153, 255));
		game.setPreferredSize(new Dimension(1300,700));

		game.add(hangmanBox());
		game.add(getKeyboard());
		game.add(new JPanel()); //Score
		game.add(new JPanel()); //Hangman

		return game;
	}
	
	public JPanel getMediumPanel()throws FileNotFoundException
	{
		d = new Difficulty("medium");
		word = d.getPhrase();
		
		JPanel game = new JPanel(new GridLayout(2,2)); //Game Consel
		
		game.setBackground(new Color(51, 153, 255));
		game.setPreferredSize(new Dimension(1300,700));

		game.add(hangmanBox());
		game.add(getKeyboard());
		game.add(new JPanel()); //Score
		game.add(new JPanel()); //Hangman

		return game;
	}
	
	public JPanel getHardPanel()throws FileNotFoundException
	{
		d = new Difficulty("hard");
		word = d.getPhrase();
		
		JPanel game = new JPanel(new GridLayout(2,2)); //Game Consel
		
		game.setBackground(new Color(51, 153, 255));
		game.setPreferredSize(new Dimension(1300,700));

		game.add(hangmanBox());
		game.add(getKeyboard());
		game.add(new JPanel()); //Score
		game.add(new JPanel()); //Hangman

		return game;
	}
	
	private JPanel hangmanBox()
	{
		JPanel p = new JPanel(new GridLayout(1,9));
		p.setPreferredSize(new Dimension(150,150));
		for(int i =0; i < word.length(); i++)
		{
			JLabel blank = new JLabel("__");
			blank.setFont(new Font("ChalkBoard", Font.BOLD, 50));
			blank.setPreferredSize(new Dimension(20,20));
			
			p.add(blank); 
			
		}
		
		return p;
	}
	
	public JPanel getKeyboard()
	{
		JPanel keyboard = new JPanel();
		keyboard.setBackground(new Color(224, 187, 249));
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
		return keyboard;
	}
	public void actionPerformed(ActionEvent e) 
	{
		for(JButton i: buttons)
		{
			if(e.getActionCommand().equals(i))
			{
				break; //THIS IS WHERE I LEFT OFF
			}
		}
	}

}