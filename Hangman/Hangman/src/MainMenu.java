import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainMenu extends JFrame implements ActionListener
{
	private static final long serialVersionUID = 9070635507881820105L;

	public static void main(String [] args)
	{
		new MainMenu();
	}
	
	public MainMenu()
	{
		super("Hangman 2.0 - Menu");
	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800,800);
		setLocationRelativeTo(null);
		JLabel l = new JLabel();

		//panel
		JPanel p = new JPanel();
		p.setLayout(null);
		p.setBackground(new Color(153, 255, 204));
	    
		//start button
		JButton b = new JButton("Start Game");
		b.setSize(200,75);
		b.setBackground(new Color(255, 128, 128)); //button purple
	    b.setForeground(Color.WHITE); // button is white for the font 
	    b.setFocusPainted(false);
	    b.setFont(new Font("ChalkBoard", Font.BOLD, 24));  // font , bold text, size of text
	    b.setLocation(160, 450);
	    b.setToolTipText("Click to begin"); // hover over text
	    
	    //instructions button
		JButton b2 = new JButton("Instructions");
		b2.setSize(200,75);
	    b2.setBackground(new Color(51, 153, 255)); //button purple
	    b2.setForeground(Color.WHITE); // button is white for the font 
	    b2.setFocusPainted(false);
	    b2.setFont(new Font("ChalkBoard", Font.BOLD, 24));  // font , bold text, size of text
		b2.setLocation(410,450);
	    b2.setToolTipText("Click to learn how to play"); // hover over text
		
		//adding items to frame
		p.add(b); //adding start button
		p.add(b2); //adding instructions button
		add(p); //adding panel
		
		b.addActionListener(this);
		b2.addActionListener(this);
		
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		System.out.println("Button clicked: " + e.getActionCommand());
	}
}