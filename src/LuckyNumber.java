import java.util.*;

public class LuckyNumber{
	public static void main(String[] args) {
		boolean playAgain = false;
		int totalGames = 0,temp=0, best = 0,count = 0;;
		Scanner console = new Scanner(System.in);

		do {
			temp = play(console);

			//total number of predictions
			count += temp;

			//least number of predictions
			if (totalGames == 0)
				best = count;
			if (temp < best)
				best = temp;
			
			//total number of games played
			totalGames++;

			//confirm whether to play again or not
			System.out.print("Do you want to play again? ");
			String YesNo = console.next();
			if (YesNo.equalsIgnoreCase("y") || YesNo.equalsIgnoreCase("yes")) {
				playAgain = true;
			} else {
				playAgain = false;
			}
			
			System.out.println();
		} while (playAgain);

		//show result
		report(totalGames, count, best);
	}
	

	// Ham play
	public static int play(Scanner console) {
		int numGuess = 0;
		int playerGuess = 0;
		Random rand = new Random();
		int luckyNumber = rand.nextInt(100) + 1;
		
		System.out.println("I'm thinking of a number between 0 and 100...");

		do {
			System.out.print("Your guess? ");
			playerGuess = console.nextInt();
			numGuess++;
			if (playerGuess < 0 || playerGuess > 100) {
				System.out.println("Please input a number betwen 0 and 100!");
			} else if (playerGuess < luckyNumber) {
				System.out.println("It's higher.");
			} else if (playerGuess > luckyNumber) {
				System.out.println("It's lower.");
			}
		} while (playerGuess != luckyNumber);
		System.out.println("You got it right in " + numGuess + " guesses!");
		return numGuess;

	}

	//report
	public static void report(int totalGames, int totalGuess, int best) {
		double guessAvg = (double) totalGuess / totalGames;

		System.out.println("Overall results:");
		System.out.println("Total games\t= " + totalGames);
		System.out.println("Total guesses\t= " + totalGuess);
		System.out.println("Guesses/game\t= " + guessAvg);
		System.out.println("Best Game\t= " + best);
	}

}
