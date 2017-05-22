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
		setSize(800,800);
		setLocationRelativeTo(null);
		
		//Label
		JLabel l = new JLabel("Instructions");
		l.setFont(new Font("ChalkBoard", Font.BOLD, 20));
		
		//Main panel
		JPanel p = new JPanel();
		p.setBackground(new Color(255, 163, 26));
		
		//Instructions panel
		JPanel instructionsPanel = new JPanel();
		instructionsPanel.setLayout(new BorderLayout());
		instructionsPanel.setBackground(new Color(255, 163, 26));
		add(instructionsPanel);
		
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
		instructionsField.setMaximumSize(new Dimension(500,500));
		
		instructionsPanel.add(l, BorderLayout.PAGE_START);
		instructionsPanel.add(instructionsField, BorderLayout.CENTER);
		
		p.add(instructionsPanel, BorderLayout.CENTER);
		
		return p;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
					
	}
}