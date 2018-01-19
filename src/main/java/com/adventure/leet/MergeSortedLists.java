package com.adventure.leet;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

import com.adventure.util.ListNode;

public class MergeSortedLists {
	public static ListNode mergeKLists(ListNode[] lists) {
        
		// corner cases
		if(lists == null || lists.length == 0) return null;
		
		// build Priority Queue with each element pointing to head of each lists
		Queue<ListNode> queue = new PriorityQueue<>(lists.length, new Comparator<ListNode>() {
			@Override
			public int compare(ListNode n1, ListNode n2) {
				if(n1.val > n2.val) return 1;
				if(n1.val < n2.val) return -1;
				return 0;
			}
		});
		
		for(ListNode list : lists) {
			if(list != null) {
				queue.offer(list);
			}
		}
		
		// deQueue until it's empty
		ListNode head = new ListNode(-1);
		ListNode tail = head;
		
		while(!queue.isEmpty()) {
			ListNode temp = queue.poll();
			tail.next = temp;
			tail = tail.next;
			
			// enQueue the rest after first element is picked
			if(tail.next!= null) {
				queue.offer(tail.next);
			}
		}
		
		return head.next;
    }
}
