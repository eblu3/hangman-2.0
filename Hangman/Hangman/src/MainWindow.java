import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import javax.swing.*;
import javax.swing.text.BadLocationException;
 
public class MainWindow implements ActionListener
{
    private final static String PLAYGAME = "Game"; //Title of Tab1
    private final static String INSTRUCTIONS = "Instructions"; //Title of Tab2
    
    private InstructionsPage ins = new InstructionsPage();
    private Board board = new Board();
    private Hangman h;
    
    private JPanel game1, game2, game3, buttons, p, keyboard;
    private JButton b;
    private JComboBox<String> difficultySelector;
    private String[] difficulties = {"Easy", "Medium", "Hard"};
    private String level;
    
    public void addTabs(Container pane) throws FileNotFoundException 
    {
        JTabbedPane menu = new JTabbedPane(); //Creates Menu Pane

        buttons = new JPanel(); 
        buttons.setBackground(new Color(153, 255, 204));
        buttons.setLayout(new GridLayout());
        buttons.setMinimumSize(new Dimension(200, 200));
        
        p = new JPanel();
        p.setBackground(new Color(153, 255, 204));
        
        //Keyboard
        keyboard = board.getKeyboard();
        
        //Window of the Game Possibilities
        Board bo1 = new Board();
        game1 = bo1.getEasyPanel();
        Board bo2 = new Board();
        game2 = bo2.getMediumPanel();
        Board bo3 = new Board();
        game3 = bo3.getHardPanel();

        b = new JButton("Continue");
        difficultySelector = new JComboBox<String>(difficulties);
        
        buttons.add(difficultySelector);
        buttons.add(b);
        
        p.add(buttons);
        
        level = "Easy";

        keyboard.setVisible(true);
 
        JPanel instruct = null;
		try {
			instruct = ins.getPanel();
		} catch (BadLocationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} //Getting Panel From Instructor Class
        
        //Constructs Menu Pane
        menu.addTab(PLAYGAME, p);
        menu.addTab(INSTRUCTIONS, instruct);
 
        pane.add(menu);
        
        difficultySelector.addActionListener(this);
		b.addActionListener(this);
    }
    
	public void actionPerformed(ActionEvent e)
	{
		if(e.getActionCommand().contentEquals("Continue"))
		{
			b.setVisible(false);
			difficultySelector.setVisible(false);
			
			p.setLayout(new BorderLayout());
			
			//keyboard.setVisible(true);
			if(level.equals("Easy"))
			{
				p.add(game1, BorderLayout.CENTER);
			}
			if(level.equals("Medium"))
			{
				p.add(game2, BorderLayout.CENTER);
			}
			if(level.equals("Hard"))
			{
				p.add(game3, BorderLayout.CENTER);
			}
			
			p.setBackground(new Color(51, 153, 255));
		}
		else
		{
			level = (String) difficultySelector.getSelectedItem();
			
			System.out.println(level);
		}
	}

    public static void show()
    {
        //Create and set up the window.
        JFrame frame = new JFrame("HangMan 2.0");
        frame.setSize(800,800);
        frame.setMinimumSize(new Dimension(800,600));
        frame.setResizable(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        
        //Create and set up the content pane.
          MainWindow demo = new MainWindow();
          try 
          {
			demo.addTabs(frame.getContentPane());
          } 
          catch (FileNotFoundException e) 
          {
			e.printStackTrace();
          }
 
        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }
}