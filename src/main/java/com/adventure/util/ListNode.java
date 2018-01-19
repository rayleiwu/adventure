package com.adventure.util;

public class ListNode {
    public int val;
    public ListNode next;
    public ListNode(int x) { val = x; }
    
    public static ListNode build(int[] a) {
    	ListNode root = null;
    	
    	for(int i=a.length-1;i>=0;i--) {
    		ListNode temp = new ListNode(a[i]);
    		temp.next = root;
    		root = temp;
    	}
    	
    	return root;
    }
    
    public void print() {
    	System.out.print(toString());
    }
    
    public String toString() {
    	ListNode temp = this;
    	StringBuilder sb = new StringBuilder();
    	
    	while(temp != null) {
    		sb.append(String.format("%d->", temp.val));
    		temp = temp.next;
    	}
    	
    	return sb.toString();
    }
}
