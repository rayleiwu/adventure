package com.adventure.leet.hard;

/* https://leetcode.com/problems/jump-game-ii/
 * 
 *  solution: https://leetcode.com/discuss/13293/sharing-my-ac-java-solution
 * 
 * 
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Your goal is to reach the last index in the minimum number of jumps.

For example:
Given array A = [2,3,1,1,4]

The minimum number of jumps to reach the last index is 2. (Jump 1 step from index 0 to 1, then 3 steps to the last index.)

Note:
You can assume that you can always reach the last index.
 * 
 */
public class Jump {

	/*
	e: longest distance in current minimum step
	sc: minimum steps for reaching e
	From i to e, even max is changed in a loop, it is reachable in one step.
	*/
    public static int jump(int[] A) {
	    int sc = 0;
	    int e = 0;
	    int max = 0;
	    for(int i=0; i<A.length-1; i++) {
	        max = Math.max(max, i+A[i]);
	        if( i == e ) {
	            sc++;
	            e = max;
	        } 
	    }
	    return sc;
    }
	
	
	
	 // Note: nums represents MAX jumps. You can choose from 1 to nums[i] steps
	 public static int jump2(int[] nums) {
	
		 if(nums == null || nums.length == 0) return -1;
		 
		 // calculate how far each item can reach
		 int[] maxReach = new int[nums.length];
		 
		 for(int i=0; i<nums.length;i++) {
			 maxReach[i] = i + nums[i];
		 }
		 
		 // now, start from 1st element, move toward the last element
		 int preStep = 0;
		 int steps = 1;
		 int maxReachSofar = -1;
		 
		 for(int i=1; i<maxReach.length-1;i++) {
			 
			 // if i moves out of range of preStep, we move the next step
			 if(i > maxReach[preStep]) {
				 preStep = i;
				 maxReachSofar = -1;
				 steps++;
			 }
			 
		 	 // if current is "covered" by its predecessor, we abandon it by marking it with -1!
			 if(maxReachSofar != -1 && maxReach[i] <= maxReach[maxReachSofar]) {
				 nums[i] = -1;
			 } else { // if predecessor is "covered" by current, we abandon the predecessor instead
				 
				 if(maxReachSofar != -1) {
					 nums[maxReachSofar] = -1;
				 }
				 
				 maxReachSofar = i;
			 }
			 
			 if(maxReach[maxReachSofar] >= maxReach.length ) {
				 steps++;
				 break;
			 }
		 }
		 
		 return steps;
	 }
}
