package com.adventure.leet.easy;

import java.util.HashMap;
import java.util.Map;

/*
 * https://leetcode.com/problems/roman-to-integer/
 */
public class RomanToInteger {
	public static int romanToInt(String s) {
		//：Ⅰ（1）Ⅴ（5）Ⅹ（10）L（50）C（100）D（500）M（1000） 
        // rules:位于大数的后面时就作为加数；位于大数的前面就作为减数
        //eg：Ⅲ=3,Ⅳ=4,Ⅵ=6,ⅩⅨ=19,ⅩⅩ=20,ⅩLⅤ=45,MCMXXC=1980
        //"DCXXI"
		
		Map<Character, Integer> map = new HashMap<>();
		map.put('I', 1);
		map.put('V', 5);
		map.put('X', 10);
		map.put('L', 50);
		map.put('C', 100);
		map.put('D', 500);
		map.put('M', 1000);
		
		int r = 0;
		int prev = 0;
				
		for(int i=s.length() - 1; i >= 0; i--) {
			int num = map.get(s.charAt(i));
			
			if(num >= prev) {
				r+=num;
			} else {
				r-=num;
			}
			
			prev = num;
		}
		
		return r;
		
    }
}
