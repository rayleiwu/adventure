package com.adventure.ll;

import com.adventure.util.LNode;

public class LinkedList {

	public static LNode delete(LNode head, int valueToDelete) {
		
		LNode prev = null;
		LNode temp = head;
		
		while(temp != null) {
			if(temp.getData() == valueToDelete) {
				// 2 cases
				if(prev == null && temp != null) {
					head = head.getNext();
					temp = head;
				} else { // prev != null && temp != null
					prev.setNext(temp.getNext());
					temp = temp.getNext();
				}
			}
			
			if(temp != null) {
				prev = temp;
				temp = temp.getNext();
			}
		}
		
		return head;
	}
	
	public static LNode insert(LNode head, int valueToFind, int newValue) {
		LNode temp = head;
		LNode prev = null;
		
		while(temp != null) {
			
			if(temp.getData() == valueToFind) {
				break;
			}
			
			prev = temp;
			temp = temp.getNext();
		}
		
		// 4 cases
		if(prev == null && temp == null) {
			head = new LNode(newValue, null, null); 
		} else if(prev == null && temp != null) {
			prev = new LNode(newValue, null, null); 
			prev.setNext(temp);
			head = prev;
		} else if(prev != null && temp == null) {
			temp = new LNode(newValue, null, null); 
			prev.setNext(temp);
		} else { // prev != null && temp != null
			LNode newNode = new LNode(newValue, null, null); 
			prev.setNext(newNode);
			newNode.setNext(temp);
		}
		
		return head;
	}
	
	public static LNode search(LNode head, int value) {
		LNode temp = head;
		
		while(temp != null) {
			if(temp.getData() == value) {
				break;
			}
			
			temp = temp.getNext();
		}
		
		return temp;
	}
	
	
	public static void print(LNode head) {
		LNode temp = head;
		
		while(temp != null) {
			if(temp.getNext() == null) {
				System.out.printf("%d\n", temp.getData());
			} else {
				System.out.printf("%d,", temp.getData());
			}
			
			temp = temp.getNext();
		}
	}
	
	
	public static LNode reverse(LNode head) {
		
		LNode newHead = null;
		LNode next = null;
		
		while(head != null) {
			next = head.getNext();
			
			head.setNext(newHead);
			newHead = head;
			
			head = next;
		}
		
		return newHead;
	}
	
	public static LNode build(int[] a) {
		LNode head = null;
		LNode tail = null;
		
		for(int i=0;i<a.length;i++) {
			LNode curr = new LNode();
			curr.setData(a[i]);
			
			if(head == null) {
				head = curr;
			} else {
				curr.setPrev(tail);
				tail.setNext(curr);
			}
			
			tail = curr;
		}
		
		return head;
		
	}
}
