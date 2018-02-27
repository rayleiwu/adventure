package com.adventure.bit;

public class IntToBit {
	public static String convert(int num) { // In Java, int is by default 32 bits
		StringBuilder sb = new StringBuilder();
		int mask = 1 << 31; // shift 31 bit left
		
		//System.out.println(String.format("%32s", Integer.toBinaryString(num)).replace(" ", "0"));
		
		for(int i=0;i<=31;i++) {
			
			//System.out.println(String.format("%32s", Integer.toBinaryString(mask)).replace(" ", "0"));
			
			if((num & mask) == 0) {
				sb.append("0");
			} else {
				sb.append("1");
			}
			
			if(i % 4 == 0 && i != 31 && i != 0) sb.append(' ');
			
			mask = (mask >>> 1);
		}
		
		return sb.toString();
	}
}
