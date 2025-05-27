import java.util.Random;
import java.util.Scanner;

public class GuessTheNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        final int MAX_ATTEMPTS = 10;
        final int LOWER_BOUND = 1;
        final int UPPER_BOUND = 100;

        int roundsPlayed = 0;
        int roundsWon = 0;
        boolean playAgain = true;

        System.out.println("Welcome to the Guess the Number Game!");

        while (playAgain) {
            int secretNumber = random.nextInt(UPPER_BOUND - LOWER_BOUND + 1) + LOWER_BOUND;
            int attemptsLeft = MAX_ATTEMPTS;
            boolean guessedCorrectly = false;

            System.out.println("\nRound " + (roundsPlayed + 1) + " begins!");
            System.out.println("I'm thinking of a number between " + LOWER_BOUND + " and " + UPPER_BOUND + ".");
            System.out.println("You have " + MAX_ATTEMPTS + " attempts to guess it.");

            while (attemptsLeft > 0) {
                System.out.print("Enter your guess: ");
                int guess;
                try {
                    guess = Integer.parseInt(scanner.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter an integer.");
                    continue;
                }

                if (guess < LOWER_BOUND || guess > UPPER_BOUND) {
                    System.out.println("Your guess is out of range!");
                    continue;
                }

                attemptsLeft--;

                if (guess == secretNumber) {
                    System.out.println("hurray :) You guessed it right.");
                    guessedCorrectly = true;
                    roundsWon++;
                    break;
                } else if (guess < secretNumber) {
                    System.out.println("Too low!");
                } else {
                    System.out.println("Too high!");
                }

                System.out.println("Attempts left: " + attemptsLeft);
            }

            if (!guessedCorrectly) {
                System.out.println(" You've used all attempts. The correct number was: " + secretNumber);
            }

            roundsPlayed++;
            System.out.print("Do you want to play another round? (yes/no): ");
            String response = scanner.nextLine().trim().toLowerCase();
            playAgain = response.equals("yes") || response.equals("y");
        }

        System.out.println("\nThanks for playing!");
        System.out.println("Rounds played: " + roundsPlayed);
        System.out.println("Rounds won: " + roundsWon);
        scanner.close();
        
    }
}
