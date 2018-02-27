package com.adventure.dc; // divid and conquer

import com.adventure.util.MaxObject;

// https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/
public class MaxSum {

    // this is a good one! Idea is simple: keep adding the difference and record the max profit as you go!
	public Integer maxProfit_quick(int[] a) {
		
		// input validation
		if(a == null || a.length <=0) return null; 
		
		// calc delta
		int[] d = new int[a.length];
		
		d[0] = 0;

		for (int i = 1; i <= a.length - 1; i++) {
			d[i] = a[i] - a[i - 1];
		}
		
		int max = Integer.MIN_VALUE;
		int maxTemp = 0;
		
		for(int i=0;i<d.length;i++) {
			maxTemp += d[i];
			
			if(maxTemp > max) max = maxTemp;
			
			if(maxTemp < 0) maxTemp = 0;
		}
		
		// output
		return max;
	}

	public void maxProfit(int[] stockPrices) {
		
		if(stockPrices == null || stockPrices.length == 0) return;
		
		int[] delta = new int[stockPrices.length];

		// calc delta
		delta[0] = 0;

		for (int i = 1; i <= stockPrices.length - 1; i++) {
			delta[i] = stockPrices[i] - stockPrices[i - 1];
		}

		// divide and conquer
		MaxObject maxSum = getMaxSum(delta, 0, delta.length - 1);

		// show result

		System.out.printf("max: %d from: %d to %d\n", maxSum.getMax(),
				maxSum.getStart(), maxSum.getEnd());

		// breakpoint
		@SuppressWarnings("unused")
		int breakpoint = 0;
	}

	private MaxObject getMaxSum(int[] a, int start, int end) {

		// System.out.printf("processing: %d to %d \n", start, end);

		// base case
		if (start == end) {
			return new MaxObject(a[start], start, end);
		}

		// find the mid point
		int mid = start + (end - start) / 2; // NEVER EVER FORGET start +

		// recursion
		MaxObject maxLeft = getMaxSum(a, start, mid);
		MaxObject maxRight = getMaxSum(a, mid + 1, end);
		MaxObject maxMid = getMaxSumMid(a, start, mid, end);

		// return result
		MaxObject max = null;

		max = maxLeft.getMax() > maxRight.getMax() ? maxLeft : maxRight;
		max = max.getMax() > maxMid.getMax() ? max : maxMid;

		return max;

	}

	private MaxObject getMaxSumMid(int[] a, int start, int mid, int end) {

		int maxLeft = Integer.MIN_VALUE;
		int maxRight = Integer.MIN_VALUE;
		int max = 0;
		int left = -1;
		int right = -1;

		// find max left
		for (int i = mid; i >= start; i--) {
			max += a[i];

			if (max > maxLeft) {
				maxLeft = max;
				left = i;
			}
		}

		max = 0;

		// find max right
		for (int i = mid + 1; i <= end; i++) {
			max += a[i];

			if (max > maxRight) {
				maxRight = max;
				right = i;
			}
		}

		return new MaxObject(maxLeft + maxRight, left, right);
	}
}
