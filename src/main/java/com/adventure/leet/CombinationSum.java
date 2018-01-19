package com.adventure.leet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* https://leetcode.com/problems/combination-sum/
 * https://leetcode.com/discuss/59204/easy-to-understand-96%25-performance-java-solution
 * 
 * Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

The same repeated number may be chosen from C unlimited number of times.

Note:
All numbers (including target) will be positive integers.
Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
The solution set must not contain duplicate combinations.
For example, given candidate set 2,3,6,7 and target 7, 
A solution set is: 
[7] 
[2, 2, 3] 
 * 
 */
public class CombinationSum {
	public static List<List<Integer>> combinationSum(int[] candidates, int target) {
		
		Arrays.sort(candidates);
		
	    return combinationSum(candidates, target, 0);
    }
	
	private static List<List<Integer>> combinationSum(int[] candidates, int target, int start) {
		
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		
		for(int i=start;i<candidates.length;i++) {
			if(candidates[i] > target) {
				break;
			} else if(candidates[i] == target) {
				List<Integer> list = new ArrayList<>();
				list.add(candidates[i]);
				result.add(list);
			} else { // core logic - when candidates[i] < target
				List<List<Integer>> list = combinationSum(candidates, target - candidates[i], i);
				
				for(List<Integer> item : list) {
					item.add(0, candidates[i]);
					result.add(item);
				}
			}
		}
		
		return result;
	}
	
	public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
		
		Arrays.sort(candidates);
		
	    return combinationSum2(candidates, target, 0);
    }
	
	// 2,3,6,7    -- 7
	private static List<List<Integer>> combinationSum2(int[] candidates, int target, int start) {
		
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		
		// since array is sorted, we will return for any item > target
		if(start >= candidates.length || candidates[start] > target) {
		   // this will return an empty list
		} // since array is sorted, we will pick any item that is = targets 
		else if(candidates[start] == target) {
			// this will return a single item list
			List<Integer> list = new ArrayList<>();
			list.add(candidates[start]);
			result.add(list);
		} else { // core logic - when candidates[i] < target
			
			// when candidates[start] < the SUM target, we will do DP
			// take
			List<List<Integer>> list = combinationSum2(candidates, target - candidates[start], start);
			
			for(List<Integer> item : list) {
				item.add(0, candidates[start]); // take
				result.add(item);
			}
			
			// do not take
			list = combinationSum2(candidates, target, start + 1);
			
			for(List<Integer> item : list) {
				result.add(item);
			}
		}
		
		return result;
	}
}
