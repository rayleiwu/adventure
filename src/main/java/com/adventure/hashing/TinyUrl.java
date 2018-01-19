package com.adventure.hashing;

public class TinyUrl {
	public static final String Alphabet = "abcdefghijklmnopqrstuvwxyz0123456789";
	public static final long Base = Alphabet.length();
	
	public static String Encode(long i) {
	
		if(i == 0) return String.valueOf(Alphabet.charAt(0));
		
		StringBuilder s = new StringBuilder();
		
		while(i > 0) {
			s.append(Alphabet.charAt((int) (i % Base)));
			i = i / Base;
		}
		
		return s.reverse().toString();
	}
	
	public static long Decode(String s) {
		long i = 0;
		
		for(char c : s.toCharArray()) {
			i = (i * Base) + Alphabet.indexOf(c);
		}
		
		return i;
	}
}
