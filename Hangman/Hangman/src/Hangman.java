import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

 
public class Hangman
{
	private int wrong;
	private ArrayList<JLabel> images;
	private String level;
	
	/**
	 * constructs Hangman with specified difficulty
	 * @param difficulty
	 */
	public Hangman(String difficult)
	{
		wrong = 0;
		level = difficult;
		images =  new ArrayList<JLabel>();
		
		if(level.equalsIgnoreCase("easy")) //Adding ninja images to ArrayList
		{
			ImageIcon n1 = new ImageIcon("Ninja1.jpg");
			images.add(new JLabel(n1));
			
			ImageIcon n2 = new ImageIcon("ninja2.jpg");
			images.add(new JLabel(n2));
			
			ImageIcon n3 = new ImageIcon("ninja3.jpg");
			images.add(new JLabel(n3));
			
			ImageIcon n4 = new ImageIcon("ninja4.jpg");
			images.add(new JLabel(n4));
			
			ImageIcon n5 = new ImageIcon("ninja5.jpg");
			images.add(new JLabel(n5));
			
			ImageIcon n6 = new ImageIcon("Ninja6.jpg");
			images.add(new JLabel(n6));
			
			ImageIcon n7 = new ImageIcon("Ninja7.jpg");
			images.add(new JLabel(n7));
		}
		
		if(level.equalsIgnoreCase("medium")) //Adding Cowboy images to ArrayList
		{
			
			ImageIcon c1 = new ImageIcon("Cowboy1.jpg");
			images.add(new JLabel(c1));
			
			ImageIcon c2 = new ImageIcon("Cowboy2.jpg");
			images.add(new JLabel(c2));
			
			ImageIcon c3 = new ImageIcon("Cowboy3.jpg");
			images.add(new JLabel(c3));
			
			ImageIcon c4 = new ImageIcon("Cowboy4.jpg");
			images.add(new JLabel(c4));
			
			ImageIcon c5 = new ImageIcon("Cowboy5.jpg");
			images.add(new JLabel(c5));
			
			ImageIcon c6 = new ImageIcon("Cowboy6.jpg");
			images.add(new JLabel(c6));
		}
		
		if(level.equalsIgnoreCase("hard")) //Adding Stites images to ArrayList
		{
			ImageIcon s1 = new ImageIcon("stites1.jpg");
			images.add(new JLabel(s1));
			
			ImageIcon s2 = new ImageIcon("stites2.jpg");
			images.add(new JLabel(s2));
			
			ImageIcon s3 = new ImageIcon("stites3.jpg");
			images.add(new JLabel(s3));
			
			ImageIcon s4 = new ImageIcon("stites4.jpg");
			images.add(new JLabel(s4));
			
			ImageIcon s5 = new ImageIcon("stites5.jpg");
			images.add(new JLabel(s5));
			
			ImageIcon s6 = new ImageIcon("stites7.jpg");
			images.add(new JLabel(s6));
		}
	}
	
	/**
	 * returns hangman box panel
	 * @return hangman box panel
	 */
	public JPanel getPanel()
	{
		JPanel p = new JPanel(new CardLayout());
		p.setBackground(Color.WHITE);
		for(JLabel i:images) //Add images to final panel, but all are "invisible"
		{
			p.add(i);
			i.setVisible(false);
		}	
		return p;
	}
	
	/**
	 * switches layers of card layout
	 */
	public void changeImage()
	{
		images.get(wrong-1).setVisible(false);
		images.get(wrong).setVisible(true);
	}
	
	/**
	 * checks if player has lost
	 * @return false if the player has not lost, true otherwise
	 */
	public boolean lost()
	{
		if(level.equals("easy") && wrong >= 6)
			return true;
		else if(level.equals("medium") && wrong >= 5)
			return true;
		else if(level.equals("hard") && wrong >= 5)
			return true;
		return false;
	}
	
	/**
	 * increments wrong by 1
	 */
	public void addWrong()
	{
		wrong += 1;
	}
}