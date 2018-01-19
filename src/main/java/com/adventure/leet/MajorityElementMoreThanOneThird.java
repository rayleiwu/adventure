package com.adventure.leet;

import java.util.ArrayList;
import java.util.List;

public class MajorityElementMoreThanOneThird {
 /*
   
   THIS IS A modified MOORE'S algorithm
    
    HINT: for n/3, there are only up to 2 of them
    
    n1, n2 are 2 distinct numbers. 
    c1, c2 are the count of the 2 numbers. 
    Whenever encounter 3 different numbers, cancel them by decreasing the count. 
    And the remaining 2 numbers (or 1 or 0) are candidates. 
    Scan the array one more time to determine the result.
    
    */
    
     public List<Integer> majorityElement(int[] nums) {
        List<Integer> rst = new ArrayList<Integer>();
        
        if (nums == null) {
            return rst;
        }
        
        int n1 = 0, n2 = 0; // candidates
        int c1 = 0, c2 = 0; // counters
        
        for (int i = 0; i < nums.length; ++i) {
            int n3 = nums[i];
            
            if (c1 > 0 && c2 > 0) {
                if (n3 != n1 && n3 != n2) {
                    c1--;
                    c2--;
                } else if (n3 == n1) {
                    c1++;
                } else {
                    c2++;
                }
            } else if (c1 > 0) {
                if (n3 == n1) {
                    c1++;
                } else {
                    n2 = n3;
                    c2++;
                }
            } else if (c2 > 0) {
                if (n3 == n2) {
                    c2++;
                } else {
                    n1 = n3;
                    c1++;
                }
            } else {
                n1 = n3;
                c1++;
            }
        }
        
        c1 = c2 = 0;
        
        for (int i = 0; i < nums.length; ++i) { // n1, n2 are only candidates!!! need to count again!!!
            if (nums[i] == n1) {
                c1 ++;
            } else if (nums[i] == n2) { //no worry if n1==n2 in some cases, because we only count once.
                c2 ++;
            }
        }
        
        if (c1 > nums.length/3) {
            rst.add(n1);
        }
        
        if (c2 > nums.length/3) {
            rst.add(n2);
        }
        
        return rst;
    }
}
