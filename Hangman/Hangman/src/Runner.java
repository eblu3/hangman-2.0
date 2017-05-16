import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

public class Runner
{
}

class Difficulty
{
	ArrayList<String> easy, medium, hard;
	String level;
	
	public Difficulty(String choice) throws FileNotFoundException
	{
		level = choice;
		Scanner scan = null;
		if(level.equals("easy")) //Generating Easy ArrayList
		{
			scan = new Scanner(new File("Easy.dat"));
			while(scan.hasNextLine())
			{
				String str = scan.nextLine();
				easy.add(str);
			}	
		}
		
		if(level.equals("medium")) //Generating Medium ArrayList
		{
			scan = new Scanner(new File("Medium.dat"));
			while(scan.hasNextLine())
			{
				String str = scan.nextLine();
				medium.add(str);
			}	
		}
		
		if(level.equals("hard")) //Generating Medium ArrayList
		{
			scan = new Scanner(new File("Hard.dat"));
			while(scan.hasNextLine())
			{
				String str = scan.nextLine();
				hard.add(str);
			}	
		}
	}
	
	public String getPhrase() //Generating a random Phrase
	{
		int phrase = (int)(Math.random() * 80) + 1;
		
		if(level.equals("easy"))
			return easy.get(phrase);
		if(level.equals("medium"))
			return medium.get(phrase);
		else
			return hard.get(phrase);
	}
}
