package com.adventure.sort;

import com.adventure.util.Utility;

// divide and conquer
public class QuickSort {

	public static void sort(int[] a) {
		sort(a, 0, a.length - 1);
	}
	
	private static void sort(int[] a, int left, int right) {

		int i = left;
        int j = right;
        // calculate pivot number, I am taking pivot as middle index number
        int pivot = a[left+(right-left)/2];
        
        // Divide into two arrays
        while (i <= j) {
            while (a[i] < pivot) {
                i++;
            }
            while (a[j] > pivot) {
                j--;
            }
            if (i <= j) {
                Utility.swap(a, i, j);
                //move index to next position on both sides
                i++;
                j--;
            }
        }
        
        // call quickSort() method recursively
        if (left < j)
            sort(a, left, j);
        
        if (i < right)
            sort(a, i, right);
  	}
}
