package com.adventure.leet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * https://leetcode.com/problems/4sum/
 * 
 * Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.

Note:
Elements in a quadruplet (a,b,c,d) must be in non-descending order. (ie, a ≤ b ≤ c ≤ d)
The solution set must not contain duplicate quadruplets.
    For example, given array S = {1 0 -1 0 -2 2}, and target = 0.

    A solution set is:
    (-1,  0, 0, 1)
    (-2, -1, 1, 2)
    (-2,  0, 0, 2)
 * 
 * 
 */
public class FourSum {
	
	public static List<List<Integer>> fourSum(int[] nums, int target) {
		// define return
		List<List<Integer>> r = new ArrayList<>();
		
		// corner cases
		if(nums == null || nums.length <= 0) return r;
		
		// sort the array
		Arrays.sort(nums);
		
		Integer preNum = null;
		
		// iterate through all numbers n to find -1 * n
		for(int i=0;i<nums.length;i++) {
			if(preNum == null || nums[i] != preNum) {
				preNum = nums[i];
				
				List<List<Integer>> temp = threeSum(nums, target-nums[i], i+1);
				
				if(!temp.isEmpty()) {
					for(List<Integer> l : temp) {
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
	
	public static List<List<Integer>> threeSum(int[] nums, int target, int start) {
		// define return
		List<List<Integer>> r = new ArrayList<>();
		
		Integer preNum = null;
		
		// iterate through all numbers n to find -1 * n
		for(int i=start;i<nums.length;i++) {
			if(preNum == null || nums[i] != preNum) {
				preNum = nums[i];
				
				List<List<Integer>> temp = twoSum(nums, target-nums[i], i+1);
				
				if(!temp.isEmpty()) {
					for(List<Integer> l : temp) {
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
	public static List<List<Integer>> twoSum(int[] nums, int target, int start) {
		List<List<Integer>> r = new ArrayList<List<Integer>>();
		
		// corner cases
		if(nums == null || nums.length == 0) return r;
		
		// narrowing down from start and end toward middle to find the pair
		//int start = 0;
		int end = nums.length - 1;
		int preStartNum = 0;
		
		while(start < end) {
			if(nums[start] + nums[end] == target) {
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
				
			} else if(nums[start] + nums[end] > target) {
				end--;
			} else {
				start++;
			}
		}
		
		return r;
	}
}
