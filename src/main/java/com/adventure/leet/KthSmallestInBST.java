package com.adventure.leet;

import java.util.Stack;

import com.adventure.util.TNode;

/*
 * https://leetcode.com/problems/kth-smallest-element-in-a-bst/
 * 
 *  Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.

	Note: 
	You may assume k is always valid, 1 ≤ k ≤ BST's total elements.
 * 
 */
public class KthSmallestInBST {

	 //This is just a Amended DFS in-order traversal
	 public static int kthSmallest(TNode root, int k) {
	        Stack<TNode> st = new Stack<>();

            // always stay on the left!
	        TNode n0 = root;
	        while (n0 != null) {
	            st.push(n0);
	            n0 = n0.getLeft();
	        }

	        while (k != 0) {
	        	TNode n = st.pop();
	            
	        	k--;

                // This line is the only amendment!
	            if (k == 0) return n.getData();

                // always stay on the left!
				n0 = n.getRight();
	            while (n0 != null) {
	                st.push(n0);
					n0 = n0.getLeft();
	            }
	        }

	        return -1; // never hit if k is valid
	  }
}
