package com.adventure.leet;

/*
 * https://leetcode.com/problems/search-a-2d-matrix/
 * 
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row.
For example,

Consider the following matrix:

[
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
Given target = 3, return true.
 * 
 */
public class Search2DMatrix {
	public static boolean searchMatrix(int[][] matrix, int target) {
        
		if(matrix == null) return false;
		if(matrix.length == 0) return false;
		
		int row_top = 0, row_bottom = matrix.length - 1;
		int col_left = 0, col_right = matrix[0].length - 1;
		
		// binary search over rows
		while(row_top <= row_bottom) {
			int row_mid = (row_bottom - row_top) / 2 + row_top;
			
			if(matrix[row_mid][0] == target) {
				return true;
			}
			else if(matrix[row_mid][0] < target) {
				row_top++;
			}
			else {
				row_bottom--;
			}
		}
		
		row_top = Math.min(row_top, row_bottom);
		
		if(row_top == -1 || row_top > matrix.length - 1) return false;
		
		// binary search over cols
		while(col_left <= col_right) {
			int col_mid = (col_right - col_left) / 2 + col_left;
			
			if(matrix[row_top][col_mid] == target) {
				return true;
			}
			else if(matrix[row_top][col_mid] < target) {
				col_left++;
			}
			else {
				col_right--;
			}
		}
		
		return false;
    }
}
