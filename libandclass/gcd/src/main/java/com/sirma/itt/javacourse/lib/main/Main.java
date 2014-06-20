package com.sirma.itt.javacourse.lib.main;

import java.util.Scanner;

/**
 * GCD and LIM methods
 * 
 * @author Radoslav
 */

public class Main {

	private static Scanner bufferScan;
	private static int a;
	private static int b;
	private static int gcd;

	// recursive gcd function
	private static int gcd(int a, int b) {
		if (b == 0)
			return a;
		return gcd(b, a % b);
	}

	/**
	 * 
	 * @param a
	 *            a number
	 * @param b
	 *            the other number
	 * @param gcd
	 *            gcd value
	 * @return the solution
	 */
	private static int lim(int a, int b, int gcd) {
		return a * b / gcd;
	}

	/**
	 * initializing all the used variables a,b our numbers bufferScan - a
	 * scanner for input from keyboard gcd - a variable where we keep our
	 * solution
	 */
	private static void init() {
		a = b = 0;
		bufferScan = new Scanner(System.in);
		gcd = 1;
	}

	/**
	 * main method
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		// initialize variables
		init();

		try {
			a = bufferScan.nextInt();
			b = bufferScan.nextInt();
		} catch (Exception e) {
			e.printStackTrace();
		}

		// solution to gcd
		gcd = gcd(a, b);
		/**
		 * print answers to screen
		 */
		System.out.println(gcd);
		System.out.println(lim(a, b, gcd));
	}

}
