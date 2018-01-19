package com.adventure.leet;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/*
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 * 
 Given a string, find the length of the longest substring without repeating characters. 
 For example, the longest substring without repeating letters for "abcabcbb" is "abc", 
 which the length is 3. For "bbbbb" the longest substring is "b", with the length of 1.
 */
public class LongestStringNoRepeat {
	
	public static int lengthOfLongestSubstring(String s) {
		
		int max = 0;
		
		if(s == null || s.length() == 0) return max;
		
		Map<Integer, Integer> hash = new HashMap<Integer, Integer>();
		
		char[] chars = s.toCharArray();
		
		for(int i=0;i<chars.length;i++) {
			if(!hash.containsKey((int)chars[i])) { // add to hash if not there
				hash.put((int)chars[i], i);
				max = Math.max(max, hash.keySet().size());
			} else { // if a duplicate is found. We keep everything after the first char of the duplicate, mark the max then move on
				max = Math.max(max, hash.keySet().size());
				
				// get index of the duplicate
				int dupIndex = hash.get((int)chars[i]);
				// remove all elements that are prior to the first char of the duplicated chars
				Iterator<Map.Entry<Integer,Integer>> iter = hash.entrySet().iterator();
				while (iter.hasNext()) {
				    Map.Entry<Integer,Integer> entry = iter.next();
				    if(dupIndex >= entry.getValue()){
				        iter.remove();
				    }
				}
				
				hash.put((int)chars[i], i);
			}
		}
		
		return max;
    }
}
