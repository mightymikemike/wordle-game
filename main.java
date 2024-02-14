import java.util.Random;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    // This is the array of 5-letter words
    String[] guesses = {"three", "seven", "eight", "couch", "doors", "water", "steam", "codes"};

    // We'll make the word chosen random
    Random random = new Random();
    String wordGoal = guesses[random.nextInt(guesses.length)];

    // Number of attempts for the game
    int maxGuesses = 5;

    // Zero attempts made since the game hasn't started yet
    int playerGuesses = 0;

    // Scanner for user inputs
    Scanner scanner = new Scanner(System.in);

    // Introduction to the game
    System.out.println("Welcome to the word guessing game. Here are the rules.");
    System.out.println("You will have 5 attempts to guess the 5-letter word");
    System.out.println("As you guess, I will tell you if the letters are correct and/or in the right position");
    System.out.println("Good luck!");
    
    // Let the game begin!
    while (playerGuesses < maxGuesses) {
      System.out.print("Please enter your 5-letter guess!: ");
      String playerGuess = scanner.nextLine().toLowerCase();

      // Now we'll check if the guess is valid
      if (playerGuess.length() > 5 || playerGuess.length() < 5) {
        System.out.println("This isn't a 5-letter word!!! Try again please!");
        continue; 
      }
    
      // Now we'll check if the guess is correct
      if (playerGuess.equals(wordGoal)) {
        System.out.println("Good job! You guessed: " + wordGoal);
        break;
      } else {
        // This is where we tell users if their words are correct
        System.out.println("That is incorrect " + provideFeedback(wordGoal, playerGuess));
        playerGuesses++;
        System.out.println("You have " + (maxGuesses - playerGuesses) + " guesses remaining.");
      }
    }

    // Give up the answer if the player fails to guess correctly
    if (playerGuesses == maxGuesses) {
      System.out.println("You've run out of guesses. The correct word is: " + wordGoal);
    }

    scanner.close();    
  }

  // Tell users what letters are correct
  private static String provideFeedback(String wordGoal, String playerGuess) {
    StringBuilder feedback = new StringBuilder();
    for (int i=0; i < 5; i++) {
      char goalChar = wordGoal.charAt(i);
      char guessChar = playerGuess.charAt(i);
      if (goalChar == guessChar) {
        // Correct guess
        feedback.append('O');
        // Good guess, wrong position
      } else if (wordGoal.contains(String.valueOf(guessChar))) {
        feedback.append('X');
        // Incorrect guess
      } else {
        feedback.append('-');
      }
    }
    return feedback.toString();
  }
}
