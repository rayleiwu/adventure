package com.adventure.leet.hard;

/* 
 * https://leetcode.com/problems/trapping-rain-water/
 *  solution: https://leetcode.com/discuss/18022/sharing-my-java-code-o-n-time-o-1-space
 * 
 * 
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.

For example, 
Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.


The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. 
In this case, 6 units of rain water (blue section) are being trapped. 
http://www.leetcode.com/wp-content/uploads/2012/08/rainwatertrap.png
 */
public class TrappingRainWater {

	public static int trap(int[] height) {
		
		if(height == null || height.length <= 2) return 0;
		
		int left = 0;
		int right = height.length - 1;
		
		// find first left that can hold water
		while(height[left] <= height[left + 1] && left < height.length - 2) {
			left ++;
		}
		
		// find first right that can hold water
		while(height[right] <= height[right - 1] && right > 1) {
			right --;
		}
		
		int water = 0;
		
		// continue moving both pointers toward mid until they meet
		while(left < right) {
			
			int leftMax = left;
			int rightMax = right;
			
			if(height[leftMax] <= height[rightMax]) {
				// from left to right - taking water until you hit a higher wall
				while(left < right && height[leftMax] >= height[++left]) {
					water+=(height[leftMax] - height[left]);
				}
			} else {
				// from right to left - taking water until you hit a hight wall
				while(left < right && height[rightMax] >= height[--right]) {
					water+=(height[rightMax] - height[right]);
				}
			}
		}
		
        return water;
    }
}
