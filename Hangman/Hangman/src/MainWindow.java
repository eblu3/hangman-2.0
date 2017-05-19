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
    
    private JPanel game1, game2, game3, p, keyboard;
    private JButton b;
    private JComboBox<String> difficultySelector;
    private String[] difficulties = {"Easy", "Medium", "Hard"};
    private String level;
    
    public void addTabs(Container pane) throws FileNotFoundException 
    {
        JTabbedPane menu = new JTabbedPane(); //Creates Menu Pane

        p = new JPanel(); 
        p.setBackground(new Color(153, 255, 204));
        p.setLayout(new FlowLayout());
        
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

        b.setPreferredSize(new Dimension(300, 175));
        
        p.add(difficultySelector);
        p.add(b);
        p.add(game1);
        p.add(game2);
        p.add(game3);
        
        level = "Easy";

        game1.setVisible(false);
        game2.setVisible(false);
        game3.setVisible(false);
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
			//keyboard.setVisible(true);
			if(level.equals("Easy"))
			{
				game1.setVisible(true);
			}
			if(level.equals("Medium"))
			{
				game2.setVisible(true);
			}
			if(level.equals("Hard"))
			{
				game3.setVisible(true);
			}
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
        frame.setSize(1370,800);
        frame.setMinimumSize(new Dimension(1370,800));
        frame.setResizable(false);
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