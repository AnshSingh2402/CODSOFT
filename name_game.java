import java.util.Random;
import java.util.Scanner;

public class GuessTheNumber {
    public static void main(String[] args) {
        System.out.println("Welcome to the Guess the Number game!");
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        boolean playAgain = true;
        int totalAttempts = 0;
        int roundsWon = 0;

        while (playAgain) {
            int lowerBound = 1;
            int upperBound = 100;
            int numberToGuess = random.nextInt(upperBound - lowerBound + 1) + lowerBound;
            int attempts = 0;

            System.out.println("I'm thinking of a number between " + lowerBound + " and " + upperBound + ".");

            while (true) {
                try {
                    System.out.print("Enter your guess: ");
                    int userGuess = scanner.nextInt();
                    attempts++;

                    if (userGuess < numberToGuess) {
                        System.out.println("Too low! Try again.");
                    } else if (userGuess > numberToGuess) {
                        System.out.println("Too high! Try again.");
                    } else {
                        System.out.println("Congratulations! You guessed the number " + numberToGuess + " in " + attempts + " attempts.");
                        totalAttempts += attempts;
                        roundsWon++;
                        break;
                    }
                } catch (java.util.InputMismatchException e) {
                    System.out.println("Please enter a valid number.");
                    scanner.next(); // Clear the input buffer
                }
            }

            System.out.print("Do you want to play again? (yes/no): ");
            String playAgainResponse = scanner.next().toLowerCase();
            playAgain = playAgainResponse.equals("yes");
        }

        if (roundsWon > 0) {
            double averageAttempts = (double) totalAttempts / roundsWon;
            System.out.println("You won " + roundsWon + " round(s) with an average of " + String.format("%.2f", averageAttempts) + " attempts per round.");
        } else {
            System.out.println("Thanks for playing!");
        }

        scanner.close();
    }
}
