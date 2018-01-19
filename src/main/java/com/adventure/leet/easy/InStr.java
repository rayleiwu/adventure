package com.adventure.leet.easy;

import java.util.ArrayList;
import java.util.List;

public class InStr {

	/*
	 * https://leetcode.com/problems/implement-strstr/
	 * Implement strStr().
       Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
       
       KMP explained: https://www.youtube.com/watch?v=5i7oKodCRJo
       BM algorithm: https://en.wikipedia.org/wiki/Boyer%E2%80%93Moore_string_search_algorithm
       KMP algorithm: https://en.wikipedia.org/wiki/Knuth%E2%80%93Morris%E2%80%93Pratt_algorithm
       
       KMP idea: Don't do same thing again and again! Try to reuse already solved sub-problems!
       
       Pre-process the pattern so we can move the window faster instead of 1
       
	 */
	public static int inStr_KMP(String haystack, String needle) {
		if (haystack == null || needle == null)
	        return -1;
		
	    //generate next array, need O(n) time
	    int i = -1, j = 0, m = haystack.length(), n = needle.length();
	    int[] maxLenOfCommonProperPrefixAndSuffix = new int[n];
	    
	    if (maxLenOfCommonProperPrefixAndSuffix.length > 0) maxLenOfCommonProperPrefixAndSuffix[0] = -1;
	    
	    while (j < n - 1) {
	        if (i == -1 || needle.charAt(i) == needle.charAt(j))
	            maxLenOfCommonProperPrefixAndSuffix[++j] = ++i;
	        else 
	            i = maxLenOfCommonProperPrefixAndSuffix[i];
	    }
	    
	    //check through the haystack using next, need O(m) time
	    i = 0; 
	    j = 0;
	    while (i < m && j < n) {
	        if (j == -1 || haystack.charAt(i) == needle.charAt(j)) {
	            i++;
	            j++;
	        }
	        else 
	            j = maxLenOfCommonProperPrefixAndSuffix[j];
	    }
	    
	    if (j == n)  return i - j;
	    
	    return -1;
	}
	
	// searching for all the existences of given key string
	public static List<Integer> inStrAll_KMP(String haystack, String needle) {
		if (haystack == null || needle == null)
	        return new ArrayList<Integer>();
		
		// build model
	    //generate next array, need O(n) time
	    int i = -1, j = 0, m = haystack.length(), n = needle.length();
	    int[] maxLenOfCommonProperPrefixAndSuffix = new int[n];
	    
	    if (maxLenOfCommonProperPrefixAndSuffix.length > 0) maxLenOfCommonProperPrefixAndSuffix[0] = -1;
	    
	    while (j < n - 1) {
	        if (i == -1 || needle.charAt(i) == needle.charAt(j))
	            maxLenOfCommonProperPrefixAndSuffix[++j] = ++i;
	        else 
	            i = maxLenOfCommonProperPrefixAndSuffix[i];
	    }
	    
	    List<Integer> result = new ArrayList<>();
	    
	    //check through the haystack using next, need O(m) time
	    i = 0; 
	    
	    while (i < m) {
	    	j = 0;
	    	
	    	while (j < n && i < m) {
		        if (j == -1 || haystack.charAt(i) == needle.charAt(j)) {
		            i++;
		            j++;
		        }
		        else 
		            j = maxLenOfCommonProperPrefixAndSuffix[j];
		    }
	    
	    	if (j == n)  result.add(i - j);
	    }
	    
	    return result;
	}
	
}
