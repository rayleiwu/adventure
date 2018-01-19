package com.adventure.leet.easy;

/*
 * https://leetcode.com/problems/string-to-integer-atoi/
 * String[] s = {null, "", "+-2", "a123", " a123b", "  123", "  123  abc", "000123", "0+00123", "+123", "-000123", " + 123abc", "+  a123", "-a123xyz", "123.456abc", "2147483647", "-2147483648", "2147483888", "-2147483888"};
 * 
 * Requirements for atoi:
The function first discards as many whitespace characters as necessary until the first non-whitespace character is found. 
Then, starting from this character, takes an optional initial plus or minus sign followed by as many numerical digits as possible, and interprets them as a numerical value.
The string can contain additional characters after those that form the integral number, which are ignored and have no effect on the behavior of this function.
If the first sequence of non-whitespace characters in str is not a valid integral number, or if no such sequence exists because either str is empty or it contains only whitespace characters, no conversion is performed.
If no valid conversion could be performed, a zero value is returned. If the correct value is out of the range of representable values, INT_MAX (2147483647) or INT_MIN (-2147483648) is returned.
 */
public class StringToInteger {
	public static int myAtoi(String str) {

		if(str == null || str.length() <= 0) return 0;
		
		// clean the string
		StringBuilder sb = new StringBuilder();
		
		for(int i=0;i<str.length();i++) {
			char c = str.charAt(i);
			
			// find out first number
			if(sb.length() == 0) {
				if(c != ' ') { //The function first discards as many whitespace characters as necessary until the first non-whitespace character is found.
					if(c == '+' || c == '-') { //Then, starting from this character, takes an optional initial plus or minus sign followed by as many numerical digits as possible, and interprets them as a numerical value.
						sb.append(c);
					} else if( c >= '0' && c <= '9') {
						sb.append(c);
					} else {
						return 0;
					}
				}
			} else { // after the first number, every single one must be a number!
				if(c < '0' || c > '9') {
					break;
				} else {
					sb.append(c);
				}
			}
		}
		
		// at this point, we should the only "clean" formats: 123, 000123, 123000, 01230, +12300, -12300
		// convert the string
		String s = sb.toString();
		
		if(s == null || s.length() <= 0) return 0;
		
		long sign = 1;
		int start = 0;
		
		if(s.charAt(0) == '-' || s.charAt(0) == '+') {
			start = 1;
			
			if(s.charAt(0) == '-') {
				sign = -1;
			}
		}
		
		long r = 0;
		long m = 1;
		
		for(int i=s.length()-1;i>=start;i--) {
			long t = m * ((long)s.charAt(i) - (long)'0');
			
			if(t > Integer.MAX_VALUE) {
				if(sign == -1) {
					return Integer.MIN_VALUE;					
				} else {
					return Integer.MAX_VALUE;	
				}
			}
			
			r += t;
			m *= 10;
		}
		
		long l = r * sign;
		
		if(l > Integer.MAX_VALUE) l = Integer.MAX_VALUE;
		if(l < Integer.MIN_VALUE) l = Integer.MIN_VALUE;
		
		return (int) l;
    }
}
