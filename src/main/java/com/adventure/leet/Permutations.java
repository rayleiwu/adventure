package com.adventure.leet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * https://leetcode.com/problems/permutations/
 * 
 * Given a collection of distinct numbers, return all possible permutations.

For example,
[1,2,3] have the following permutations:
[1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].
 * 
 */
public class Permutations {

	public static List<List<Integer>> permute(int[] nums) {
		Integer[] nums2 = new Integer[nums.length];
		
		for(int i = 0; i < nums.length; i++) {
			nums2[i] = nums[i];
		}
				
		return permute(Arrays.asList(nums2));
    }
	
	/*
	 * Given a collection of numbers that might contain duplicates, return all possible unique permutations.
		For example,
		[1,1,2] have the following unique permutations:
		[1,1,2], [1,2,1], and [2,1,1].
	 * 
	 * 
	 */
	public static List<List<Integer>> permuteUnique(int[] nums) {
		Integer[] nums2 = new Integer[nums.length];
		
		for(int i = 0; i < nums.length; i++) {
			nums2[i] = nums[i];
		}
				
		return permuteUnique(Arrays.asList(nums2));
    }
	
	// recursion
	private static List<List<Integer>> permuteUnique(List<Integer> nums) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		
		// base case
		if(nums.size() == 1) {
			result.add(nums);
			return result;
		}
	
		// here we make it unique (we can use hashmap for performance). Store index instead of value
		// Map<Value, Index>
		Map<Integer, Integer> map = new HashMap<>();
		
		for(int i=0;i<nums.size();i++) {
			if(!map.containsKey(nums.get(i))) {
				map.put(nums.get(i), i);
			}
		}
		
		// recursion
		for(Integer key : map.keySet()) {
			List<Integer> numsCopy = new ArrayList<>(nums);
			numsCopy.remove((int)map.get(key)); // remove current item then do recursion
			
			List<List<Integer>> childResult = permuteUnique(numsCopy);
			
			for(List<Integer> list : childResult) {
				list.add(0, key);
				result.add(list);
			}
		}
		
		return result;
	}

	
	// recursion
	private static List<List<Integer>> permute(List<Integer> nums) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		
		// base case
		if(nums.size() == 1) {
			result.add(nums);
			return result;
		}
		
		// recursion
		for(int i=0;i<nums.size();i++) {
			List<Integer> numsCopy = new ArrayList<>(nums);
			numsCopy.remove(i); // remove current item then do recursion
			
			List<List<Integer>> childResult = permute(numsCopy);
			
			for(List<Integer> list : childResult) {
				list.add(0, nums.get(i));
				result.add(list);
			}
		}
		
		return result;
	}
}
