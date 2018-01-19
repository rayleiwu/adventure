package com.adventure.leet;

/*
 * https://leetcode.com/problems/powx-n/
 * 
 * Implement pow(x, n).
 * 
 * 
 * see chart: https://leetcode.com/submissions/detail/55757417/
 * 
 */
public class Power {

	// recursion (here n is always an even number that >= 0 
	public static double myPow(double x, int n) {
		
		// base case
		if(n == 0) return 1;
		
		if(n < 0) {
			n = -n;
			x = 1/x;
		}
		
		// recursion
		double result = myPow(x, n/2);
		
		result = result * result;
		
		if(n%2 == 1) result = result * x;
		
		return result;
	}
}
