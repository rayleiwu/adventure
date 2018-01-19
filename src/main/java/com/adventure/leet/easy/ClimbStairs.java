package com.adventure.leet.easy;

/*
 * https://leetcode.com/problems/climbing-stairs/
 * 
 * you are climbing a stair case. It takes n steps to reach to the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 * 
 * 
 */
public class ClimbStairs {
	public static int climbStairs(int n) {
		
		// it's basically fibonacci!
		
		// base cases
		if(n <= 2) return n;
		
		// calculate fibonacci
		int stepOne = 1;
		int stepTwo = 2;
		int stepThree = 0;
		
		for(int i = 3; i <= n; i++) {
			stepThree = stepTwo + stepOne;
			stepOne = stepTwo;
			stepTwo = stepThree;
		}
		
        return stepThree;
    }
}
