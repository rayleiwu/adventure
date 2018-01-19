package com.adventure.leet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * https://leetcode.com/problems/3sum/
 * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? 
 * Find all unique triplets in the array which gives the sum of zero.

Note:
Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)
The solution set must not contain duplicate triplets.
    For example, given array S = {-4 -1 -1 0 1 2},

    A solution set is:
    (-1, 0, 1)
    (-1, -1, 2)
 */
public class ThreeSum {
	
	public static List<List<Integer>> threeSum(int[] nums) {
		return threeSum(nums, 0);
	}
	
	public static List<List<Integer>> threeSum(int[] nums, int start) {
		// define return
		List<List<Integer>> r = new ArrayList<>();
		
		// corner cases
		if(nums == null || nums.length <= 0) return r;
		
		// sort the array
		Arrays.sort(nums);
		
		Integer preNum = null;
		
		// iterate through all numbers n to find -1 * n
		for(int i=start;i<nums.length;i++) {
			if(preNum == null || nums[i] != preNum) {
				preNum = nums[i];
				
				List<List<Integer>> two = twoSum(nums, -nums[i], i+1);
				
				if(!two.isEmpty()) {
					for(List<Integer> l : two) {
						List<Integer> m = new ArrayList<>();
						m.add(nums[i]);
						m.addAll(l);	
						
						r.add(m);
					}
				}
			}
		}
		
		return r;
    }
	
	// find all unique pairs that sum up to k out of a sorted array
	public static List<List<Integer>> twoSum(int[] nums, int k, int start) {
		List<List<Integer>> r = new ArrayList<List<Integer>>();
		
		// corner cases
		if(nums == null || nums.length == 0) return r;
		
		// narrowing down from start and end toward middle to find the pair
		//int start = 0;
		int end = nums.length - 1;
		int preStartNum = 0;
		
		while(start < end) {
			if(nums[start] + nums[end] == k) {
				// take them if not already in list
				if(r.isEmpty() || nums[start] != preStartNum) {
					List<Integer> l = new ArrayList<Integer>();
					l.add(nums[start]);
					l.add(nums[end]);
					
					r.add(l);
				}
				
				preStartNum = nums[start];
				start++;
				end--;
				
			} else if(nums[start] + nums[end] > k) {
				end--;
			} else {
				start++;
			}
		}
		
		return r;
	}
}
