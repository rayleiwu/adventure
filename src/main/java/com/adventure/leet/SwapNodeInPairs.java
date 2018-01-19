package com.adventure.leet;

import com.adventure.util.ListNode;

/*
 * 
 * https://leetcode.com/problems/swap-nodes-in-pairs/
 * Given a linked list, swap every two adjacent nodes and return its head.

For example,
Given 1->2->3->4, you should return the list as 2->1->4->3.

Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.
 * 
 */
public class SwapNodeInPairs {
	 public static ListNode swapPairs(ListNode head) {
		 
		 // create a dummy node
		 ListNode dummy = new ListNode(-1);
		 dummy.next = head;
		 
		 // move 3 pointer together until all or two of them are null
		 ListNode p1 = dummy;
		 ListNode p2 = p1 != null ? p1.next : null;
		 ListNode p3 = p2 != null? p2.next: null;
		 
		 while(p2 != null && p3 != null) {
			 //swap p2 & p3
			 p1.next = p3;
			 p2.next = p3.next;
			 p3.next = p2;
			 
			 // p1 moves two steps forward
			 p1 = p1.next;
			 p1 = p1 != null ? p1.next : null;
			 p2 = p1 != null ? p1.next : null;
			 p3 = p2 != null? p2.next: null;
		 }
		 
		 return dummy.next;
	 }
}
