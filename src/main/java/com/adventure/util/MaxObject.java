package com.adventure.util;

public class MaxObject {
	private int max;
	private int maxStart;
	private int maxEnd;

	public MaxObject(int max, int maxStart, int maxEnd) {
		this.max = max;
		this.maxStart = maxStart;
		this.maxEnd = maxEnd;
	}

	public int getMax() {
		return this.max;
	}

	// getters
	public int getStart() {
		return this.maxStart;
	}

	public int getEnd() {
		return this.maxEnd;
	}
	
	// setters 
	public void setMax(int data) {
		this.max = data;
	}

	public void setStart(int data) {
		this.maxStart = data;
	}

	public void setEnd(int data) {
		this.maxEnd = data;
	}
}
