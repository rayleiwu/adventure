package com.adventure.sort;

import com.adventure.util.Utility;

public class HeapSort {

	public static void sort(int[] a) {
		heapBuild(a); // O(n*log(n))
		
		for(int i=a[0];i>1;i--) { // a[0] stores heapSize
			Utility.swap(a, i, 1); // move the largest to end
			a[0]--; // shink the heap
			heapify(a, 1); // fix the heap property
		}
	}
	
	public static void heapBuild(int[] a) {
		
		// a[0] is reserved for heapSize
		// a[0] = a.length - 1;
		
		for(int i = a[0] / 2; i > 0; i --) {
			heapify(a, i);
		}
	}
	
	public static void heapInsert(int[] a, int value) {
		// we need add space to a[] if need
		
		// 
		
		a[0] ++; // a[0] is reserved for heap size
		a[a[0]] = value; // append the new value to then end of the heap
		
		int current = a[0];
		
		while(parent(current) >= 1 && a[parent(current)] < a[current]) {
			Utility.swap(a, parent(current), current);
			current = parent(current);
		}
	}
	
	public static void heapDelete(int[] a, int i) {
		// unfinished
	}

	// Note: a[0] stores heapSize
	private static void heapify(int[] a, int i) {
		if(a == null || a.length <= 2) return;
		
		int heapSize = a[0];
		int iMax = i;
		int left = left(i);
		int right = right(i);
		
		if(left <= heapSize && a[left] > a[iMax]) {
			iMax = left;
		}
		
		if(right <= heapSize && a[right] > a[iMax]) {
			iMax = right;
		}
		
		if(iMax != i) {
			Utility.swap(a, i, iMax);
			heapify(a, iMax);
		}
	}
	
	private static int parent(int i) {
		return i / 2;
	}
	
	private static int left(int i) {
		return 2 * i;
	}
	
	private static int right(int i) {
		return left(i) + 1;
	}
}
