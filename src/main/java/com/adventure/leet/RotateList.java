package com.adventure.leet;

import com.adventure.util.ListNode;

/*
 * https://leetcode.com/problems/rotate-list/
 * 
 * Given a list, rotate the list to the right by k places, where k is non-negative.

For example:
Given 1->2->3->4->5->NULL and k = 2,
return 4->5->1->2->3->NULL.
 * 
 */
public class RotateList {

	public static ListNode rotateRight(ListNode head, int k) {
		
		if(head == null || head.next == null || k <= 0) return head;
		
		ListNode p = head;
		ListNode adv = head;
		
		// move fast pointer by k steps
		while(adv.next != null && k > 0) {
			adv = adv.next;
			k--;
		}
		
		if(k == 0) {
			// now move both pointers
			while(adv.next != null) {
				adv = adv.next;
				p = p.next;
			}
			
			// re-link
			adv.next = head;
			head = p.next;
			p.next = null;
			
		} //else if(k > 0) {} // list size < k 
		
		return head;
    }
}
