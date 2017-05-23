import java.awt.*;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import javax.swing.*;
import javax.swing.text.BadLocationException;
 
public class Hangman implements ActionListener
{
	int right, wrong;
	ArrayList<JLabel> images = new ArrayList<JLabel>();
	String level;
	
	public Hangman(String difficult)
	{
		wrong = 0;
		level = difficult;
		
		
		if(level.equalsIgnoreCase("easy"))
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
		
		if(level.equalsIgnoreCase("medium"))
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
		
		if(level.equalsIgnoreCase("hard"))
		{
			
		}
	}
	
	
	public JPanel getPanel()
	{
		JPanel p = new JPanel(new CardLayout());
		p.setBackground(Color.WHITE);

		for(JLabel i:images)
		{
			p.add(i);
			i.setVisible(false);
		}
		
		return p;
	}
	
	public void changeImage()
	{
		images.get(wrong-1).setVisible(false);
		images.get(wrong).setVisible(true);
	}
	
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
	public void addWrong()
	{
		wrong += 1;
	}


	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getActionCommand().equals("A"))
		{
			changeImage();
		}
	}
}