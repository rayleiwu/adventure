package com.adventure.leet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LargestDivisibleSubset {
	public static List<Integer> largestDivisibleSubset(int[] nums) {
	       
        if(nums.length < 2) {
        	
        	List<Integer> a = new ArrayList<>();
        	
        	for(int i=0;i<nums.length;i++) a.add(nums[i]);
        	
        	return a;
        }
        else{
            
            // sort it
            Arrays.sort(nums);
            
            int[] parent = new int[nums.length]; // stores the parent-child relation
            int[] count = new int[nums.length]; // stores counts
            
            int max = 0, maxind = -1;
            
            // backward iteration
            for(int i = nums.length - 1; i >= 0; i--){
                for(int j = i; j < nums.length; j++){
                    if(nums[j] % nums[i] == 0 && count[i] < 1 + count[j] ){
                        count[i] = 1 + count[j];
                        parent[i] = j;
                        
                        if(count[i] > max){
                            max = count[i];
                            maxind = i;
                        }
                    }
                }
            }
            
            List<Integer> res = new ArrayList<>();
            
            for(int i = 0; i < max; i++){
                res.add(nums[maxind]);
                maxind = parent[maxind];
            }
            
            return res;
        }
    }
}
