package com.adventure.leet.hard;

import java.util.Stack;

/*
 * https://leetcode.com/problems/longest-valid-parentheses/
 * 
 * Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.

For "(()", the longest valid parentheses substring is "()", which has length = 2.

Another example is ")()())", where the longest valid parentheses substring is "()()", which has length = 4.


The workflow of the solution is as below.

Scan the string from beginning to end.
If current character is '(', push its index to the stack. 
If current character is ')' and the character at the index of the top of stack is '(', we just find a matching pair so pop from the stack. 
Otherwise, we push the index of ')' to the stack.
After the scan is done, the stack will only contain the indices of characters which cannot be matched. 
Then let's use the opposite side - substring between adjacent indices should be valid parentheses.
If the stack is empty, the whole input string is valid. 
Otherwise, we can scan the stack to get longest valid substring as described in step 3.
 */
public class LongestValidParentheses {
	
	public static int longestValidParentheses(String s) {
    	
		Stack<Integer> stack = new Stack<>();
		
		// push and pop until we have all unmatched in stack!
		for(int i = 0; i < s.length(); i ++) {
			if(s.charAt(i) == '(') {
				stack.push(i);
			} else if(s.charAt(i) == ')') {
				if(!stack.isEmpty() && s.charAt(stack.peek()) == '(') {
					stack.pop();
				} else {
					stack.push(i);
				}
			}
		}
		
		// now, if stack is empty, we have the longest!
		if(stack.isEmpty()) return s.length();
		
		if(stack.size() == s.length()) return 0;
		
		// otherwise, the longest is one of those between
		int longest = Integer.MIN_VALUE;
		int prevIndex = s.length();
		
		while(!stack.empty()) {
			int index = stack.pop();
			longest = Math.max(longest, prevIndex - index - 1);
			prevIndex = index;
		}
		
		longest = Math.max(longest, prevIndex);

		return longest;
		
    }
}
