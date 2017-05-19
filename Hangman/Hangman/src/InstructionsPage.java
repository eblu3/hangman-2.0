import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class InstructionsPage extends JFrame implements ActionListener
{
	private static final long serialVersionUID = -8834323742424624104L;

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
				instructions.insertString(instructions.getLength(), line.next(), new SimpleAttributeSet());
			
			instructions.insertString(instructions.getLength(), System.lineSeparator(), new SimpleAttributeSet());
		}
		
		file.close();
		
		instructions.remove(instructions.getLength()-1, 1);
		
		instructionsField.setDocument(instructions);
		instructionsField.setEditable(false);
		
		p.add(instructionsField);
		
		return p;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
					
	}
}