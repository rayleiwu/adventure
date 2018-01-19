package com.adventure.util;

public class LNode {

	private int data;
	private LNode prev;
	private LNode next;
	
	public LNode(int data, LNode prev, LNode next) {
		
		this.data = data;
		this.prev = prev;
		this.next = next;
	}
	
	public LNode() {
		// TODO Auto-generated constructor stub
	}

	public int getData() {
		return this.data;
	}
	
	public void setData(int value) {
		this.data = value;
	}
	
	public LNode getPrev() {
		return this.prev;
	}
	
	public void setPrev(LNode value) {
		this.prev = value;

	}
	
	public LNode getNext() {
		return this.next;
	}
	
	public void setNext(LNode value) {
		this.next = value;
	}
}
