package com.adventure.leet.easy;

/*
 * https://leetcode.com/problems/zigzag-conversion/
 * input: PAYPALISHIRING
 * output: PAHNAPLSIIGYIR
 */
public class ZigzagConversion {
	public static String convert(String s, int numRows) {
        if(numRows<=1 || s==null || s.length() <= numRows) return s;
  
        StringBuilder[] sb = new StringBuilder[numRows];
        int i=0;
        int flip=1;
        
        for(int k=0;k<sb.length;k++) {
        	sb[k] = new StringBuilder();
        }
        
        while(i < s.length()) {
        	if(flip == 1) { // top -> bottom
    			for(int j=0;j<numRows;j++) {
    				if(i+j < s.length()) sb[j].append(s.charAt(i+j));
    			}
    			i+=numRows;
    		} else { // bottom to top (skip two rows)
    			for(int j=0;j<numRows-2;j++) {
    				if(i+j < s.length()) sb[numRows-j-2].append(s.charAt(i+j));
    			}
    			i+=(numRows-2);
    		}
        	
    		flip = -flip;
        }
        
        for(int k=1;k<sb.length;k++) {
        	sb[0].append(sb[k].toString());
        }
        
        return sb[0].toString();
    }
}
