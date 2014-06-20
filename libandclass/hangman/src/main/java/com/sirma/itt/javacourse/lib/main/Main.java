package com.sirma.itt.javacourse.lib.main;

import java.io.IOException;

import com.sirma.itt.javacourse.lib.wordgen.GenInfo;
import com.sirma.itt.javacourse.lib.wordgen.Random;
import com.sirma.itt.javacourse.lib.wordgen.RandomWordGenerator;

/**
 * Hangman main class.
 * 
 * @author Radoslav
 */

public class Main {

	private static char guess;
	private static RandomWordGenerator wordGen;
	private static int len;
	private static int tries;
	private static String word;
	private static int correctGuesses;
	private static boolean[] guessesResult;

	/**
	 * give all variables a initialization value
	 */
	private static void init() {
		guess = 0;
		tries = 10;
		len = Random.getRand(4, 8);
		correctGuesses = 0;
		wordGen = new RandomWordGenerator(len);
		wordGen.generate();
		word = wordGen.getWord();
		guessesResult = new boolean[word.length()];

	}

	/**
	 * 
	 * @param guess
	 *            the char guess which was given
	 * @return
	 */
	private static boolean checkGuess(char guess) {
		boolean result = false;
		for (int i = 0; i < word.length(); i++) {
			if (word.charAt(i) == guess && guessesResult[i] != true) {
				guessesResult[i] = true;
				result = true;
			}
		}
		return result;
	}

	/**
	 * method for printing the given result
	 */
	private static void printHangman() {
		for (int i = 0; i < word.length(); i++) {
			if (guessesResult[i]) {
				System.out.print(word.charAt(i));
			} else {
				System.out.print(" _ ");
			}
		}
	}

	/**
	 * 
	 * @param args
	 * @throws IOException
	 *             input from the keyboard
	 */
	public static void main(String[] args) throws IOException {
		init();

		System.out.println("Your word contains: " + len + " symbols. ");
		System.out.println(GenInfo.getBigLetterCount() + " UpperCase letters, "
				+ GenInfo.getSmallLetterCount() + " LowerCase letters, "
				+ GenInfo.getNumberCount() + " digits");
		System.out.println("\nYou have " + tries + " tries to guess it.");
		System.out.println("");

		while (true) {
			printHangman();
			System.out.println("");

			System.out.println("Insert your guess: ");

			do {
				guess = (char) System.in.read();
			} while (guess == '\n' | guess == '\r');

			if (!checkGuess(guess)) {
				tries--;
				System.out.print("Wrong guess \n");
			} else {
				correctGuesses++;
				System.out.print("Yuppy " + (word.length() - correctGuesses)
						+ " more \n");
			}
			if (correctGuesses == word.length()) {
				System.out.print("You win \n");
				break;
			}
			if (tries == 0) {
				System.out.print("You loose\n");
				System.out.print("The word was " + word + "\n");
				break;
			}
		}
	}

}
