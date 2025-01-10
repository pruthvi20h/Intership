import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    public static void main(String[] args) {
        Random random = new Random();
        Scanner sc = new Scanner(System.in);

        int randomNumber = random.nextInt(100) + 1; // Generate a random number between 1 and 100
        int attempts = 5; // Limit the number of attempts
        boolean hasWon = false;

        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("I have chosen a number between 1 and 100.");
        System.out.println("You have " + attempts + " attempts to guess it.");

        for (int i = 1; i <= attempts; i++) {
            System.out.print("Attempt " + i + ": Enter your guess: ");
            
            if (!sc.hasNextInt()) { // Handle invalid inputs
                System.out.println("Invalid input! Please enter a valid number.");
                sc.next(); // Consume the invalid input
                continue;
            }
            
            int guess = sc.nextInt();

            if (guess < 1 || guess > 100) { // Ensure the guess is within range
                System.out.println("Please guess a number between 1 and 100.");
                continue;
            }

            if (guess == randomNumber) {
                hasWon = true;
                System.out.println("Congratulations! You guessed the number correctly.");
                break;
            } else if (guess < randomNumber) {
                System.out.println("Too low!");
            } else {
                System.out.println("Too high!");
            }
        }

        if (!hasWon) {
            System.out.println("Sorry, you've run out of attempts. The number was: " + randomNumber);
        }

        sc.close();
        System.out.println("Thanks for playing!");
    }
}