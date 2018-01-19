package com.adventure.leet.hard;

/*
 * https://leetcode.com/problems/first-missing-positive/
 * 
 * Given an unsorted integer array, find the first missing positive integer.

For example,
Given [1,2,0] return 3,
and [3,4,-1,1] return 2.

Your algorithm should run in O(n) time and uses constant space.
 * 
 */
public class FirstMissingPositive {
	public static int firstMissingPositive(int[] nums) {
		int i = 0;
		
		//Pass 1, move every value to the position of its value
		while(i < nums.length){
            if(	nums[i] <= 0 // ignore negative number 
            	|| nums[i] == i+1 // skip the number already in its "position of the value"
            	|| nums[i] > nums.length) { // ignore value exceeds the size of the array
            	
            	i++;
            }
            else if(nums[i] != nums[nums[i]-1]) {
            	swap(nums, i, nums[i]-1); // now, move the value to the "position of the value"
            }
            else {
            	i++;
            }
        }
		
		//Pass 2, find first location where the index doesn't match the value
		i = 0;
		
		while(i < nums.length) {
			
			if(nums[i] != i+1) {
				break;
			}
			
			i++;
		}
		
        return i + 1; // return next value of i
    }
	
	public static int firstMissingPositive2(int[] nums) {
		int i = 0;
		
        while(i < nums.length){
            if(	nums[i] <= 0 // ignore negative number 
            	|| nums[i] == i+1 
            	|| nums[i] > nums.length) i++;
            else if(nums[nums[i]-1] != nums[i]) swap(nums, i, nums[i]-1);
            else i++;
        }
        
        i = 0;
        
        while(i < nums.length && nums[i] == i+1) i++;
        
        return i+1;
    }
	
	private static void swap(int[] A, int i, int j){
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}
