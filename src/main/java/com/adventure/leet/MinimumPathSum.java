package com.adventure.leet;

/*
 * https://leetcode.com/problems/minimum-path-sum/
 * 
 * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.

Note: You can only move either down or right at any point in time.
 * 
 */
public class MinimumPathSum {
	public static int minPathSum(int[][] grid) {
        // input validation
		if(grid == null) return -1;
		
		// iterate row x col
		for(int row = 0; row < grid.length; row ++) {
			for(int col = 0; col < grid[row].length; col++) {
				if(row == 0 && col == 0) {
					// do nothing
				} else if(row == 0) {
					grid[row][col] += grid[row][col - 1];
				} else if(col == 0) {
					grid[row][col] += grid[row - 1][col];
				} else { // row >0 && col > 0
					grid[row][col] += Math.min(grid[row][col - 1], grid[row - 1][col]);
				}
			}
		}
		
		// result
		return grid[grid.length - 1][grid[0].length - 1];
    }
}
