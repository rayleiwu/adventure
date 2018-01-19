package com.adventure.util;

public class Utility {

	public static void swap(int[] a, int j, int i) {
		int value = a[i];
		a[i] = a[j];
		a[j] = value;
		
	}
	
	public static void displayMatrix(int[][] a) {
		if(a == null) return;
		
		for(int i=0;i<a.length;i++) {
			for(int j=0;j<a[i].length;j++) {
				System.out.printf("%3d", a[i][j]);
			}
			System.out.printf("%s", "\n");
		}
	}
	
	public static void displayMatrix(String[][] a) {
		if(a == null) return;
		
		for(int i=0;i<a.length;i++) {
			for(int j=0;j<a[i].length;j++) {
				System.out.printf("%4s ", a[i][j]);
			}
			System.out.printf("%s", "\n");
		}
	}
	
	public static void displayMatrix(char[][] a) {
		if(a == null) return;
		
		for(int i=0;i<a.length;i++) {
			for(int j=0;j<a[i].length;j++) {
				System.out.printf("%c ", a[i][j]);
			}
			System.out.printf("%s", "\n");
		}
	}
	
	public static void displayTimelines(int[] start, int[] finish) {
		for(int i=0;i<finish.length;i++) {
			
			if(start[i] == 0 && finish[i] == 0 || start[i] == finish[i]) {
				//System.out.print("\n");
			} else {
				System.out.printf("%" + String.valueOf(start[i]+1) + "s%d%s%d\n" , " ", start[i], new String(new char[finish[i]-start[i] - 1]).replace("\0", "-"), finish[i]);
			}
		}
	}
}
