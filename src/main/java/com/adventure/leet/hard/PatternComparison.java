package com.adventure.leet.hard;

/*
 * https://leetcode.com/problems/wildcard-matching/
 * 
 * solution: https://leetcode.com/discuss/10133/linear-runtime-and-constant-space-solution
 * 
 * Implement wildcard pattern matching with support for '?' and '*'.

'?' Matches any single character.
'*' Matches any sequence of characters (including the empty sequence).

The matching should cover the entire input string (not partial).

The function prototype should be:
bool isMatch(const char *s, const char *p)

Some examples:
isMatch("aa","a") → false
isMatch("aa","aa") → true
isMatch("aaa","aa") → false
isMatch("aaaaabbbbccd", "a*c") → false
isMatch("aa", "a*") → true
isMatch("ab", "?*") → true
isMatch("aab", "c*a*b") → false
 */
public class PatternComparison {
	public static boolean isMatch(String s, String p) {
        
		int s_index = 0;
		int s_index_prev = -1;
		
		int p_index = 0;
		int p_index_prev = -1;
		
		while(s_index < s.length()) {
			// advance both pointers
			if(p_index < p.length() && (p.charAt(p_index) == '?' || p.charAt(p_index) == s.charAt(s_index))) {
				s_index++; p_index++;
				
			// when a * is found, only advance pattern pointer
			} else if(p_index < p.length() && p.charAt(p_index) == '*') {
				p_index_prev = p_index; // remember this current pattern position with "*" and ..
				p_index++;              // move on
				
				s_index_prev = s_index;
				
			// if previous pattern position was "*", advance string pointer
			} else if(p_index_prev != -1) {
				p_index = p_index_prev + 1;
				
				s_index_prev++;
				s_index = s_index_prev;
			} else { // current pattern char is not * and last pattern char was not *
				return false; 
			}
		}
		
		// check remaining chars in pattern
		while(p_index < p.length() && p.charAt(p_index) == '*') {
			p_index ++ ;
		}
		
		return p_index == p.length();
    }
}
