package com.adventure.util;

public class TNode {

	private int data;
	private TNode left;
	private TNode right;
	private TNode parent;
	
	public TNode(int data, TNode left, TNode right, TNode parent) {
		
		this.data = data;
		this.left = left;
		this.right = right;
		this.parent = parent;
	}
	
	public TNode() {
		// TODO Auto-generated constructor stub
	}

	public int getData() {
		return this.data;
	}
	
	public void setData(int value) {
		this.data = value;
	}
	
	public TNode getLeft() {
		return this.left;
	}
	
	public void setLeft(TNode value) {
		this.left = value;

	}
	
	public TNode getRight() {
		return this.right;
	}
	
	public void setRight(TNode value) {
		this.right = value;
	}
	
	public TNode getParent() {
		return this.parent;
	}
	
	public void setParent(TNode value) {
		this.parent = value;
	}
}
