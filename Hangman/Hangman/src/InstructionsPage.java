import java.awt.Color;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class InstructionsPage extends JFrame implements ActionListener
{

	public static void main (String args[])
	{
		new InstructionsPage();
	}
	
	public InstructionsPage()
	{
		setSize(800,800);
		setLocationRelativeTo(null);
		//Label
		JLabel l = new JLabel("Instructions");
	
		//Panel
		JPanel p = new JPanel();
		p.setLayout(null);
		p.setBackground(new Color(255, 163, 26));
		
		add(p);
		p.add(l);
	
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
					
	}
}

