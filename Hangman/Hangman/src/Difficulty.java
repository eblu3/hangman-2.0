import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

class Difficulty
{
	ArrayList<String> easy, medium, hard;
	String level;
	
	public Difficulty(String choice) throws FileNotFoundException
	{
		level = choice;
		Scanner scan = null;
		switch(choice)
		{
		case "easy": //setting word bank to easy words
			scan = new Scanner(new File("Easy.dat"));
			while(scan.hasNextLine())
			{
				String str = scan.nextLine();
				easy.add(str);
			}
			break;
			
		case "medium": //setting word bank to medium words
			scan = new Scanner(new File("Medium.dat"));
			while(scan.hasNextLine())
			{
				String str = scan.nextLine();
				medium.add(str);
			}
			break;
			
		case "hard": //setting word bank to hard words
			scan = new Scanner(new File("Hard.dat"));
			while(scan.hasNextLine())
			{
				String str = scan.nextLine();
				hard.add(str);
			}
			break;
			
		default: //idiot-proofing
			System.out.println("Input invalid");
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
