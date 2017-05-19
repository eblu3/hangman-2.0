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
	ArrayList<JLabel> letters;
	ArrayList<String> alphabet;
	Difficulty d;
	String word;
	Hangman h;
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
	word = d.getPhrase();
	System.out.println(word);
	
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
	System.out.println(word);
	 
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
	System.out.println(word);
	 
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
	JPanel p = new JPanel(new GridLayout(2,word.length()));
	p.setPreferredSize(new Dimension(150,150));
	p.setBackground(new Color(234, 124, 110));
	
	for(int i =0; i < word.length(); i++)
	{
	JLabel let = new JLabel(word.substring(i,i+1)); 
	let.setFont(new Font("ChalkBoard", Font.BOLD, 40));
	//let.setPreferredSize(new Dimension(10,10)); 
	letters.add(let);
	
	p.add(let);
	let.setVisible(false);
	
	}
	
	for(int i = 0; i < word.length(); i++)
	{
	JLabel blank = new JLabel("_"); 
	blank.setFont(new Font("ChalkBoard", Font.BOLD,40));
	//blank.setPreferredSize(new Dimension(10,10));
	

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
	if(e.getActionCommand().equals("A"))
	{	
	while(word.indexOf("a") >= 0)
	{
	letters.get(word.indexOf("a")).setVisible(true);
	word = word.substring(0, word.indexOf("a")) + "!" + word.substring(word.indexOf("a") + 1);
	 
	}
	
	buttons.get(0).setVisible(false);
	
	}
	
	if(e.getActionCommand().equals("B"))
	{
	while(word.indexOf("b") >= 0)
	{
	letters.get(word.indexOf("b")).setVisible(true);
	word = word.substring(0, word.indexOf("b")) + "!" + word.substring(word.indexOf("b") + 1);
	}	
	
	buttons.get(1).setVisible(false);
	}
	
	if(e.getActionCommand().equals("C"))
	{	

	while(word.indexOf("c") >= 0)
	{
	letters.get(word.indexOf("c")).setVisible(true);
	word = word.substring(0, word.indexOf("c")) + "!" + word.substring(word.indexOf("c") + 1);
	}	
	
	buttons.get(2).setVisible(false);
	
	}
	
	if(e.getActionCommand().equals("D"))
	{	
	while(word.indexOf("d") >= 0)
	{
	letters.get(word.indexOf("d")).setVisible(true);
	word = word.substring(0, word.indexOf("d")) + "!" + word.substring(word.indexOf("d") + 1);
	}	
	
	buttons.get(3).setVisible(false);
	
	}
	
	if(e.getActionCommand().equals("E"))
	{	
	while(word.indexOf("e") >= 0)
	{
	letters.get(word.indexOf("e")).setVisible(true);
	word = word.substring(0, word.indexOf("e")) + "!" + word.substring(word.indexOf("e") + 1);
	 
	}	
	buttons.get(4).setVisible(false);
	
	}
	
	if(e.getActionCommand().equals("F"))
	{	
	while(word.indexOf("f") >= 0)
	{
	letters.get(word.indexOf("f")).setVisible(true);
	word = word.substring(0, word.indexOf("f")) + "!" + word.substring(word.indexOf("f") + 1);
	}	
	buttons.get(5).setVisible(false);
	
	}
	
	if(e.getActionCommand().equals("G"))
	{	
	while(word.indexOf("g") >= 0)
	{
	letters.get(word.indexOf("g")).setVisible(true);
	word = word.substring(0, word.indexOf("g")) + "!" + word.substring(word.indexOf("g") + 1);
	}	
	buttons.get(6).setVisible(false);
	
	}
	
	if(e.getActionCommand().equals("H"))
	{	
	
	while(word.indexOf("h") >= 0)
	{
	letters.get(word.indexOf("h")).setVisible(true);
	word = word.substring(0, word.indexOf("h")) + "!" + word.substring(word.indexOf("h") + 1);
	}	
	buttons.get(7).setVisible(false);
	
	}
	
	if(e.getActionCommand().equals("I"))
	{	
	while(word.indexOf("i") >= 0)
	{
	letters.get(word.indexOf("i")).setVisible(true);
	word = word.substring(0, word.indexOf("i")) + "!" + word.substring(word.indexOf("i") + 1);
	 
	}	
	
	buttons.get(8).setVisible(false);
	
	}
	
	if(e.getActionCommand().equals("J"))
	{	
	while(word.indexOf("j") >= 0)
	{
	letters.get(word.indexOf("j")).setVisible(true);
	word = word.substring(0, word.indexOf("j")) + "!" + word.substring(word.indexOf("j") + 1);
	}	
	buttons.get(9).setVisible(false);
	
	}
	
	if(e.getActionCommand().equals("K"))
	{	
	while(word.indexOf("k") >= 0)
	{
	letters.get(word.indexOf("k")).setVisible(true);
	word = word.substring(0, word.indexOf("k")) + "!" + word.substring(word.indexOf("k") + 1);
	}	
	buttons.get(10).setVisible(false);
	
	}
	
	if(e.getActionCommand().equals("L"))
	{	
	while(word.indexOf("l") >= 0)
	{
	letters.get(word.indexOf("l")).setVisible(true);
	word = word.substring(0, word.indexOf("l")) + "!" + word.substring(word.indexOf("l") + 1);
	}	
	buttons.get(11).setVisible(false);
	}
	
	if(e.getActionCommand().equals("M"))
	{	
	while(word.indexOf("m") >= 0)
	{
	letters.get(word.indexOf("m")).setVisible(true);
	word = word.substring(0, word.indexOf("m")) + "!" + word.substring(word.indexOf("m") + 1);
	}	
	buttons.get(12).setVisible(false);
	}
	
	if(e.getActionCommand().equals("N"))
	{	
	while(word.indexOf("n") >= 0)
	{
	letters.get(word.indexOf("n")).setVisible(true);
	word = word.substring(0, word.indexOf("n")) + "!" + word.substring(word.indexOf("n") + 1);
	}	
	buttons.get(13).setVisible(false);
	}
	
	if(e.getActionCommand().equals("O"))
	{	
	while(word.indexOf("o") >= 0)
	{
	letters.get(word.indexOf("o")).setVisible(true);
	word = word.substring(0, word.indexOf("o")) + "!" + word.substring(word.indexOf("o") + 1);
	 
	}	
	buttons.get(14).setVisible(false);
	}
	
	if(e.getActionCommand().equals("P"))
	{	
	while(word.indexOf("p") >= 0)
	{
	letters.get(word.indexOf("p")).setVisible(true);
	word = word.substring(0, word.indexOf("p")) + "!" + word.substring(word.indexOf("p") + 1);
	}	
	buttons.get(15).setVisible(false);
	}
	
	if(e.getActionCommand().equals("Q"))
	{	
	while(word.indexOf("q") >= 0)
	{
	letters.get(word.indexOf("q")).setVisible(true);
	word = word.substring(0, word.indexOf("q")) + "!" + word.substring(word.indexOf("q") + 1);
	}	
	buttons.get(16).setVisible(false);
	}
	
	if(e.getActionCommand().equals("R"))
	{	
	while(word.indexOf("r") >= 0)
	{
	letters.get(word.indexOf("r")).setVisible(true);
	word = word.substring(0, word.indexOf("r")) + "!" + word.substring(word.indexOf("r") + 1);
	}	
	buttons.get(17).setVisible(false);
	}
	
	if(e.getActionCommand().equals("S"))
	{	
	while(word.indexOf("s") >= 0)
	{
	letters.get(word.indexOf("s")).setVisible(true);
	word = word.substring(0, word.indexOf("s")) + "!" + word.substring(word.indexOf("s") + 1);
	}	
	buttons.get(18).setVisible(false);
	}
	
	if(e.getActionCommand().equals("T"))
	{
	while(word.indexOf("t") >= 0)
	{
	letters.get(word.indexOf("t")).setVisible(true);
	word = word.substring(0, word.indexOf("t")) + "!" + word.substring(word.indexOf("t") + 1);
	}	
	buttons.get(19).setVisible(false);
	}
	
	if(e.getActionCommand().equals("U"))
	{	
	while(word.indexOf("u") >= 0)
	{
	letters.get(word.indexOf("u")).setVisible(true);
	word = word.substring(0, word.indexOf("u")) + "!" + word.substring(word.indexOf("u") + 1);
	 
	}	
	buttons.get(20).setVisible(false);
	}
	
	if(e.getActionCommand().equals("V"))
	{
	while(word.indexOf("v") >= 0)
	{
	letters.get(word.indexOf("v")).setVisible(true);
	word = word.substring(0, word.indexOf("v")) + "!" + word.substring(word.indexOf("v") + 1);
	}	
	buttons.get(21).setVisible(false);
	}
	
	if(e.getActionCommand().equals("W"))
	{
	while(word.indexOf("w") >= 0)
	{
	letters.get(word.indexOf("w")).setVisible(true);
	word = word.substring(0, word.indexOf("w")) + "!" + word.substring(word.indexOf("w") + 1);
	}	
	buttons.get(22).setVisible(false);
	}
	
	if(e.getActionCommand().equals("X"))
	{	
	while(word.indexOf("x") >= 0)
	{
	letters.get(word.indexOf("x")).setVisible(true);
	word = word.substring(0, word.indexOf("x")) + "!" + word.substring(word.indexOf("x") + 1);
	}	
	buttons.get(23).setVisible(false);
	}
	
	if(e.getActionCommand().equals("Y"))
	{	
	while(word.indexOf("y") >= 0)
	{
	letters.get(word.indexOf("y")).setVisible(true);
	word = word.substring(0, word.indexOf("y")) + "!" + word.substring(word.indexOf("y") + 1);
	}	
	buttons.get(24).setVisible(false);
	}
	if(e.getActionCommand().equals("Z"))
	{
	while(word.indexOf("z") >= 0)
	{
	letters.get(word.indexOf("z")).setVisible(true);
	word = word.substring(0, word.indexOf("z")) + "!" + word.substring(word.indexOf("z") + 1);
	}	
	buttons.get(25).setVisible(false);
	
	}
	}

}
