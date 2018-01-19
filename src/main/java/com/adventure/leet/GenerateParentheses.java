package com.adventure.leet;

import java.util.ArrayList;
import java.util.List;

/*
 * https://leetcode.com/problems/generate-parentheses/
 * 
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

For example, given n = 3, a solution set is:

"((()))", "(()())", "(())()", "()(())", "()()()"
 * 
 */
public class GenerateParentheses {
    public static List<String> generateParenthesis(int n) {
    	List<String> result = new ArrayList<>();
        
    	generateParenthesis(result, "", 0, 0, n);
    	
    	return result;
    }

    // idea: start with left=0, right =0 then left pointer advances, right point catches up!
	private static void generateParenthesis(List<String> result, String str, int left, int right, int n) {
		if(left == right) {
			//result.add(str); // this is for all the valid combinations from 1 to n.
			
			if(str.length() == n * 2) {
				result.add(str);
				
				return;
			}
		}
		
		// as long as left doesn't exceed n, it will keep adding "("
		if(left < n) {
			generateParenthesis(result, str + "(", left+1, right, n);
		}
		
		// as long as right is less than left, it will be catching up by adding ")"
		if(right < left) {
			generateParenthesis(result, str + ")", left, right+1, n);
		}
	}
}
