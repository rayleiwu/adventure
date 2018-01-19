package com.adventure.leet.easy;

public class RemoveDuplicatesFromSortedArray {
	public static int removeDuplicates(int[] nums) {
        
		// corner cases
		if(nums == null) return 0;
		if(nums.length <= 1) return nums.length;

		// iterate through all elements. k counts unique elements
		int k = 0;
		int val = nums[0];
		
		for(int i=1; i< nums.length; i++) {
			if(nums[i] != val) {
				k++;
				nums[k] = nums[i];
				val = nums[i];
			}
		}
		
		return k + 1;
    }
}
