package com.adventure.leet;

import com.adventure.util.Utility;

/*
 * https://leetcode.com/problems/longest-palindromic-substring/
 * 
 * Given a string S, find the longest palindromic substring in S. You may assume that the maximum length of S is 1000, and there exists one unique longest palindromic substring.
 * input: bananas  output: anana  (forward read = backward read)
 * 
 */
public class LongestPalindromicSubstring {
	public static String longestPalindrome(String s) {
        String result = "";
		
        if(s == null || s.length() <= 1) return s;
        
        char[] c = s.toCharArray();
        
        for(int i=0;i<c.length;i++) {
        	String temp = largestPalindrome(c, i);
        	
        	if(temp.length() > result.length()) {
        		result = temp;
        	}
        }
        
        return result;
    }
	
	private static String largestPalindrome(char[] c, int i) {
		int begin = i;
		int end = i;
		String temp = "";
		
		while(begin >= 0 || end < c.length) {
			
			// when begin and end are still valid, different value will exit
			if(begin >= 0 && end < c.length && c[begin] != c[end]) {
				break;
			} else {
				if(begin == end) {
					temp = String.valueOf(c[begin]);
				} else {
					if(begin <0 || end >= c.length) { // when begin or end are invalid, we will check if the new value is same as the old
						if(begin <0 && end < c.length && c[end] == c[i]) {
							temp = temp + String.valueOf(c[end]);
						}
						
						if(begin >=0 && end >= c.length && c[begin] == c[i]) {
							temp = String.valueOf(c[begin]) + temp;
						}
					} else { // when begin and end are still valid, we accept both values
						temp = String.valueOf(c[begin]) + temp + String.valueOf(c[end]);
					}
				}
			}
			
			begin--;
			end++;
		}
		
		return temp;
	}

	// assum start <= end
	public static Boolean isPalindrome(String s, int start, int end) {
		if(start < 0 || end < 0) return false;
		
		while(start < end) {
			if(s.charAt(start) != s.charAt(end)) {
				return false;
			}
			
			start++;
			end--;
		}
		
		return true;
	}
}
