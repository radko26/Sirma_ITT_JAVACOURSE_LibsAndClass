package com.sirma.itt.javacourse.lib.main;

import java.util.Scanner;

/**
 * GCD and LIM methods
 * 
 * @author Radoslav
 */

public class Main {

	private static Scanner bufferScan;
	private static int firstNumber;
	private static int secondNumber;
	private static int gcd;

	// recursive gcd function
	private static int gcd(int firstNumber, int secondNumber) {
		if (secondNumber == 0)
			return firstNumber;
		return gcd(secondNumber, firstNumber % secondNumber);
	}

	/**
	 * 
	 * @param firstNumber
	 *            firstNumber number
	 * @param secondNumber
	 *            the other number
	 * @param gcd
	 *            gcd value
	 * @return the solution
	 */
	private static int lim(int firstNumber, int secondNumber, int gcd) {
		return firstNumber * secondNumber / gcd;
	}

	/**
	 * initializing all variables
	 */
	private static void init() {
		firstNumber = secondNumber = 0;
		bufferScan = new Scanner(System.in);
		gcd = 1;
	}

	/**
	 * Main method to run the programme.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		init();
		try {
			firstNumber = bufferScan.nextInt();
			secondNumber = bufferScan.nextInt();
		} catch (Exception e) {
			e.printStackTrace();
		}
		// solution to gcd
		gcd = gcd(firstNumber, secondNumber);
		System.out.println(gcd);
		System.out.println(lim(firstNumber, secondNumber, gcd));
	}
}
