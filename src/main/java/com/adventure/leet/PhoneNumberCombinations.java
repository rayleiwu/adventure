package com.adventure.leet;

import java.util.ArrayList;
import java.util.List;

/*
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/
 * 
 * Given a digit string, return all possible letter combinations that the number could represent.
 * 
 */
public class PhoneNumberCombinations {
	public static List<String> letterCombinations(String digits) {
		List<String> result = new ArrayList<>();
		
		//corner cases
		if(digits == null|| digits.isEmpty()) return result;
				
		// map
		String letters[] = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        
		List<List<String>> strs = new ArrayList<List<String>>();
		
		for(int i=0;i<digits.length();i++){
			String s = letters[digits.charAt(i) - '0'];
			
			if(!s.isEmpty()) {
				List<String> temp = new ArrayList<>();
				for(Character c : s.toCharArray()) {
					temp.add(c.toString());
				}
				strs.add(temp);
			}
		}
		
		// combine
		result = new ArrayList<>();

		for(List<String> list : strs) {
			result = CombinationsOfTwo(result, list);
		}
		
		// return
		return result;
    }
	
	private static List<String> CombinationsOfTwo(List<String> list1, List<String> list2) {
		// corner cases
		if(list1.isEmpty()) return list2;
		if(list2.isEmpty()) return list1;
		
		// combine
		List<String> result = new ArrayList<>();
		
		for(String s1 : list1) {
			for(String s2 : list2) {
				result.add(s1 + s2);
			}
		}
		
		return result;
	}
}
