package com.adventure.recursion;

public class n2m {
	public static int calcuate(int n, int m) {
		// base case
		if(m == 0) return 1;
		if(m == 1) return n;
		
		// recursion
		boolean isOdd = (m % 2 == 1);
		
		if(isOdd) m = m + 1;
		
		int r = calcuate(n, m/2);
		
		if(isOdd) {
			return r * r / n;
		} else {
			return r * r;
		}
	}
}
