package com.adventure.leet;

/*
 * https://leetcode.com/problems/search-for-a-range/
 * 
 * Given a sorted array of integers, find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

For example,
Given [5, 7, 7, 8, 8, 10] and target value 8,
return [3, 4].

 */
public class SearchForRange {
	 public static int[] searchRange(int[] nums, int target) {
		 
		 if(nums == null || nums.length == 0) return new int[]{-1,-1};
		 		 
	     int[] result = searchRange(nums, target, 0, nums.length - 1);
	     
	     if(result[0] == Integer.MAX_VALUE) result[0] = -1;
	     if(result[1] == Integer.MIN_VALUE) result[1] = -1;
	     
	     return result;
	 }
	 
	 // recursive revised binary search
	 public static int[] searchRange(int[] nums, int target, int left, int right) {
		 int[] result = {Integer.MAX_VALUE, Integer.MIN_VALUE};
		 
		 int[] resultLeft = {Integer.MAX_VALUE, Integer.MIN_VALUE};
		 int[] resultMid = {Integer.MAX_VALUE, Integer.MIN_VALUE};
		 int[] resultRight = {Integer.MAX_VALUE, Integer.MIN_VALUE};
		 
		 if(left <= right) {
		 	 int mid = (left + right) / 2;
			 
			 if(nums[mid] == target) {
				 resultMid[0] = Math.min(resultMid[0], mid);
				 resultMid[1] = Math.max(resultMid[1], mid);
			 }
			 
			 resultLeft = searchRange(nums, target, mid + 1, right);
			 resultRight = searchRange(nums, target, left, mid - 1);
			 
			 result[0] = Math.min(resultLeft[0], result[0]);
			 result[1] = Math.max(resultLeft[1], result[1]);
			 
			 result[0] = Math.min(resultRight[0], result[0]);
			 result[1] = Math.max(resultRight[1], result[1]);
			 
			 result[0] = Math.min(resultMid[0], result[0]);
			 result[1] = Math.max(resultMid[1], result[1]);
		 }
		 		 
		 return result;
	 }
}
