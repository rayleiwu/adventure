package com.adventure.dp;

public class RodCutting {

	private final static int[] PRICES = {0,1,5,8,9,10,17,17,20,24,30}; // index represents length of the rod
	
	
	// version 1: top-down with memorization (time-memory trade-off)
	public static int MemoziedCut(int n) {
		int[] r = new int[n + 1]; // store computed max profit for size 0 to n
		
		for(int i =0 ; i< r.length; i++) {
			r[i] = Integer.MIN_VALUE;
		}
		
		return MemoziedCutHelper(n, r);
	}
	
	private static int MemoziedCutHelper(int n, int[] r) {
		
		if(r[n] >= 0) {
			return r[n];
		}
		
		int profit;
		
		if(n == 0) {
			profit = 0;
		} else {
			profit = Integer.MIN_VALUE;
			
			for(int i = 1; i <= n; i++) {
				profit = Math.max(profit, PRICES[i] + MemoziedCutHelper(n - i, r));
			}
		}
		
		r[n] = profit;

		return profit;
	}
	
	
	// version 2: bottom-up. Solve small problem first. -- GOOD ONE!
	public static int BottomUpCut(int n) {
		int[] r = new int[n + 1]; // store computed max profit for size 0 to n

		r[0] = 0;
		
		for(int j=1; j<=n;j++) {
			int profit = Integer.MIN_VALUE;
			
			for(int i=1;i<=j;i++) {
				profit = Math.max(profit, PRICES[i] + r[j-i]);
			}
			
			r[j] = profit;
		}
		
		return r[n];
	}
}
