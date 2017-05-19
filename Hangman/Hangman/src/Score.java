public class Score
{
	private int points, misses, correct;
	
	public Score()
	{
		points = 0;
		misses = 0;
		correct = 0;
	}
	
	public String getPoints()
	{
		points =  (getCorrect() * 100) - (getMisses() * 50);
		return points + "";
	}
	
	public int getMisses()
	{
		return misses;
	}
	
	public int getCorrect()
	{
		return correct;
	}
	
	public void setCorrect()
	{
		correct += 1;
	}
	
	public void setMisses()
	{
		misses += 1;
	}
	
}