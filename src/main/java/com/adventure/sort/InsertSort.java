package com.adventure.sort;

import com.adventure.util.Utility;

public class InsertSort {

	public static void sort(int[] data) {
		
		if(data == null || data.length <= 1) return;
		
		for(int i=1; i<data.length - 1; i++) {
			int value = data[i];
			
			for(int j=i-1;j>=0;j--) {
				if(data[j] > value) {
					Utility.swap(data, j, j+1);
				} else {
					break;
				}
			}
		}
		
	}
}
