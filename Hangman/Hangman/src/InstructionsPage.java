import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class InstructionsPage extends JFrame
{
	private static final long serialVersionUID = -8834323742424624104L;

	public JPanel getPanel() throws FileNotFoundException, BadLocationException
	{
		setSize(800,800);
		setLocationRelativeTo(null);
		
		//Label
		JLabel l = new JLabel("Instructions");
		l.setFont(new Font("ChalkBoard", Font.BOLD, 50));
		
		//Main panel
		JPanel p = new JPanel();
		p.setBackground(new Color(198,255,26));
		
		//Instructions panel
		JPanel instructionsPanel = new JPanel();
		instructionsPanel.setLayout(new BorderLayout());
		instructionsPanel.setBackground(new Color(198,255,26));
		add(instructionsPanel);
		
		JTextArea instructionsField = new JTextArea();
		Document instructions = new PlainDocument();
		
		Scanner file = new Scanner(new File("instructions.txt"));
		Scanner line;
		
		while(file.hasNextLine()) //Reading in the Instructions.txt Filer
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
		instructionsField.setPreferredSize(new Dimension(800,800));
		instructionsField.setFont(new Font("ChalkBoard", Font.PLAIN, 20));
		instructionsField.setBackground(new Color(198,255,26));
		
		instructionsPanel.add(l, BorderLayout.PAGE_START);
		instructionsPanel.add(instructionsField, BorderLayout.CENTER);
		
		p.add(instructionsPanel, BorderLayout.CENTER);
		
		return p;
	}
}