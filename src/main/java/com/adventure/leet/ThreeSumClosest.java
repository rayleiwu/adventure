package com.adventure.leet;

import java.util.Arrays;

/*
 * https://leetcode.com/problems/3sum-closest/
 * 
 * Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. Return the sum of the three integers. You may assume that each input would have exactly one solution.

    For example, given array S = {-1 2 1 -4}, and target = 1.

    The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 */
public class ThreeSumClosest {
	public static int threeSumClosest(int[] nums, int target) {
		
        Arrays.sort(nums);
        
        int result = nums[0] + nums[1] + nums[nums.length - 1];
        
        for (int i = 0; i < nums.length - 2; i++) {
            int start = i + 1, end = nums.length - 1;
            
            while (start < end) {
                int sum = nums[i] + nums[start] + nums[end];
                
                if (sum > target) {
                    end--;
                } else {
                    start++;
                }
                
                if (Math.abs(sum - target) < Math.abs(result - target)) {
                    result = sum;
                }
            }
        }
        
        return result;
    }
}
