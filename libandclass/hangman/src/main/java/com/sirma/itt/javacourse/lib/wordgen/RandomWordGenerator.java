package com.sirma.itt.javacourse.lib.wordgen;

/**
 * A class in which we generate via @link Random class a semi-random word
 * 
 * @author Radoslav
 */
public class RandomWordGenerator {

	private int len;
	private StringBuilder word;

	public RandomWordGenerator(int len) {
		this.len = len;
		word = new StringBuilder();
	}

	/**
	 * 
	 * @return a letter(capital,or lowercase) or a digit
	 */
	private char genNumber() {
		return (char) Random.getRand(48, 57);
	}

	private char genSmallLetter() {
		return (char) Random.getRand(97, 122);
	}

	private char genBigLetter() {
		return (char) Random.getRand(65, 90);
	}

	// choosing what to insert into the newly created word
	private int genChoice() {
		return Random.getRand(1, 3);
	}

	/**
	 * Building our word via choosing in a random way to insert a digit or
	 * letter
	 */
	public void generate() {
		for (int i = 0; i < len; i++) {
			int choice = genChoice();
			if (choice == 1) {
				word.append(genNumber());
				// System.out.println(word.toString());
				GenInfo.setNumberCount();
			}
			if (choice == 2) {
				word.append(genSmallLetter());
				// System.out.println(word.toString());
				GenInfo.setSmallLetterCount();
			}
			if (choice == 3) {
				word.append(genBigLetter());
				// System.out.println(word.toString());
				GenInfo.setBigLetterCount();
			}
		}
	}

	public void printWord() {
		System.out.println(word.toString());
	}

	public String getWord() {
		return word.toString();
	}

}
