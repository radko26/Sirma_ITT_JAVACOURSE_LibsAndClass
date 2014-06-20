package com.sirma.itt.javacourse.lib.wordgen;

/**
 * A static method for Random numbers
 * 
 * @author Radoslav
 */
public class Random {
	/**
	 * 
	 * @param lowerBound
	 *            is the lower Bound
	 * @param upperBound
	 *            is the Upper Bound
	 * @return our random number between @param lb and @param ub
	 */
	public static int getRand(int lowerBound, int upperBound) {
		java.util.Random rand = new java.util.Random();
		return rand.nextInt(upperBound - lowerBound + 1) + lowerBound;

	}
}
