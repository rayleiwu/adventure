package com.adventure.leet;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * https://leetcode.com/problems/combinations/
 * 
 * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

For example,
If n = 4 and k = 2, a solution is:

[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]



Another solution by me: Use the sample solution from "Total combination" solution, simply add a filter len() <= k

n = 4
n = 0: []
n = 1: [1]
n = 2: [2], [1,2]
n = 3: [3], [1,3], [2,3], [1,2,3]
n = 4: [4], [1,4], [2,4], [1,2,4], [3,4], [1,3,4], [2,3,4], [1,2,3,4]

 *
 */
public class Combinations {
	
	// based on C(n, k) = C(n-1, k-1) + C(n-1, k)
	public List<List<Integer>> combine(int n, int k) {
        
		//base cases
		if(k == 0) {  // produce empty list. For example: [[]]
			List<List<Integer>> result = new ArrayList<>();
			List<Integer> list = new ArrayList<>();
			
			result.add(list);
			
			return result;
		}
		
		if(k == n) { // produce a list with each element containing single number. For example: [[1],[2],[3],[4]]
			List<List<Integer>> result = new ArrayList<>();
			List<Integer> list = new ArrayList<>();
			
			for(int i=1;i<=k;i++) {
				list.add(i);
			}
			
			result.add(list);
			return result;
		}
		
		//recursion
		List<List<Integer>> result1 = combine(n-1, k-1);
		List<List<Integer>> result2 = combine(n-1, k);
		
		// add number n to result1 to make it k elements
		for(List<Integer> list : result1) {
			list.add(n);
		}
		
		// combine result1 & result2
		result1.addAll(result2);
		
		return result1;
    }
}
