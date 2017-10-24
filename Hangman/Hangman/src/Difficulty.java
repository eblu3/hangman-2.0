import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

class Difficulty
{
	private ArrayList<String> easy;
	private ArrayList<String> medium;
	private ArrayList<String> hard;
	private String level;
	
	/**
	 * sets difficulty to level defined by choice
	 * @param choice
	 * @throws FileNotFoundException
	 */
	public Difficulty(String choice) throws FileNotFoundException {
		level = choice;
		Scanner scan;
		switch (choice.toLowerCase()) {
			case "easy": //setting word bank to easy words
				scan = new Scanner(new File("Easy.dat"));
				easy = new ArrayList<>();
				while (scan.hasNextLine()) //Calling Easy file, filling it into the array
				{
					String str = scan.nextLine();
					easy.add(str);
				}
				break;

			case "medium": //setting word bank to medium words
				scan = new Scanner(new File("Medium.dat"));
				medium = new ArrayList<>();
				while (scan.hasNextLine()) //Calling Medium file, filling it into the array
				{
					String str = scan.nextLine();
					medium.add(str);
				}
				break;

			case "hard": //setting word bank to hard words
				scan = new Scanner(new File("Hard.dat"));
				hard = new ArrayList<>();
				while (scan.hasNextLine())  //Calling Hard file, filling it into the array
				{
					String str = scan.nextLine();
					hard.add(str);
				}
				break;

			default: //idiot-proofing
				System.out.println("Input invalid");
		}
	}
	
	/**
	 * generates a random phrase from the .dat file of a chosen difficulty defined in the constructor
	 * @return a String containing a random phrase
	 */
	public String getPhrase()
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