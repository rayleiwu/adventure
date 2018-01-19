package com.adventure.leet;

/*
 * https://leetcode.com/problems/count-primes/
 * 
 * Count the number of prime numbers less than a non-negative number, n.
 */
public class CountPrime {
	
	
	// idea: keep an array to store all the numbers that is a prime or not
	//       use "Prime * anything = NonPrime" to do the calculation
	
	public static int countPrimes(int n) {
        boolean[] notPrime = new boolean[n];
         
        int count = 0;
        
        for (int i = 2; i < n; i++) {
            
            // if it is a Prime ...
            if (!notPrime[i]) {
                count++;
                
                // then, A Prime * anything = NonPrime ...
                for (int j = 2; i * j < n; j++) {
                    notPrime[i*j] = true;
                }
            }
        }

        return count;
    }
}
