package com.adventure.leet;

import com.adventure.util.ListNode;

/*
 https://leetcode.com/problems/add-two-numbers/
 You are given two linked lists representing two non-negative numbers. 
 The digits are stored in reverse order and each of their nodes contain a single digit. 
 Add the two numbers and return it as a linked list.

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
 
 */
public class TwoNum {
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		
		ListNode root = null;
		ListNode temp1 = l1;
		ListNode temp2 = l2;
		ListNode temp3 = root;
		
		int single = 0;
		int tens = 0; // 0 or 1
		int num1 = 0;
		int num2 = 0;
		
		while(temp1 != null || temp2 != null) {
			num1 = (temp1 == null ? 0 : temp1.val);
			num2 = (temp2 == null ? 0 : temp2.val);
			
			single = (num1 + num2 + tens) % 10;
			tens = (num1 + num2 + tens) / 10;
			
			ListNode tempNode = new ListNode(single);
			
			if(root == null) {
				root = tempNode;
				temp3 = root;
				
			} else {
				temp3.next = tempNode;
				temp3 = temp3.next;
			}
			
			temp1 = temp1 != null ? temp1.next : null;
			temp2 = temp2 != null ? temp2.next : null;
		}
		
		if(tens == 1) {
			ListNode tempNode = new ListNode(tens);
			
			if(root == null) {
				root = tempNode;
			} else {
				temp3.next = tempNode;
			}
		}
		
        return root;
    }
}
