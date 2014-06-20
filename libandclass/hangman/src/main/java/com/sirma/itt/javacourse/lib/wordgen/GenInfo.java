package com.sirma.itt.javacourse.lib.wordgen;

/**
 * A static class for saving some hints about the generated word
 * 
 * 
 * @author Radoslav
 */

public class GenInfo {
	private static int NumberCount;
	private static int SmallLetterCount;
	private static int BigLetterCount;

	/**
	 * Initialization method which give primary values
	 */
	public void init() {
		NumberCount = 0;
		SmallLetterCount = 0;
		BigLetterCount = 0;
	}

	/**
	 * 
	 * 
	 * @return the count of digits/small letters and capital letters
	 */
	public static int getNumberCount() {
		return NumberCount;
	}

	public static int getSmallLetterCount() {
		return SmallLetterCount;
	}

	public static int getBigLetterCount() {
		return BigLetterCount;
	}

	public static void setNumberCount() {
		NumberCount++;
	}

	public static void setSmallLetterCount() {
		SmallLetterCount++;
	}

	public static void setBigLetterCount() {
		BigLetterCount++;
	}

}
