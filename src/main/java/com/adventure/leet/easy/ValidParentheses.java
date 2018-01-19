package com.adventure.leet.easy;

import java.util.Stack;

/*
 * https://leetcode.com/problems/valid-parentheses/
 * 
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 * 
 */
public class ValidParentheses {
	 public static boolean isValid(String s) {
	     
		 if(s == null || s.length() == 0) return true;
		 
		 Stack<Character> stack = new Stack<>();
		 
		 for(Character c : s.toCharArray()) {
			 if(c == '(' || c == '{' || c == '[') {
				 stack.push(c);
			 } else {
				 if(c == ')') {
					 if(stack.isEmpty() || stack.pop() != '(') return false;
				 } else if(c == '}') {
					 if(stack.isEmpty() || stack.pop() != '{') return false;
				 } else if(c == ']') {
					 if(stack.isEmpty() || stack.pop() != '[') return false;
				 }
			 }
		 }
		 
		 return stack.isEmpty();
	 }
}
