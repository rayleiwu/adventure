package com.adventure.leet;

import java.util.Stack;

/*
 * https://leetcode.com/problems/simplify-path/
 * 
 * 
 * Given an absolute path for a file (Unix-style), simplify it.

For example,
path = "/home/", => "/home"
path = "/a/./b/../../c/", => "/c"
click to show corner cases.

Corner Cases:
Did you consider the case where path = "/../"?
In this case, you should return "/".
Another corner case is the path might contain multiple slashes '/' together, such as "/home//foo/".
In this case, you should ignore redundant slashes and return "/home/foo".
 * 
 */
public class SimplifyPath {
	public static String simplifyPath(String path) {
        
		Stack<String> stack = new Stack<>();
		String[] pa = path.split("/");
		
		// clean up (business logic)
		for(String s : pa) {
			if(s.equals("..")) {
				if(!stack.isEmpty()) stack.pop();
			} else if(!s.isEmpty() && !s.equals(".")) {
				stack.push(s);
			}
		}
		
		// re-assemble 
		StringBuilder sb = new StringBuilder();
		
		while(!stack.isEmpty()) {
			sb.insert(0, stack.pop());
			sb.insert(0, "/");
		}
		
		// output
		return sb.toString().isEmpty() ? "/" : sb.toString();
    }
}
