package com.adventure.leet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* https://leetcode.com/problems/combination-sum-ii/
 * 
 * 
 * Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

Each number in C may only be used once in the combination.

Note:
All numbers (including target) will be positive integers.
Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
The solution set must not contain duplicate combinations.
For example, given candidate set 10,1,2,7,6,1,5 and target 8,

sorted: 1,1,2,5,6,7,10
 
A solution set is: 
[1, 7] 
[1, 2, 5] 
[2, 6] 
[1, 1, 6] 
 * 
 */
public class CombinationSumUnique {
	public static List<List<Integer>> combinationSum(int[] candidates, int target) {
		
		Arrays.sort(candidates);
		
	    return combinationSum(candidates, target, 0);
    }
	
	// 1,1,2,5,6,7,10    -- 8
	private static List<List<Integer>> combinationSum(int[] candidates, int target, int start) {
		
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		
		for(int i=start;i<candidates.length;i++) {
			if(candidates[i] > target) {
				break;
			} else if(i > start && candidates[i] == candidates[i-1]) {   // this line is the difference #1 from CombinationSum
				continue;
			} else if(candidates[i] == target) {    
				List<Integer> list = new ArrayList<>();
				list.add(candidates[i]);
				result.add(list);
			} else { // core logic - when candidates[i] < target
				List<List<Integer>> list = combinationSum(candidates, target - candidates[i], i + 1);  // i+1 vs i is the difference #2 from CombinationSum
				
				for(List<Integer> item : list) {
					item.add(0, candidates[i]);
					result.add(item);
				}
			}
		}
		
		return result;
	}
}
