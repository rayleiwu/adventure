package com.adventure.leet;

/*
 * https://leetcode.com/problems/rotate-image/
 * 
 * You are given an n x n 2D matrix representing an image.

Rotate the image by 90 degrees (clockwise).

Follow up:
Could you do this in-place?
 * 
 */
public class RotateImage {
	
	 
	/*
	 * clockwise rotate
	 * first reverse up to down, then swap the symmetry 
	 * 1 2 3     7 8 9     7 4 1
	 * 4 5 6  => 4 5 6  => 8 5 2
	 * 7 8 9     1 2 3     9 6 3
	*/
	
	/*
	 * anticlockwise rotate
	 * first reverse left to right, then swap the symmetry
	 * 1 2 3     3 2 1     3 6 9
	 * 4 5 6  => 6 5 4  => 2 5 8
	 * 7 8 9     9 8 7     1 4 7
	*/
	
	 public static void rotate(int[][] matrix) {
		   if (matrix == null || matrix.length <= 1) {
		        return;
		    }
		    int n = matrix.length;
		    for (int i = 0; i < n; i++) {
		        for (int j = i; j < n; j++) {
		            int temp = matrix[i][j];
		            matrix[i][j] = matrix[j][i];
		            matrix[j][i] = temp;
		        }
		    }
		    for (int i = 0; i < n; i++) {
		        int head = 0;
		        int tail = n - 1;
		        while (head < tail) {
		            int temp = matrix[i][head];
		            matrix[i][head] = matrix[i][tail];
		            matrix[i][tail] = temp;
		            head++;
		            tail--;
		        }
		    }
	 }
}
