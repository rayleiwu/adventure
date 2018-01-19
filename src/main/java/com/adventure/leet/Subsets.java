package com.adventure.leet;

import java.util.ArrayList;
import java.util.List;

/***
 * https://leetcode.com/problems/subsets/
 * @author hduser
 * 
 * Given a set of distinct integers, nums, return all possible subsets.

Note: The solution set must not contain duplicate subsets.

For example,
If nums = [1,2,3], a solution is:

[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]
 *
 */
public class Subsets {
	public static List<List<Integer>> subsets(int[] nums) {
	       /***
			 *  idea:
			 *  
			 *  n=0: []
			 *  n=1: []+1=[1]
			 *  n=2: []+2=[2], [1]+2=[1,2]
			 *  n=3: []+3=[3], [1]+3=[1,3], [2]+3=[2,3], [1,2]+3=[1,2,3]
			 */
	        
			List<List<Integer>> result = new ArrayList<>();
			
			// add empty list first
			result.add(new ArrayList<Integer>());
			
			// iterate through all the elements
			for(int n : nums) {
				List<List<Integer>> temp = new ArrayList<>();
				
				// add n to all Lists we have built so far
				for(List<Integer> e : result) {
					List<Integer> list = new ArrayList<>();
					list.addAll(e);
					list.add(n);
					temp.add(list);
				}
				
				result.addAll(temp);
			}
			
			return result; 
	    }
}
