package com.adventure.leet.easy;

/*
 * https://leetcode.com/problems/count-and-say/
 * 
 * The count-and-say sequence is the sequence of integers beginning as follows:
1, 11, 21, 1211, 111221, ...

1 is read off as "one 1" or 11.
11 is read off as "two 1s" or 21.
21 is read off as "one 2, then one 1" or 1211.
Given an integer n, generate the nth sequence.

Note: The sequence of integers will be represented as a string.


 1.     1
 2.     11
 3.     21
 4.     1211
 5.     111221 
 6.     312211
 7.     13112221
 8.     1113213211
 9.     31131211131221
 10.    13211311123113112211
 
 */
public class NthSequence {
    public static String countAndSay(int n) {
        String s = "1";
        
        for(int i=1; i<n; i++) {
        	s = countAndSay(s);
        }
        
        return s;
    }
    
    // for example: s = '312211'
    public static String countAndSay(String s) {
    	StringBuilder sb = new StringBuilder();
    	
    	int counter = 1;
    	char prevChar = s.charAt(0);
    	
		for(int i=1;i<s.length();i++) {
			if(s.charAt(i) != prevChar) {
				sb.append(counter).append(prevChar);
				prevChar = s.charAt(i);
				counter = 1;
			} else {
				counter ++;
			}
		}
		
		sb.append(counter).append(prevChar);
    	
    	return sb.toString();
    }
}
