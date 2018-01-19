package com.adventure.leet;

import java.util.ArrayList;
import java.util.List;

/* https://leetcode.com/problems/permutation-sequence/
 * 
 * The set [1,2,3,…,n] contains a total of n! unique permutations.

By listing and labeling all of the permutations in order,
We get the following sequence (ie, for n = 3):

"123"
"132"
"213"
"231"
"312"
"321"
Given n and k, return the kth permutation sequence.

Note: Given n will be between 1 and 9 inclusive.
 * 
 */
public class PermutationsGet {
	public static String getPermutation(int n, int k) {
		
		List<Integer> numbers = new ArrayList<>();
		
		int[] factorial = new int[n+1];
		StringBuilder sb = new StringBuilder();
		
		int sum = 1;
		factorial[0] = sum;
		
		for(int i=1;i<=n;i++) {
			// calculate factorial {1,1,2,6,24...n!}
			sum*=i;
			factorial[i] = sum;
		
			// create a list of numbers to get indices
			numbers.add(i);
		}
		
		k--; // as indices start with 0
		
		for(int i=1; i<=n;i++) {
			int f = factorial[n-i];
			int index = k/f;
			sb.append(numbers.get(index));
			numbers.remove(index);
			
			// remaining
			k%=f;
		}
		
        return sb.toString();
    }
}
