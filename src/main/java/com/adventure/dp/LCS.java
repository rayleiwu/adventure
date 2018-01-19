package com.adventure.dp;

import com.adventure.util.Utility;

/**
 * http://algorithms.tutorialhorizon.com/dynamic-programming-longest-common-subsequence/
 * @author hduser
 *
Case 1: 

String A: "abcd", String B: "aebd"
	when "d" = "d" : LCS("abcd", "aebd") = 1 + LCS("abc", "aeb")

Case 2: 

String A: "abcde", String B: "aebdf"
	when "e" != "f" : LCS("abcde", "aebdf") = Max(LCS("abcde", "aebd"), LCS("abcd", "aebdf"))
 * 
 */

// input example: A = "acbaed", B = "abcadf"
public class LCS {
	public static String find(String A, String B) {
		int[][] LCS = new int[A.length()+1][B.length()+1];
		char[][] solutions = new char[A.length()+1][B.length()+1];
		
		// we are iterating through A[i], B[j]
		
		// initialize. when A=""
		for(int j=0, i=0;j<=B.length();j++) {
			LCS[i][j] = 0;
			solutions[i][j] = j==0 ? ' ' : B.charAt(j-1);
		}
		
		// initialize.. when B=""
		for(int i=0, j=0; i<=A.length();i++) {
			LCS[i][j] = 0;
			solutions[i][j] = i == 0 ? ' ' : A.charAt(i-1);
		}
		
		// now, DP starts. Solve smallest sub-problem first then bottoming-up
		for(int i=1;i<=A.length();i++) {
			for(int j=1;j<=B.length();j++) {
				
				// case 1, when A[i]=B[j]
				if(A.charAt(i-1) == B.charAt(j-1)) {
					LCS[i][j] = LCS[i-1][j-1] + 1;
					solutions[i][j] = '\\';
				}
				// case 2, when A[i] != B[j]
				else {
					LCS[i][j] = Math.max(LCS[i-1][j], LCS[i][j-1]);
					if(LCS[i][j] == LCS[i-1][j]) 
						solutions[i][j] = '^';
					else 
						solutions[i][j] = '<';
				}
			}
		}
		
		System.out.println("LCS:");
		Utility.displayMatrix(LCS);
		System.out.println("solutions:");
		Utility.displayMatrix(solutions);
		
		
		// below code is to just print the result
		char x =solutions[A.length()][B.length()];
		String answer = "";
		int i = A.length();
		int j = B.length();
		
		while (x == '\\' || x == '<' || x == '^') {
			if (solutions[i][j] == '\\') {
				answer = String.valueOf(A.charAt(i - 1)) + answer;
				i--; j--;
			} else if (solutions[i][j] == '<') {
				j--;
			} else if (solutions[i][j] == '^') {
				i--;
			}
			
			x = solutions[i][j];
		}
		
		return answer;
	}
}
