package com.adventure.leet.easy;

import com.adventure.util.ListNode;

/*
 * https://leetcode.com/problems/merge-two-sorted-lists/
 * Merge two sorted linked lists and return it as a new list. 
 * The new list should be made by splicing together the nodes of the first two lists.
 * 
 */
public class MergeTwoSortedList {

	   public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		    ListNode result = null;
	        ListNode l3 = result;
	        
	        while(l1 != null || l2 != null) {
	        	int value;
	        	
	        	if(l1 == null){
	        		value = l2.val;
	        		l2 = l2.next;
	        	} else if(l2 == null) {
	        		value = l1.val;
	        		l1 = l1.next;
	        	} else {
	        		if(l1.val < l2.val) {
	        			value = l1.val;
	        			l1 = l1.next;
 	        		} else {
 	        			value = l2.val;
 	        			l2 = l2.next;
 	        		}
	        	}
	        	
	        	ListNode node = new ListNode(value);
	        	
	        	if(result == null) {
	        		result = node;
	        		l3 = result;
	        	} else {
	        		l3.next = node;
	        		l3 = l3.next;
	        	}
	        }
	        
	        return result;
	   }
}
