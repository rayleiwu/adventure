package com.adventure.greedy;

import com.adventure.util.Utility;

public class ActivitySelector {
	
	// https://www.youtube.com/watch?v=U8QPW7-SqyM
	// problem to solve: find max number of meetings I can attend
	public static void Calculate(int[] start, int[] finish) {
		
		int[] startSelected = new int[start.length];
		int[] finishSelected = new int[finish.length]; // arrays must be sorted by finish points
		
		// steps:
		//     1) sort by finish points (already done)
		//     2) select the first activity
		//     3) select next activity whose START >= FINISH of previously selected activity
		//     4) REPEAT step 3 till all activities are visited
		
		// k stores current selected
		int k = 0;
				
		// select the first activity
		startSelected[k] = start[0];
		finishSelected[k] = finish[0];
		
		for(int i=1; i<finish.length;i++) {
			// select next activity whose START >= FINISH of previously selected activity
			if(start[i] >= finishSelected[k]) {
				k++;
				startSelected[k] = start[i];
				finishSelected[k] = finish[i];
			}
		}
		
		System.out.println("\nActivities:\n");
		Utility.displayTimelines(start, finish);
		System.out.println("\nSelected Activities:\n");
		Utility.displayTimelines(startSelected, finishSelected);
		
	}
}
