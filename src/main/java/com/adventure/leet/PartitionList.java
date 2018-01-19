package com.adventure.leet;

import com.adventure.util.ListNode;

/**
 * https://leetcode.com/problems/partition-list/
 * @author hduser
 *
 
  Given a linked list and a value x, partition it such that all nodes less than x come
  before nodes greater than or equal to x.

You should preserve the original relative order of the nodes in each of the two partitions.

For example,
Given 10->40->30->20->50->20 and x = 30,
return 10->20->20->40->30->50.

 */
public class PartitionList {

	// mine!
	public static ListNode partition(ListNode head, int x) {
	    // IDEA: first to find the right spot for inserting all the smaller nodes, then just do insert!
		
		ListNode insertPrev = null;
		ListNode insert = head;
		
		// step 1: first, let's find the Node >= x
		while(insert != null && insert.val < x) {
			insertPrev = insert;
			insert = insert.next;
		}
		
		// step 2: let's insert the rest nodes whose value < x into before the node we found in step 1
		if(insert != null && insert.next != null) {
	
			ListNode restPrev = null;
			ListNode rest = null;
			
			restPrev = insert; 
			rest = insert.next;
			
			while(rest != null) {
				if(rest.val >= x) {
					restPrev = rest;
					rest = rest.next;
				} else {
					// found a Node.
					// step 1: preserve the node to be deleted
					ListNode delete = rest;
					
					// step 2: delete the node
					restPrev.next = rest.next;
					rest = restPrev == null ? null : restPrev.next;
					
					// step 3: insert
					delete.next = insert;
					
					if(insertPrev == null) {
						head = delete;
						insertPrev = head;
					} else {
						insertPrev.next = delete;
						insertPrev = insertPrev.next;
					}
				}
			}
		}
		
		return head;
	}
	
	//someones
	public static ListNode partition2(ListNode head, int x) {
	    ListNode dummy1 = new ListNode(0), dummy2 = new ListNode(0);  //dummy heads of the 1st and 2nd queues
	    ListNode curr1 = dummy1, curr2 = dummy2;      //current tails of the two queues;
	    
	    while (head!=null){
	        if (head.val<x) {
	            curr1.next = head;
	            curr1 = head;
	        }else {
	            curr2.next = head;
	            curr2 = head;
	        }
	        head = head.next;
	    }
	    
	    curr2.next = null;          //important! avoid cycle in linked list. otherwise u will get TLE.
	    curr1.next = dummy2.next;
	    
	    return dummy1.next;
	}

}
