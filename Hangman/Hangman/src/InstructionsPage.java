import java.awt.Color;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class InstructionsPage extends JFrame implements ActionListener
{
	public JPanel getPanel()
	{
<<<<<<< HEAD
		setSize(800,800);
		setLocationRelativeTo(null);
		//Label
		JLabel l = new JLabel("Instructions");
	
=======
>>>>>>> 95bea8d6c82ae53e3502bea0e880294ea049241a
		//Panel
		JPanel p = new JPanel();
		p.setLayout(null);
		p.setBackground(new Color(255, 163, 26));
<<<<<<< HEAD
		
		add(p);
		p.add(l);
=======
>>>>>>> 95bea8d6c82ae53e3502bea0e880294ea049241a
	
		setVisible(true);
		
		return p;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
					
	}
}