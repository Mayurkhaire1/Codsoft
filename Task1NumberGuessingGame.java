
import java.util.Random;
import java.util.Scanner;

public class Task1NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Welcome to the Number Guessing Game!");

        int score = 0;
        boolean playAgain = true;

        while (playAgain) {
            int targetNumber = random.nextInt(100) + 1;
            int attempts = 0;
            int maxAttempts = 5;

            System.out.println("I have selected a number between 1 and 100. Can you guess it?");

            while (attempts < maxAttempts) {
                System.out.print("Enter your guess: ");

                // Validate if the input is an integer
                while (!scanner.hasNextInt()) {
                    System.out.println("Invalid input! Please enter a valid integer.");
                    scanner.next(); // Consume invalid input
                }
                int userGuess = scanner.nextInt();
                scanner.nextLine(); // Consume newline character after nextInt()

                attempts++;

                if (userGuess == targetNumber) {
                    System.out.println("Congratulations! You guessed the number " + targetNumber + " in " + attempts + " attempts.");
                    score++;
                    break;
                } else if (userGuess < targetNumber) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }
            }

            if (attempts >= maxAttempts) {
                System.out.println("Sorry, you've run out of attempts. The correct number was " + targetNumber + ".");
            }

            System.out.print("Do you want to play again? (yes/no): ");
            String playAgainInput = scanner.nextLine().toLowerCase(); // Convert input to lowercase
            playAgain = playAgainInput.equals("yes") || playAgainInput.equals("y");
        }

        System.out.println("Game over! Your score: " + score);

        scanner.close();
    }
}
