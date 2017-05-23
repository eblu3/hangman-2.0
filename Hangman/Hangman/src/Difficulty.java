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
		switch(choice.toLowerCase())
		{
		case "easy": //setting word bank to easy words
			scan = new Scanner(new File("Easy.dat"));
			easy = new ArrayList<String>();
			while(scan.hasNextLine()) //Calling Easy file, filling it into the array
			{
				String str = scan.nextLine();
				easy.add(str);
			}
			break;
			
		case "medium": //setting word bank to medium words
			scan = new Scanner(new File("Medium.dat"));
			medium = new ArrayList<String>();
			while(scan.hasNextLine()) //Calling Medium file, filling it into the array
			{
				String str = scan.nextLine();
				medium.add(str);
			}
			break;
			
		case "hard": //setting word bank to hard words
			scan = new Scanner(new File("Hard.dat"));
			hard = new ArrayList<String>();
			while(scan.hasNextLine())  //Calling Hard file, filling it into the array
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
		int phrase = (int)(Math.random() * 79);
		
		if(level.equals("easy"))
			return easy.get(phrase);
		if(level.equals("medium"))
			return medium.get(phrase);
		else
			return hard.get(phrase);
	}
}