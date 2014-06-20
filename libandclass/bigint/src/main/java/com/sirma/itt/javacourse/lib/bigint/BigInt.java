package com.sirma.itt.javacourse.lib.bigint;

/**
 * BigInteger own implementation, the numbers are represented as strings.
 * 
 * @author radoslav
 */

public class BigInt {

	private static char[] first = new char[10000000];
	private static char[] second = new char[1000000];
	private static char[] sum = new char[10000001];

	public BigInt() {

	}

	/**
	 * Method which calcultes the sum digit by digit
	 * 
	 * @param firstNumber
	 * @param secondNumber
	 * @return
	 */
	public String calculate(String firstNumber, String secondNumber) {

		first = firstNumber.toCharArray();
		second = secondNumber.toCharArray();

		int sizeFisrtNumber = first.length;
		int sizeSecondNumber = second.length;
		int sizeSum = sizeFisrtNumber > sizeSecondNumber ? sizeFisrtNumber
				: sizeSecondNumber;

		boolean above10 = false;
		int value = 0;
		for (int firstNumberIndex = sizeFisrtNumber - 1, secondNumberIndex = sizeSecondNumber - 1, sumIndex = sizeSum; sumIndex > -1; firstNumberIndex--, secondNumberIndex--, sumIndex--) {
			if (above10) {
				value = 1;
			} else {
				value = 0;
			}

			// if there are digits to be added from the second number
			if (firstNumberIndex < 0 && secondNumberIndex >= 0) {
				value = value + (second[secondNumberIndex] - '0');
			}
			// no digits left in the second but we add some from the first
			// number
			if (secondNumberIndex < 0 && firstNumberIndex >= 0) {
				value = value + (first[firstNumberIndex] - '0');
			}
			// both numbers have digits
			if (secondNumberIndex >= 0 && firstNumberIndex >= 0) {
				value = value + (first[firstNumberIndex] - '0')
						+ (second[secondNumberIndex] - '0');
			}
			if (value >= 10) {
				above10 = true;
				value = value - 10;
			} else {
				above10 = false;
			}
			sum[sumIndex] = (char) (value + '0');
		}

		String output = new String("");
		if (sum[0] != '0') {// only checking if we need to
							// add new digit to the sum
			output += sum[0];
		}
		for (int i = 1; i <= sizeSum; i++) {
			output += sum[i];
		}

		return output;
	}
}
