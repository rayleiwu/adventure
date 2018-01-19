package com.adventure.leet;

/*
 * https://leetcode.com/problems/sqrtx/
 * 
 * Implement int sqrt(int x).

Compute and return the square root of x.
 * 
 * 
 */
public class Sqrt {
	public static int mySqrt(int x) {

		if(x == 0) return 0;
		
		// use binary search method
		int left = 1;
		int right = x;
		
		while(left < right) {
			int mid = left + (right - left) / 2;
			
			if(mid <= x / mid) {  // same as mid * mid <= x
				if(x / (mid + 1) < (mid + 1)) {
					return mid; // found!!!
				}
				
				left = mid + 1;
			} else { // mid * mid > x
				right = mid;
			}
		}
		
		return left;
    }
}
