package com.adventure.leet.hard;

/*
 * https://leetcode.com/problems/edit-distance/
 * 
 * Given two words word1 and word2, find the minimum number of steps required to convert word1 to word2. (each operation is counted as 1 step.)

You have the following 3 operations permitted on a word:

a) Insert a character
b) Delete a character
c) Replace a character
 * 
 */
public class EditDistance {

	// solution: https://leetcode.com/discuss/10426/my-o-mn-time-and-o-n-space-solution-using-dp-with-explanation
	/*
	 * 
	 * 
Use f[i][j] to represent the shortest edit distance between word1[0,i) and word2[0, j). 
Then compare the last character of word1[0,i) and word2[0,j),
 which are c and d respectively (c == word1[i-1], d == word2[j-1]):

if c == d, then : f[i][j] = f[i-1][j-1]

Otherwise we can use three operations to convert word1 to word2:

(a) if we replaced c with d: f[i][j] = f[i-1][j-1] + 1;

(b) if we added d after c: f[i][j] = f[i][j-1] + 1;

(c) if we deleted c: f[i][j] = f[i-1][j] + 1;

Note that f[i][j] only depends on f[i-1][j-1], f[i-1][j] and f[i][j-1], 
therefore we can reduce the space to O(n) by using only the (i-1)th array and previous updated element(f[i][j-1]).
	 * 
	 * 
	 * 
	 * 
	 */
	public static int minDistance(String word1, String word2) {
	 
		if(word1 == null) word1 = "";
		if(word2 == null) word2 = "";
		
		if(word1.isEmpty()) return word2.length();
		if(word2.isEmpty()) return word1.length();
		
		int[][] dist = new int[word1.length()+1][word2.length()+1];
		
		for(int i=0;i<=word1.length();i++) {
			dist[i][0] = i;
		}
		
		for(int j=0;j<=word2.length();j++) {
			dist[0][j] = j;
		}
		
		for(int i=1;i<=word1.length();i++) {
			for(int j=1;j<=word2.length();j++) {
				if(word1.charAt(i-1) == word2.charAt(j-1)) {
					dist[i][j] = dist[i-1][j-1]; 
				} else {
					dist[i][j] = Math.min(Math.min(dist[i][j-1],dist[i-1][j]), dist[i-1][j-1]) + 1; 
				}
			}
		}
		
		return dist[word1.length()][word2.length()];
	}
}
