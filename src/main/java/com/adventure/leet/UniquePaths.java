package com.adventure.leet;

/*
 * https://leetcode.com/problems/unique-paths/
 * 
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

How many possible unique paths are there?

http://leetcode.com/wp-content/uploads/2014/12/robot_maze.png

Above is a 3 x 7 grid. How many possible unique paths are there?

Note: m and n will be at most 100.
 * 
 * 
 * 
 * solutions:
 * 
 * The assumptions are

1) When (n==0||m==0) the function always returns 1 since the robot can't go left or up.
2) For all other combinations. The result = uniquePaths(m-1,n)+uniquePaths(m,n-1)

 * 
 */
public class UniquePaths {
	
	 /*
	  * https://leetcode.com/problems/unique-paths-ii/
	  * Now consider if some obstacles are added to the grids. How many unique paths would there be?

An obstacle and empty space is marked as 1 and 0 respectively in the grid.

For example,
There is one obstacle in the middle of a 3x3 grid as illustrated below.

[
  [0,0,0],
  [0,1,0],
  [0,0,0]
]
The total number of unique paths is 2.
	  */
	 public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
	     return 0;   
	 }
	 
	public static int uniquePaths(int m, int n) {
        
		// base case
		if(m==0 || n==0) return 0;
		if(m==1 || n==1) return 1;
		
		// recursion
		int r1 = uniquePaths(m, n-1);
		int r2 = uniquePaths(m-1, n);
		
		return r1+r2;
    }
	
	public static int uniquePaths2(int m, int n) {
		 Integer[][] map = new Integer[m][n];
		 
	        for(int i = 0; i<m;i++){
	            map[i][0] = 1;
	        }
	        for(int j= 0;j<n;j++){
	            map[0][j]=1;
	        }
	        for(int i = 1;i<m;i++){
	            for(int j = 1;j<n;j++){
	                map[i][j] = map[i-1][j]+map[i][j-1];
	            }
	        }
	        return map[m-1][n-1];
	}
}
