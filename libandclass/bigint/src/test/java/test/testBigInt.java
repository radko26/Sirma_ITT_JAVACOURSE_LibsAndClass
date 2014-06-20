package test;

import static org.junit.Assert.*;

import java.math.BigInteger;

import org.junit.Before;
import org.junit.Test;

import com.sirma.itt.javacourse.lib.bigint.BigInt;

/**
 * BigInteger JUnit test
 * 
 * @author radoslav
 */
public class testBigInt {

	BigInteger firstNumber;
	BigInteger secondNumber;
	BigInteger sum;
	String[] nums;
	BigInt b;

	@Before
	/**
	 * Setting up the variables
	 */
	public void initialize() {
		nums = new String[2];
		b = new BigInt();
	}

	@Test
	/**
	 * Generate two random numbers 
	 * then pass them to our calculate method
	 * and then compare the given output with the build in Java Math.BigInteger class.
	 */
	public void testSumWithLargeData() {
		for (int i = 0; i < 800000; i++) {
			nums[0] = Integer.toString((int) (Math.random() * 999999990));
			nums[1] = Integer.toString((int) (Math.random() * 999999990) + 100);
			firstNumber = new BigInteger(nums[0]);
			secondNumber = new BigInteger(nums[1]);
			sum = new BigInteger("0");
			sum = sum.add(firstNumber);
			sum = sum.add(secondNumber);
			assertEquals(b.calculate(nums[0], nums[1]), sum.toString());
		}

	}

}
