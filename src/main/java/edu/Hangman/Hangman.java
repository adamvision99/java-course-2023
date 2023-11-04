package edu.Hangman;

import java.util.Random;
import java.util.Scanner;

public class Hangman {
    private static final String[] WORDS = {"hello", "world", "java", "hangman"};
    private static final int MAX_MISTAKES = 5;

    private static String wordToGuess = "";

    private static char[] guessedWord;

    private static int mistakes;
    private static String guessedLetters;

    private static Scanner scanner;

    public static void main(String[] args) {
        createWord();

        startGame();

        boolean result = guessResult();

        if (!result) {
            System.out.println("You lost! The word was: " + wordToGuess);
        }
    }

    private static void createWord(){
        Random random = new Random();
        wordToGuess = WORDS[random.nextInt(WORDS.length)];
        guessedWord = new char[wordToGuess.length()];
        for (int i = 0; i < wordToGuess.length(); i++) {
            guessedWord[i] = '*';
        }

    }

    public static void startGame(){
        mistakes = 0;
        guessedLetters = "";
        System.out.println("Welcome to Hangman!");
        scanner = new Scanner(System.in);
    }

    private static boolean guessResult(){
        while (mistakes < MAX_MISTAKES) {
            System.out.println("Guess a letter:");
            char guess = scanner.next().charAt(0);

            if (guessedLetters.contains(String.valueOf(guess))) {
                System.out.println("You've already guessed that letter.");
                continue;
            }
            guessedLetters += guess;

            if (wordToGuess.contains(String.valueOf(guess))) {
                System.out.println("Hit!");
                for (int i = 0; i < wordToGuess.length(); i++) {
                    if (wordToGuess.charAt(i) == guess) {
                        guessedWord[i] = guess;
                    }
                }
            } else {
                System.out.println("Missed, mistake " + (mistakes + 1) + " out of " + MAX_MISTAKES);
                mistakes++;
            }

            System.out.println("The word: " + new String(guessedWord));
            if (new String(guessedWord).equals(wordToGuess)) {
                System.out.println("You won!");
                return true;
            }
        }
        return false;
    }
}
