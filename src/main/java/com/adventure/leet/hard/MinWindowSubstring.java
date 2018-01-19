package com.adventure.leet.hard;

/*
 * https://leetcode.com/problems/minimum-window-substring/
 * 
 * Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).

For example,
S = "ADOBECODEBANC"
T = "ABC"
Minimum window is "BANC".

Note:
If there is no such window in S that covers all characters in T, return the empty string "".

If there are multiple such windows, you are guaranteed that there will always be only one unique minimum window in S.
 * 
 * 
 */
public class MinWindowSubstring {

	// https://leetcode.com/discuss/32851/share-my-neat-java-solution
	
	// find the first window that satisfies the constraint
	// then, continue maintaining the constraint throughout
	public static String minWindow(char[] s, char[] t) {  // s = {ADOBECODEBANC}, t={ABC}
    
		int m = s.length, n = t.length;
		
		if(n <= 0 || m < n) return "";
		
		int required[] = new int[128];
		int found[] = new int[128];
		
		// add all the chars and their counts we will need
		for(int i=0; i<n; i++) {
			required[t[i]]++;
		}
		
		int count = 0, minLen = Integer.MAX_VALUE, minIndex = 0;
		
		for(int start = 0, end = 0; end < m; end++) {
			
			// start with end pointer
			char currentEnd = s[end];
			
			// skip chars not in in t
			if(required[currentEnd] == 0) continue;
			
			// we found one of required chars
			found[currentEnd]++;
			
			// count total found chars that meet required constraint so far. Ignore exceeded counts
			if(found[currentEnd] <= required[currentEnd]) count ++;
			
			// now, we have found 1st sequence that meet the constraint. Let's make it better..
			if(count == n) {
				char currentStart = s[start];
				
				// KEY LOGIC IS HERE: move start index as far as we can
				// IDEA IS: end increases # of char as it advances
				//          start decreases # of char as it advances
				//          start is allowed to advance ONLY when # of char exceeds the required #
				//          calculate min window as end advances
				while(required[currentStart] == 0 // skip ones we are not interested in..
					  || found[currentStart] > required[currentStart]) { // 
					
					if(found[currentStart] > required[currentStart]) found[currentStart]--; //???
					
					start++;
					currentStart = s[start];
				}
				
				// update minimum window
				if(end - start + 1 < minLen) {
					minLen = end - start + 1;
					minIndex = start;
				}
			}
		}
		
		
		return (minLen == Integer.MAX_VALUE ? "" : String.valueOf(s).substring(minIndex, minIndex + minLen));
    }
}
