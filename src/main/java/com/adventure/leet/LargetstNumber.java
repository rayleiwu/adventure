package com.adventure.leet;

import java.util.Arrays;

/*
 * https://leetcode.com/problems/largest-number/
 * 
 *  Given a list of non negative integers, arrange them such that they form the largest number.
	For example, given [3, 30, 34, 5, 9], the largest formed number is 9534330.
	Note: The result may be very large, so you need to return a string instead of an integer.
 */
public class LargetstNumber {
	public static String largestNumber(int[] num) {
		
		// convert int[] to String[]
		String[] array = Arrays.stream(num).mapToObj(String::valueOf).toArray(String[]::new);
		
		// KEY LOGIC HERE!!!
		// Sort with custom sort method (String s1, String s2) -> (s2 + s1).compareTo(s1 + s2)
		Arrays.sort(array, (String s1, String s2) -> (s2 + s1).compareTo(s1 + s2));
		
		// Now, we can simply concatenate all the strings to get the result
		return Arrays.stream(array).reduce((x, y) -> x.equals("0") ? y : x + y).get();
				
	}
}
