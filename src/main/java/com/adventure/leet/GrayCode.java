package com.adventure.leet;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * https://leetcode.com/problems/gray-code/
 * 

The gray code is a binary numeral system where two successive values differ in only one bit.

Given a non-negative integer n representing the total number of bits in the code, 
print the sequence of gray code. A gray code sequence must begin with 0.

For example, given n = 2, return [0,1,3,2]. Its gray code sequence is:

00 - 0
01 - 1
11 - 3
10 - 2
Note:
For a given n, a gray code sequence is not uniquely defined.

For example, [0,2,3,1] is also a valid gray code sequence according to the above definition.
 *
 */
public class GrayCode {
	public static List<Integer> grayCode(int n) {
		
		List<Integer> rs=new ArrayList<Integer>();
	    rs.add(0);
	    
	    for(int i=0;i<n;i++){
	        int size=rs.size();
	        
	        for(int k=size-1;k>=0;k--) {
	        	int temp = rs.get(k);
	            rs.add(temp | 1<<i); // this is to add "1" to left side of temp
	        }
	    }
	    
	    return rs;
    }
}
