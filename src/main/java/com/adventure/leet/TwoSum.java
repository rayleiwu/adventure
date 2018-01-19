package com.adventure.leet;

import java.util.HashMap;
import java.util.Map;

/********************************************************************************************************
https://leetcode.com/problems/two-sum/

Given an array of integers, find two numbers such that they add up to a specific target number.

The function twoSum should return indices of the two numbers such that they add up to the target, 
where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are 
not zero-based.

You may assume that each input would have exactly one solution.

Input: numbers={2, 7, 11, 15}, target=9
Output: index1=1, index2=2
**********************************************************************************************************/
public class TwoSum {
	public static int[] twoSum(int[] nums, int target) {
		
		if(nums == null || nums.length <=0) return null;
		
        Map<Integer,Integer> hash = new HashMap<Integer,Integer>();
        
        for(int i=nums.length-1;i>=0;i--) {
        	if(hash.containsKey(target - nums[i])) {
        		return new int[]{i + 1, hash.get(target - nums[i]) + 1};
        	} else {
        		hash.put(nums[i], i);
        	}
        }
        
        return null;
    }
}
