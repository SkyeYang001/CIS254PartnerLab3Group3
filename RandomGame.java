package Homework.Week10;

import java.util.Scanner;
import java.util.Random;

/**
 * Lab 3: This program let's the user play 2 games involving random numbers.
 * 
 * @author Peter Gian-Paolo Despues
 * @author Skye Yang
 */

public class RandomGame {

    /**
     * Description: This is a guessing game where the user inputs a number between
     * 1-50, their number is correct if it is equal to the random number.
     * 
     * @author Skye Yang
     * @param input
     */

    public static void GuessingGame(Scanner input) {
        Random random = new Random();
        int guessLength = 50;
        int roundLength = 5;

        System.out.printf("I'm thinking of a number between 1 to %d.\n", guessLength);
        int number = random.nextInt(guessLength);
        // System.out.println(number);
        System.out.print("Guess what it is. You have 5 tries: ");
        int guess = 0;
        for (int rounds = roundLength; rounds > 0; rounds--) {
            guess = input.nextInt();
            if (guess == number) {
                System.out.println("You got it!");
                break;
            }
            if (rounds != 1) {
                if (guess > number) {
                    System.out.print("Nope! Too high. ");
                } else {
                    System.out.print("Nope! Too low. ");
                }
                System.out.printf("Try again (%d try left): ", rounds - 1);
            } else {
                System.out.printf("Nope! You lost. The number was %d. \n", number);
            }
        }
    }

    /**
     * Description: Player chooses from 3 options: 1.paper, 2.scissors 3.rock
     * and plays agaisnt the computer
     * 
     * @author Peter
     * @param input
     */
    public static void RockPaperScissors(Scanner input) {
        Random random = new Random();
        System.out.print("Enter your choice: 1. paper, 2. scissors, 3. rock: ");
        int playerChoice = input.nextInt();

        int computerChoice = random.nextInt(3) + 1; // random 1–3

        if (playerChoice == computerChoice) {
            System.out.println("It is a tie!");
        } else if ((playerChoice == 1 && computerChoice == 3) ||
                (playerChoice == 2 && computerChoice == 1) ||
                (playerChoice == 3 && computerChoice == 2)) {
            System.out.println("You win!");
        } else {
            System.out.println("Computer wins!");
        }
    }

    /**
     * Description: This the menu for the user to pick which game to play
     * 
     * @param input
     * @return the value the user choose
     */

    public static int menu(Scanner input) {
        int value = 0;
        while (value < 1 || value > 2) {
            System.out.println("1. Guessing Game.");
            System.out.println("2. Rock Paper Scissors.");
            System.out.println("Pick a game to play.");
            if (!input.hasNextInt()) {
                String word = input.next();
                System.err.println(word + " is not a number");
                value = 0;
            } else {
                value = input.nextInt();
            }
        }
        return value;
    }

    /**
     * Description: This is the main method which calls the other methods.
     */

    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        String answer;
        do {
            int game = menu(input);
            if (game == 1) {
                GuessingGame(input);
            } else if (game == 2) {
                RockPaperScissors(input);
            }
            System.out.print("Do you want to play again? (Y/N): ");
            answer = input.next();
        } while (answer.equalsIgnoreCase("Y"));
        System.out.println("Thank you so much for playing our games!");
        input.close();
    }
}
