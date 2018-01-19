package com.adventure.leet.hard;

import java.util.Stack;

/**
 * 
 * https://leetcode.com/problems/largest-rectangle-in-histogram/
 * @author hduser
 *Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area of largest rectangle in the histogram.


Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].


The largest rectangle is shown in the shaded area, which has area = 10 unit.

For example,
Given heights = [2,1,5,6,2,3],
return 10.
 */

// explanation
// O(N^2) and O(N*LogN) http://www.geeksforgeeks.org/largest-rectangular-area-in-a-histogram-set-1/
// O(N) http://www.geeksforgeeks.org/largest-rectangle-under-histogram/
public class LargestRectangleInHistorgram {
	
	 public int largestRectangleArea(int[] height) {
	        int len = height.length;
	        Stack<Integer> s = new Stack<Integer>();
	        
	        int maxArea = 0;
	        
	        for(int i = 0; i <= len; i++){
	            int h = (i == len ? 0 : height[i]);
	            if(s.isEmpty() || h >= height[s.peek()]){
	                s.push(i);
	            }else{
	                int tp = s.pop();
	                maxArea = Math.max(maxArea, height[tp] * (s.isEmpty() ? i : i - 1 - s.peek()));
	                i--;
	            }
	        }
	        
	        return maxArea;
	  }
}
