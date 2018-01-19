package com.adventure.leet.easy;

/*
 * https://leetcode.com/problems/add-binary/
 * 
 * Given two binary strings, return their sum (also a binary string).

For example,
a = "11"
b = "1"
Return "100".
 * 
 */
public class AddBinary {
	public static String addBinary(String a, String b) {
        
		// validate input
		if(a == null || b == null) return null;
		
		// convert to arrays
		char[] aa = a.toCharArray();
		char[] ba = b.toCharArray();
		int carry = 0;
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i <= Math.max(aa.length, ba.length) - 1; i++) {
			int an = 0;
			int bn = 0;
			
			if(i < aa.length){
				an = (int)(aa[aa.length - i - 1] - '0');
			}
			
			if(i < ba.length) {
				bn = (int)(ba[ba.length - i - 1] - '0');
			}
			
			sb.insert(0, (an + bn + carry) % 2);
			carry = (an + bn + carry) / 2;
		}
		
		if(carry == 1) {
			sb.insert(0, carry);
		}
		
		return sb.toString();
    }
}
