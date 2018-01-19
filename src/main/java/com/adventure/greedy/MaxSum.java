package com.adventure.greedy;

import com.adventure.util.MaxObject;

public class MaxSum {
	public void maxProfit(int[] stockPrices) {
		
		if(stockPrices == null || stockPrices.length == 0) return;
		
		int[] delta = new int[stockPrices.length];

		// calc delta
		delta[0] = 0;

		for (int i = 1; i <= stockPrices.length - 1; i++) {
			delta[i] = stockPrices[i] - stockPrices[i - 1];
		}

		// greedy 
		MaxObject max = new MaxObject(Integer.MIN_VALUE, -1, -1);
		MaxObject maxSofar = new MaxObject(0, 0, -1);
		
		for(int i=0;i<delta.length;i++) {
			maxSofar.setMax(maxSofar.getMax() + delta[i]);
			maxSofar.setEnd(i);
			
			// log the max sum
			if(maxSofar.getMax() > max.getMax()) {
				max.setMax(maxSofar.getMax());
				max.setStart(maxSofar.getStart());
				max.setEnd(maxSofar.getEnd());
			}
			
			// if maxSofar <= 0, reset
			if(maxSofar.getMax() <= 0) {
				maxSofar.setMax(0);
				maxSofar.setStart(i+1);
				maxSofar.setEnd(-1);
			}
		}
		
		// show result
		System.out.printf("max: %d from: %d to %d\n", max.getMax(),
				max.getStart(), max.getEnd());

		// breakpoint
		@SuppressWarnings("unused")
		int breakpoint = 0;
	}
}
