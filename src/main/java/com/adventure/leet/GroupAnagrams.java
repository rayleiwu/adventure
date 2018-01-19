package com.adventure.leet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * https://leetcode.com/problems/anagrams/
 * 
 * Given an array of strings, group anagrams together.

For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"], 
Return:

[
  ["ate", "eat","tea"],
  ["nat","tan"],
  ["bat"]
]

Note:
For the return value, each inner list's elements must follow the lexicographic order.
All inputs will be in lower-case.

 * 
 */
public class GroupAnagrams {
	public static List<List<String>> groupAnagrams(String[] strs) {
		
		Map<String, List<String>> map = new HashMap<>();
		
		for(String s: strs) {
			String key = hashKey(s);
			if(!map.containsKey(key)) {
				List<String> list = new ArrayList<>();
				list.add(s);
				map.put(key, list);
			} else {
				map.get(key).add(s);
			}
		}
		
		List<List<String>> result = new ArrayList<>();
		
		for(List<String> list : map.values()) {
			List<String> temp = new ArrayList<>(list);
			Collections.sort(temp);
			result.add(temp);
		}
		
        return result;
    }
	
	private static String hashKey(String str) {
		char[] chars = str.toCharArray();
		Arrays.sort(chars);
		return String.valueOf(chars);
	}
}
