package com.adventure.leet.easy;

public class PalindromeNumber {
	
	 public static boolean isPalindrome(int x) {
	     long x_long = x;
	     
		 // testing
	     // x_long = 123321;
		 
		 if(x_long < 0) return false;
		 
		 // first, find digits
		 long digit = 1;
		 long temp = x_long;
		 long m = 1;
		 
		 while(temp / 10 > 0) {
			 digit++;
			 m *= 10;
			 temp /= 10;
		 }
		 
		 if(digit == 1) return true;
		 
		 // now, iterate through half digits and compare from head and tail to center
		 digit = digit / 2;
		 
		 long y_long = x_long;
		 long n =1;
		 
		 for(long i=0;i<digit;i++) {
			 // head
			 long head = 0;
			 
			 head = x_long / m; 
			 x_long %= m;
			 m /= 10;
			 
			 // tail
			 long tail = 0;
			 tail = y_long / n % 10;
			 n *= 10;
			 
			 if(head != tail) return false;
		 }
		 
		 return true;
	 }
}
