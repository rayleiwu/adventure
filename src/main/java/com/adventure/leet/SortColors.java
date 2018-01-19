package com.adventure.leet;

/*
 * https://leetcode.com/problems/sort-colors/
 * 
 * 
 * Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.

Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

Note:
You are not suppose to use the library's sort function for this problem.

click to show follow up.

Follow up:
A rather straight forward solution is a two-pass algorithm using counting sort.
First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's, then 1's and followed by 2's.

Could you come up with an one-pass algorithm using only constant space?
 * 
 * 
 */
public class SortColors {
	public static void sortColors(int[] nums) {
		
		if(nums == null || nums.length <= 1) return;
		
		// this is a counting sort!!
		
		int red = 0;
		int white = 0;
		int blue = 0;
		
		for(int n : nums) {
			if(n == 0) {
				red++;
			} else if(n == 1) {
				white++;
			} else {
				blue++;
			}
		}
		
		int i = 0;
		
		for(;i<red;i++) {
			nums[i] = 0;
		}
		
		for(;i<red + white;i++) {
			nums[i] = 1;
		}
		
		for(;i<red + white + blue;i++) {
			nums[i] = 2;
		}
    }
}
