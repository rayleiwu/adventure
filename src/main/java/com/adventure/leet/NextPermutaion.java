package com.adventure.leet;

/*
 *  https://leetcode.com/problems/next-permutation/
 * 
 * Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).

The replacement must be in-place, do not allocate extra memory.

Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
1,2,3 → 1,3,2
3,2,1 → 1,2,3
1,1,5 → 1,5,1

Explanation:

Now let's pick a number, for example, 24387651.
what is the next permutation? 24513678.
How can I get the answer?
First step: find the first ascending digit from the back of the number. 3 < 8 > 7 > 6 > 5 > 1. Then 3 is the digit.
Second step: swap that digit with the next big digit in following digits. Which one is the next big digit in 87651? 5! So swap them. Now the number becomes 24587631.
Third step: sort 87631 into 13678. The final answer is 24513678.

 */
public class NextPermutaion {
	public static void nextPermutation(int[] nums) {
		 if(nums.length<=1){
	          return;
	      }

	      int i= nums.length-1;

	      for(;i>=1;i--){
	         if(nums[i]>nums[i-1]){ //find first number which is smaller than it's after number
	             break;
	         }
	      }

	      if(i!=0){
	          swap(nums,i-1); //if the number exist,which means that the nums not like{5,4,3,2,1}
	      }

	      reverse(nums,i);    
    }
	
	private static void swap(int[] a,int i){
        for(int j = a.length-1;j>i;j--){
            if(a[j]>a[i]){
                int t = a[j];
                a[j] = a[i];
                a[i] = t;
                break;
            }
        }
    }
	
	private static void reverse(int[] a,int i){//reverse the number after the number we have found
        int first = i;
        int last = a.length-1;
        while(first<last){
            int t = a[first];
            a[first] = a[last];
            a[last] = t;
            first ++;
            last --;
        }
    }
}
