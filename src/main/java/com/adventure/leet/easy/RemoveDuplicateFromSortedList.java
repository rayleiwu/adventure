package com.adventure.leet.easy;

import com.adventure.util.ListNode;

/***
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list/?sort=votes
 * @author hduser
 *
 *Given a sorted linked list, delete all duplicates such that each element appear only once.

For example,
Given 1->1->2, return 1->2.
Given 1->1->2->3->3, return 1->2->3.

 */

public class RemoveDuplicateFromSortedList {
	public class Solution {
	    public ListNode deleteDuplicates(ListNode head) {
	        if(head == null || head.next == null) return head;
	        
	        head.next = deleteDuplicates(head.next);
	        
	        return head.val == head.next.val ? head.next : head;
	    }
	}
}
