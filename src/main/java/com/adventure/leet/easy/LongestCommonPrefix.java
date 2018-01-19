package com.adventure.leet.easy;
/*
 * https://leetcode.com/problems/longest-common-prefix/
 * 
 * {"a","a","b"} should give "" as there is nothing common in all the 3 strings.

{"a", "a"} should give "a" as a is longest common prefix in all the strings.

{"abca", "abc"} as abc

{"ac", "ac", "a", "a"} as a.
 */

public class LongestCommonPrefix {
    public static String longestCommonPrefix(String[] strs) {
    	
    	// corner cases
    	if(strs == null || strs.length == 0) return "";
    	if(strs.length == 1) return strs[0];
    	
    	// iterate through all strings from first char to last
    	// exit if a) one string runs out 
    	//    and  b) one string has different chat at the same location
    	
    	int i = -1;
    	boolean done = false;
    	
    	while(!done) {
    		Character c = null;
    		i++;
    		
    		for(String s : strs) {
    			if(s == null || s == "" || i >= s.length()) {
    				done = true; //a) one string runs out
    				break;
    			}
    			
    			if(c == null) {
    				c = s.charAt(i);
    			} else {
    				if (s.charAt(i) != c) { //b) one string has different char at the same location
    					done = true;
    					break;
    				}
    			}
    		}
    	}

    	if(i == -1) {
    		return "";
    	} else {
    		return strs[0].substring(0, i);
    	}
    }
}
