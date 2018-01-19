package com.adventure.leet;

/*
 * https://leetcode.com/problems/search-insert-position/
 * 
 * Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You may assume no duplicates in the array.

Here are few examples.
[1,3,5,6], 5 → 2
[1,3,5,6], 2 → 1
[1,3,5,6], 7 → 4
[1,3,5,6], 0 → 0
 * 
 */
public class SearchInsertPosition {

	public static int searchInsert(int[] nums, int target) {
		
		if(nums == null || nums.length == 0) return -1;
		
		int low = 0;
		int high = nums.length - 1;
	
		while(low <= high) {
			
			int mid = (low + high) / 2;
		
			if(nums[mid] == target) return mid;
			
			if(nums[mid] < target) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
	
		return low;
	}

}
