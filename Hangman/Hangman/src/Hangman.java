import java.awt.*;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import javax.swing.*;
import javax.swing.text.BadLocationException;
 
public class Hangman
{
	int right, wrong;
	ArrayList<ImageIcon> image = new ArrayList<ImageIcon>();
	String level;
	
	public Hangman(String difficult)
	{
		right = 0;
		wrong = 0;
		level = difficult;
	}
	
	public JPanel getPanel()
	{
		JPanel p = new JPanel();
		p.setBackground(Color.WHITE);
		ImageIcon ninja1 = new ImageIcon("ninja.jpg");
		JLabel nin = new JLabel(ninja1);
		p.add(nin);
		return p;
	}
}
