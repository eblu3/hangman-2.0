import java.awt.Color;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class InstructionsPage extends JFrame implements ActionListener
{
	public JPanel getPanel()
	{
		//Panel
		JPanel p = new JPanel();
		p.setLayout(null);
		p.setBackground(new Color(255, 163, 26));
	
		setVisible(true);
		
		return p;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
					
	}
}