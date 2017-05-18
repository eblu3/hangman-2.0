import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class InstructionsPage extends JFrame implements ActionListener
{
	public static void main(String[] args) throws FileNotFoundException, BadLocationException
	{
		JFrame window = new JFrame();
		InstructionsPage test = new InstructionsPage();
		window.setDefaultCloseOperation(EXIT_ON_CLOSE);
		window.add(test.getPanel());
		window.setSize(800,800);
		window.setVisible(true);
	}
	
	public JPanel getPanel() throws FileNotFoundException, BadLocationException
	{
		//Panel
		JPanel p = new JPanel();
		p.setLayout(new FlowLayout());
		p.setBackground(new Color(255, 163, 26));
		
		JTextArea instructionsField = new JTextArea();
		Document instructions = new PlainDocument();
		
		Scanner file = new Scanner(new File("instructions.txt"));
		Scanner line;
		
		while(file.hasNextLine())
		{
			line = new Scanner(file.nextLine());
			line.useDelimiter("");
			
			while(line.hasNext())
			{
				String nextChar = line.next();
				
				System.out.println(nextChar);
				
				instructions.insertString(instructions.getLength(), nextChar, new SimpleAttributeSet());
			}
			
			instructions.insertString(instructions.getLength(), System.lineSeparator(), new SimpleAttributeSet());
		}
		
		file.close();
		
		instructionsField.setDocument(instructions);
		
		p.add(instructionsField);
	
		setVisible(true);
		
		return p;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
					
	}
}