import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import javax.swing.*;
import javax.swing.text.BadLocationException;
 
public class Hangman
{
	int right, wrong;
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
		return p;
		
		
	}
}
