package com.adventure.leet.easy;

/*
 * https://leetcode.com/problems/valid-sudoku/
 * 
 * Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.

The Sudoku board could be partially filled, where empty cells are filled with the character '.'.


A partially filled sudoku which is valid.

Note:
A valid Sudoku board (partially filled) is not necessarily solvable. Only the filled cells need to be validated.
 */
public class ValidSudoku {
	public static boolean isValidSudoku(char[][] board) {
        	
		boolean[][] rows = new boolean[9][9];
		boolean[][] cols = new boolean[9][9];
		boolean[][] sub = new boolean[9][9];
		
		for(int row=0;row<9;row++) {
			for(int col=0;col<9;col++) {
				 int c = board[row][col] - '1';
				 
				 if(board[row][col] == '.') continue;
				 
				 if(rows[row][c] || cols[col][c] || sub[row/3 * 3 + col/3][c]) return false;
				 
				 rows[row][c] = cols[col][c] = sub[row/3 * 3 + col/3][c] = true;
			}
		}
		
		return true;
    }
}
