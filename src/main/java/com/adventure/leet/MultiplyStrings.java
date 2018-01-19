package com.adventure.leet;

/*
 * https://leetcode.com/problems/multiply-strings/
 * 
 * Solution: https://leetcode.com/discuss/71593/easiest-java-solution-with-graph-explanation
 * 
 * Given two numbers represented as strings, return multiplication of the numbers as a string.

Note: The numbers can be arbitrarily large and are non-negative.
 * 
 */
public class MultiplyStrings {
	 public static String multiply(String num1, String num2) {
	     
		 int[] calc = new int[num1.length() + num2.length()];
		 
		 for(int i=num1.length() - 1; i >=0; i--) {
			 for(int j=num2.length() - 1; j>=0; j--) {
				 int temp = calc[i+j+1] + (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
				 calc[i+j+1] = temp % 10;
				 calc[i+j] += temp / 10;
			 }
		 }
		 
		 StringBuilder sb = new StringBuilder();
		 
		 for(int n : calc) {
			 if(sb.length() > 0 || n != 0) {
				 sb.append(n);
			 }
		 }
		 
		 if(sb.length() == 0) return "0";
		 return sb.toString();
	 }
}
