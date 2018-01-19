package com.adventure.leet.easy;

public class ReverseInteger {
	public static int reverse(int x) {
		
		// Work with longs instead of int
		long x_long = x;
		
		// sign of the number
        long sign = x_long >= 0 ? 1 : -1;
        x_long = Math.abs(x_long);
        
        // digits of the number
        long n = 1;

        long temp = x_long;
        while(temp / 10 > 0) {
        	n *=10;
        	temp = temp / 10;
        }
        
        // build reversed number
        long r = 0;
        long i = n;
        
        while(i >= 1) {
        	long d = (n / i) * (x_long / i);
        	
        	if(d > Integer.MAX_VALUE || -1 * d < Integer.MIN_VALUE ) return 0; // overflow
        	
        	r = r + d;
        	
        	if(r > Integer.MAX_VALUE || -1 * r < Integer.MIN_VALUE ) return 0; // overflow
        	
        	x_long = x_long % i;
        	i /= 10;
        }
        
        // apply the sign
        return (int)(r * sign);
    }
}
