package com.sirma.itt.javacourse.lib.bigint;

/**
 * Own implementation of summing two big numbers
 * 
 * @author Radoslav
 */

public class Main {
	public static void main(String[] args) {
		BigInt b = new BigInt();
		System.out.println(b.calculate("101", "99"));
	}
}