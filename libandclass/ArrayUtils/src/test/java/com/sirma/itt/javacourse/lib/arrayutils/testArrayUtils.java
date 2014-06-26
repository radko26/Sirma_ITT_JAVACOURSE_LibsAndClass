package com.sirma.itt.javacourse.lib.arrayutils;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

import com.sirma.itt.javacourse.lib.arrayutils.arraymanipulator.Manipulator;

/**
 * JUnit test for arrayUtils search method
 * 
 * @author radoslav
 */

public class testArrayUtils {

	private static final int testCases = 12000;
	private int testArray[];
	private int array[];
	Manipulator tester;

	@Test
	/**
	 * Inserts random numbers and then sort them.
	 * Compares the result with the build in sort in Java.
	 */
	public void testSort() {

		for (int testNum = 0; testNum < testCases; testNum++) {
			array = new int[(int) (Math.random() * 10000 + 10)];
			for (int i = 0; i < array.length; i++) {
				array[i] = (int) (Math.random() * (-256) + 1265);
			}
			testArray = array;

			tester = new Manipulator(testArray);
			tester.qsort(0, testArray.length - 1);
			Arrays.sort(array);
			assertArrayEquals(testArray, array);
		}
	}

}
