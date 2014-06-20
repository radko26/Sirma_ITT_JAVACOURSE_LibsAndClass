package com.sirma.itt.javacourse.lib.arrayutils.arraymanipulator;

/**
 * Do some tasks related to array manipulations
 * 
 * @author Radoslav
 * 
 */

public class Manipulator {
	private int array[];

	/**
	 * Constructor
	 * 
	 * @param array
	 *            Pass the array from the main class to this one
	 */
	public Manipulator(int[] array) {
		this.array = array;
	}

	/**
	 * 
	 * @return the sum of all elements in the array
	 */
	public int getSum() {
		int sum = 0;
		for (int i = 0; i < array.length; i++) {
			sum += array[i];
		}
		return sum;
	}

	/**
	 * Methods for finding the minimum/maximum of 2 numbers
	 * 
	 * @param a
	 * @param b
	 *            a is the first number and b is the second one
	 * @return the minimum value from both
	 */
	private int min(int a, int b) {
		return a < b ? a : b;
	}

	/**
	 * 
	 * @param a
	 * @param b
	 * @return maximum
	 */
	private int max(int a, int b) {
		return a > b ? a : b;
	}

	/**
	 * Method for getting the minimum element
	 * 
	 * @return the minimum element from the whole array
	 */
	public int getMinElement() {
		int minElement = array[0];
		for (int i = 1; i < array.length; i++) {
			minElement = min(minElement, array[i]);
		}
		return minElement;
	}

	/**
	 * Method for printing the whole array. We iterate each element and print
	 * it.
	 * 
	 */
	public void printArray() {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println("");
	}

	/**
	 * Method which reverse the content of the array, choosing the beginning as
	 * left and the end as right we swap each element with the indexes above and
	 * then lower the bounds of that part of the array we need to reorder, we
	 * stop when the bounds cross.
	 * 
	 */
	public void reverse() {
		int left = 0;
		int right = array.length - 1;
		while (left < right) {
			int temp = array[left];
			array[left] = array[right];
			array[right] = temp;
			left++;
			right--;
		}
	}

	/**
	 * Method for choosing the pivot point, in other words, choosing the element
	 * which we use to reorder the array in such way that all other greater
	 * elements are after it and each one with less value before
	 * 
	 * @param left
	 *            count the elements which are less than the pivot
	 * @param right
	 *            count the elements which are greater than the pivot
	 * 
	 * @return the "pivot" index
	 * 
	 */

	private int choosePivotPoint(int left, int right) {
		int pivot = array[left + (right - left) / 2];
		int temp;

		while (left < right) {
			while (array[left] < pivot) {
				left++;
			}
			while (array[right] > pivot) {
				right--;
			}
			if (left <= right) {
				temp = array[left];
				array[left] = array[right];
				array[right] = temp;
			}
		}
		return left;
	}

	/**
	 * Method which we use for recursively choose a pivot/swap and in fact sort
	 * the array
	 * 
	 * @param left
	 *            the begin index
	 * @param right
	 *            the end of the array Using the parameters you sort from index
	 *            left to index right;
	 */
	public void qsort(int left, int right) {
		if (left >= right) {
			return;
		}
		int pivot = choosePivotPoint(left, right);
		qsort(left, pivot);
		qsort(pivot + 1, right);
	}

	/**
	 * Method for finding the median weight of array, in other words we choose
	 * an element and the sum of all others from both sides (left/right) should
	 * have as little difference in the sums as possible
	 * 
	 * We use some dp technique to store the sum from index I to index J and use
	 * it for fast answering, otherwise a naive way would be to try all
	 * possibilities and would result in n^2
	 * 
	 */
	public void mWeight() {
		int size = array.length;
		int Sums[] = new int[size];
		Sums[0] = array[0];
		for (int i = 1; i < size; i++) {
			Sums[i] += Sums[i - 1] + array[i];
		}
		int min = 0;
		int minIndex = 0;
		if (size >= 3)
			for (int i = 1; i < size; i++) {
				int greaterNumber = max(Sums[i - 1], Sums[size - 1] - Sums[i]);
				int lessNumber = min(Sums[i - 1], Sums[size - 1] - Sums[i]);
				if (greaterNumber - lessNumber < min || i == 1) {
					min = greaterNumber - lessNumber;
					minIndex = i;
				}

			}
		else {
			System.out.println("Not enough elements");
		}
		System.out.println("Pos " + minIndex + " Element:" + array[minIndex]);
	}
}
