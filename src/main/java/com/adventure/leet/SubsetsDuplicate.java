package com.adventure.leet;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

/***
 * https://leetcode.com/problems/subsets-ii/
 * @author hduser
 * 
 * iven a collection of integers that might contain duplicates, nums, return all possible subsets.

Note: The solution set must not contain duplicate subsets.

For example,
If nums = [1,2,2], a solution is:

[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]
 *
 */
public class SubsetsDuplicate {
	public static List<List<Integer>> subsets(int[] nums) {
	       /***
			 *  idea:
			 *  First sort the array
			 *  
			 *  n=0: []
			 *  n=1: []+1=[1]
			 *  n=2: []+2=[2], [1]+2=[1,2]
			 *  n=3: []+3=[3], [1]+3=[1,3], [2]+3=[2,3], [1,2]+3=[1,2,3]
			 *  
			 *  // there is another 3! NOW, duplicate occurs. We will skip all previous numbers and only do previous step
			 *  // why? because previous n=3 has already done that!
			 *  n=3: [3]+3=[3,3], [1,3]+3=[1,3,3], [2,3]+3=[2,3,3], [1,2,3]+3=[1,2,3,3]
			 */
	    
		    // sort the array so we will know if there is a duplicate
		    Arrays.sort(nums);
		
			List<List<Integer>> result = new ArrayList<>();
			
			// add empty list first
			result.add(new ArrayList<Integer>());
			
			Integer prevNum = null;
			List<List<Integer>> prevTemp = new ArrayList<>(); 
			
			// iterate through all the elements
			for(int n : nums) {
				List<List<Integer>> temp = new ArrayList<>();
				
				if(prevNum != null && n == prevNum) { // duplicate occurs
					// we add n to the list generated from previous step only (instead of all the List we have build so far)
					for(List<Integer> e : prevTemp) {
						List<Integer> list = new ArrayList<>();
						list.addAll(e);
						list.add(n);
						temp.add(list);
					}
				} else {
					// add n to all Lists we have built so far
					for(List<Integer> e : result) {
						List<Integer> list = new ArrayList<>();
						list.addAll(e);
						list.add(n);
						temp.add(list);
					}
				}
				
				result.addAll(temp);
				
				// record some of result for next possible duplicate num
				prevNum = n;
				prevTemp.clear();
				prevTemp.addAll(temp);
			}
			
			return result; 
	    }
}
