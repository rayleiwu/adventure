package com.adventure.leet;

/*
 * 
 * https://leetcode.com/problems/set-matrix-zeroes/
 * 
 * Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.
 * 
 */
public class SetMatrixZeroes {
	public static void setZeroes(int[][] matrix) {
     
		boolean firstRowToZero = false;
		boolean firstColToZero = false;
		
		for(int i=0;i<matrix.length;i++) {
			for(int j=0;j<matrix[i].length;j++) {
				if(matrix[i][j] == 0) {
					
					if(i == 0) firstRowToZero = true;
					if(j == 0) firstColToZero = true;
					
					matrix[i][0] 
					= matrix[0][j] 
                    = 0;
				}
			}
		}
		
		for(int i=1;i<matrix.length;i++) {
			for(int j=1;j<matrix[i].length;j++) {
				if(matrix[i][0] == 0 || matrix[0][j] == 0 ) {
					matrix[i][j] = 0;
				}
			}
		}
		
		if(firstColToZero) {
			for(int i=0;i<matrix.length;i++) {
				matrix[i][0] = 0;
			}
		}
		
		if(firstRowToZero) {
			for(int j=0;j<matrix[0].length;j++) {
				matrix[0][j] = 0;
			}
		}
    }
}
