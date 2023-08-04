import java.util.Scanner;

public class GuessNumber
{
	//Adding a method to determine the guess number with secret number
	public String determineGuess(int GuessNumber,int secretNumber,int count)
	{
		if(GuessNumber<0 || GuessNumber>100)
		{
			return "\n OOPS! Your guess is invalid!";
		} 
		else if(GuessNumber == secretNumber)
		{
			return "\nCorrect!! You won \nTotal Guesses: "+count;
		} 
		else if(GuessNumber<secretNumber)
		{
			return "\nYour guess is Too Low, try again.\nTry number: "+count;
		} 
		else if(GuessNumber>secretNumber)
		{
			return "\nYour guess is Too High, try again.\nTry number: "+count;
		} 
		else
		{
			return "\nYour guess is incorrect.\nTry number: "+count;
		}
	}
}
class GuessNumberTest
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int secretNumber = (int)(Math.random()*100)+1; //random number from 1 to 100 
		int GuessNumber=0;
		GuessNumber g1 = new GuessNumber();
		int count =1;
		while(GuessNumber!=secretNumber)
		{
		System.out.print("\nEnter your guess between 1 and 100: ");
		GuessNumber = sc.nextInt();
		String result = g1.determineGuess(GuessNumber, secretNumber, count);
		System.out.println(result);
		count++;
		}
	}
}