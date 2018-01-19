package com.adventure.leet;

/*
 * https://leetcode.com/problems/divide-two-integers/
 * 
 * Divide two integers without using multiplication, division and mod. With or without bit operator. 

If it is overflow, return MAX_INT.
 */
public class DivideTwoIntegers {
	public static int divide(int dividend, int divisor) {
		// convert to long
		long dividend_long = dividend;
		long divisor_long = divisor;
		int sign = 1;
		
		if(dividend_long > 0 && divisor_long < 0 || dividend_long < 0 && divisor_long > 0 ) {
			sign = -1;
		}
		
		dividend_long = Math.abs(dividend_long);
		divisor_long = Math.abs(divisor_long);

		// edge cases
		if(divisor_long == 0) return Integer.MAX_VALUE;
		if(dividend_long == 0 || dividend_long < divisor_long) return 0;
		
		// recursion
		//long result = divide_long_no_bit_op(dividend_long, divisor_long);
		long result = divide_long_bit_op(dividend_long, divisor_long);
		
		if(result > Integer.MAX_VALUE) {
			if(sign == -1) {
				return Integer.MIN_VALUE;
			} else {
				return Integer.MAX_VALUE;
			}
		} else {
			 if(sign == -1) {
				 return (int)(0 - result); 
			 } else {
				 return (int) result;
			 }
		}
    }
	
	// This version uses no bit operation
	private static long divide_long_no_bit_op(long dividend, long divisor) {
		// base case
		if(dividend < divisor) return 0;
		
		// recursion (find the largest multiple so that divisor * multiple <= dividend
		// where the steps goes from 1, 2, 4, 8, 16, ... 2^k
		// think about binary search
		long sum = divisor;
		long multiple = 1;
		
		while((sum + sum) <= dividend) {  // same as: while((sum << 1) <= dividend)
			sum = sum + sum; // same as: sum = sum << 1;
			multiple = multiple + multiple; // same as: multiple = multiple << 1;
		}
		
		// add additional value from reminder
		return multiple + divide_long_no_bit_op(dividend - sum, divisor);
	}
	
	// This version uses bit operation
	private static long divide_long_bit_op(long dividend, long divisor) {
			// base case
			if(dividend < divisor) return 0;
			
			// recursion (find the largest multiple so that divisor * multiple <= dividend
			// where the steps goes from 1, 2, 4, 8, 16, ... 2^k
			// think about binary search
			long sum = divisor;
			long multiple = 1;
			
			while((sum << 1) <= dividend) {
				sum = sum << 1;
				multiple = multiple << 1;
			}
			
			// add additional value from reminder
			return multiple + divide_long_no_bit_op(dividend - sum, divisor);
	}
	
	
	// FAILED VERSION: this version takes two long when dividend = Integer.MAX_VALUE and divisor = 1
	private static long divide_long(long dividend, long divisor) {
		// corner cases
		if(divisor == 0) return Integer.MAX_VALUE;
		
		// REMEMBER that we can only use + and - operations
		// REMEMBER to use long in the calculations all the time
		
		// remember the sign
		boolean isNegative = dividend < 0 && divisor > 0 || dividend > 0 && divisor < 0;
		
		// un-sign them
		dividend = Math.abs(dividend);
		divisor = Math.abs(divisor);
		
		// more corner case
		if(dividend < divisor) return 0;
		
		// let's use addition and subtraction to solve the problem
		long sum = 0;
		long k = 0; 
		
		while(sum < dividend) {
			sum = sum + divisor;
			k = k + 1;
		}
		
        return k;
    }
}
