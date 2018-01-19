package com.adventure.leet.easy;

/*
 * https://leetcode.com/problems/plus-one/
 * 
 * Given a non-negative number represented as an array of digits, plus one to the number.

The digits are stored such that the most significant digit is at the head of the list.
 * 
 */
public class PlusOne {
	 public static int[] plusOne(int[] digits) {
	      
		 // validate input 
		 if(digits == null || digits.length == 0) return digits;
		 
		 if(digits[digits.length - 1] < 9) {
			 digits[digits.length - 1]++;
			 return digits;
		 }
		 
		 // define array to store result
		 int[] result = new int[digits.length + 1];
		 
		 // iterate from end to start
		 int carry = 1;
		 
		 for(int i=digits.length - 1; i >= 0; i--) {
			 int n = digits[i] + carry;
			 result[i+1]
					 = digits[i]
					 = n % 10;
			 
			 carry = n / 10;
		 }
		 
	     result[0] = carry;

		 // return result
	     if(carry == 0) {
	    	 return digits;
	     } else {
			 return result;
	     }
	 }
}
