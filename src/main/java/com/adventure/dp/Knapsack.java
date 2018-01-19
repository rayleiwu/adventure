package com.adventure.dp;

import com.adventure.util.Utility;

public class Knapsack {

	private static final int[] itemWeights = {2,3,4,5};  // represents item's weight
	private static final int[] itemValues = {3,7,2,9}; // represents item's value
	
	// W - knapsack weight capacity
	// https://www.youtube.com/watch?v=PLJHuErj-Tw
	public static void Calculate(int W) {
		
		int[][] v = new int[itemWeights.length+1][W+1]; // stores values for each weight
		
		// set 0 value for weight limit = 0
		for(int k=0;k<=itemWeights.length;k++) { // item limit
			v[k][0] = 0;
		}
		
		// set 0 value for item limit = 0
		for(int w=0;w<=W;w++) { // weight limit
			v[0][w] = 0;
		}
		
		for(int k=1;k<=itemWeights.length;k++) { // item number limit from 1 to all
			for(int w=1;w<=W;w++) { // weight limit from 1 to W
				// get Kth weight and value
				int weight = itemWeights[k - 1];
				int value = itemValues[k - 1];
				
				if(weight > w) { // if Kth item exceeds the current weight limit, we skip it and use previous max value
					v[k][w] = v[k-1][w];
				} else { // if Kth item is in current weight limit, we will "try" to add it to the knapsack
					v[k][w] = Math.max(v[k-1][w], v[k-1][w - weight] + value);
				}
				
				System.out.printf("Calculating k(item limit)=%d w(weight limit)=%d \n", k, w);
				Utility.displayMatrix(v);
			}
		}
		
		// the bottom-right element in the array is the result
		System.out.printf("Max value for the weight limit of %d is %d\n", W, v[v.length - 1][v[v.length-1].length - 1]);
	}
}
