package com.adventure.leet.easy;

import com.adventure.util.ListNode;

/*
 * 
 * https://leetcode.com/problems/remove-nth-node-from-end-of-list/
 * Given a linked list, remove the nth node from the end of list and return its head.

For example,

   Given linked list: 1->2->3->4->5, and n = 2.

   After removing the second node from the end, the linked list becomes 1->2->3->5.
 */
public class RemoveNthNodeFromLinkedList {
	
	public static ListNode removeNthFromEnd1Iteration(ListNode head, int n) {
		if(head == null || n == 0) return head;
		
		ListNode slow, fast;
		
		slow = fast = head;
		
		while(fast != null && (n--) > 0) { 
			fast = fast.next; 
		} 
		
		if(fast == null) return fast;
		
		// now the slow starts move
		while(fast.next != null) {
			fast = fast.next;
			slow = slow.next;
		}
		
		// delete slow
		if(slow == head) {
			head = head.next;
		} else {
			if(slow.next != null) {
				slow.next = slow.next.next;
			}
		}
		
		return head;
	} 
	
	public static ListNode removeNthFromEnd(ListNode head, int n) {
		
		int count = 0;
		
		ListNode l = head;
		
		while(l != null) {
			count++;
			l=l.next;
		}
		
		return removeNthFromBegin(head, count - n + 1);
	}
	
	
	public static ListNode removeNthFromBegin(ListNode head, int n) {
		
		//need take care n=0,1
		if(n == 0 || head == null) return head;
		if(n == 1) {
			head = head.next;
			return head;
		}
	
        ListNode i = head;
        int m = 1;
        
        while(i != null && m < n - 1) { 
        	i=i.next;
        	m++;
        }
        
        if(i != null && i.next != null) {
        	ListNode j = i.next;
        	i.next = j.next;
        }
        
        // return
        return head;
    }
}
