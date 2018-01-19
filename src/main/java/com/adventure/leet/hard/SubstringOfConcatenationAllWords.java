package com.adventure.leet.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.adventure.leet.easy.InStr;

/*
 * https://leetcode.com/problems/substring-with-concatenation-of-all-words/
 * 
 * You are given a string, s, and a list of words, words, that are all of the same length. Find all starting indices of substring(s) in s that is a concatenation of each word in words exactly once and without any intervening characters.

For example, given:
s: "barfoothefoobarman"
words: ["foo", "bar"]

You should return the indices: [0,9].
(order does not matter).
 * 
 */

public class SubstringOfConcatenationAllWords {
	public static List<Integer> findSubstring(String s, String[] words) {
        
		if(s == null || s.length() == 0 || words == null || words.length == 0) return new ArrayList<Integer>();
		
		// find positions where each word is located in s  - O(N*2)
		Map<String, List<Integer>> positions = new HashMap<String, List<Integer>>(); 
		
		for(String w : words) {
			List<Integer> p = InStr.inStrAll_KMP(s, w);
			
			System.out.printf("%s in %s : %s \n", w, s, Arrays.toString(p.toArray()));
			
			positions.put(w, p);
		}
		
		// find all the joint points (through a binary search on sorted arrays) - O(N*logN)
		// first we mix all positions and sort them O(N*logN)
		Map<Integer, String> sorted = new TreeMap<Integer, String>();
		
		for(String key : positions.keySet()) {
			for(Integer pos : positions.get(key)) {
				sorted.put(pos, key);
			}
		}
		
		// debug
		for(Integer key : sorted.keySet()) {
			System.out.printf("%d - %s\n", key, sorted.get(key));
		}
		
		if(sorted.size() <= 0) return new ArrayList<Integer>();
		
		List<Integer> result = new ArrayList<>();
		
		// we now iterate through the sorted array to find sub arrays that meet our requirements: ...
		Integer wordLen = words[0].length();
		Integer prevPosition = -1;
		
		Map<Integer, String> candidate = new TreeMap<Integer, String>();
		
		for(Integer position : sorted.keySet()) {  // O(NlogN)
			
			String word = sorted.get(position);
			
			// our requirements : 1) step must be wordLen and 2) word must be unique
			if((prevPosition == -1 || position == prevPosition + wordLen) && !candidate.containsKey(position)) {
			
				candidate.put(position, word);
			
				// found one
				if(candidate.size() == words.length) {
					
					// grab first index in candidate
					for(Integer index : candidate.keySet()) {
						result.add(index);
						break;
					}
					
					prevPosition = -1; // reset
					candidate.clear();
					
				} else {
					// move onto next index
					prevPosition = position;
				}
			} else {
				candidate.clear();
				candidate.put(position, word);
				prevPosition = position;
			}
		}
		
		return result;
    }
}
