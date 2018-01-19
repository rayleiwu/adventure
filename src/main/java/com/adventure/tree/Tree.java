package com.adventure.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.adventure.util.TNode;

public class Tree {
	
	public static TNode search(TNode root, int value) {
		
		if(root == null) return null;
		
		if(root.getData() == value) return root;
		
		if(root.getData() > value) {
			return search(root.getLeft(), value);
		} else {
			return search(root.getRight(), value);
		}
	}
	
    public static TNode[] search(TNode predecessor, TNode root, int value) {
		
		if(root == null) {
			TNode[] result = {predecessor, null};
			return result;
		}
		
		if(root.getData() == value) {
			TNode[] result = {predecessor, root};
			return result;
		}
		
		if(root.getData() > value) {
			return search(root, root.getLeft(), value);
		} else {
			return search(root, root.getRight(), value);
		}
	}
	
	public static TNode min(TNode root) {
		
		TNode curr = root;
		
		while(curr.getLeft() != null) {
			curr = curr.getLeft();
		}
		
		return curr;
	}
	
	public static TNode max(TNode root) {
		TNode curr = root;
		
		while(curr.getRight() != null) {
			curr = curr.getRight();
		}
		
		return curr;
	}
	
	public static void delete(TNode root, int valueToDelete) {
		
		TNode nodeToDelete = search(root, valueToDelete);
		
		if(nodeToDelete == null) return;
		
		if(nodeToDelete.getRight() != null) {
			TNode rightMin = min(nodeToDelete.getRight());
	
			if(rightMin != null) {
				nodeToDelete.setData(rightMin.getData());
				
				if(rightMin.getParent() != null) {
					if(rightMin.getParent().getLeft().equals(rightMin)) {
						rightMin.getParent().setLeft(null);
					} else {
						rightMin.getParent().setRight(null);
					}
				}

			}
		} else if(nodeToDelete.getLeft() != null){
			TNode leftMax = max(nodeToDelete.getLeft());
			if(leftMax != null) {
				nodeToDelete.setData(leftMax.getData());
				if(leftMax.getParent() != null) {
					if(leftMax.getParent().getLeft().equals(leftMax)) {
						leftMax.getParent().setLeft(null);
					} else {
						leftMax.getParent().setRight(null);
					}
				}
			}
		}
	}
	
	// me -> left -> right
	public static void traversalPreorder(TNode root) {
		if(root == null) return;
		
		System.out.printf("%d ", root.getData());
		traversalPreorder(root.getLeft());
		traversalPreorder(root.getRight());
	}
	
	// left -> me -> right
	public static void traversalInorder(TNode root) {
		if(root == null) return;
		
		traversalInorder(root.getLeft());
		System.out.printf("%d ", root.getData());
		traversalInorder(root.getRight());
	}
	
	// left -> right -> me
	public static void traversalPostorder(TNode root) {
		if(root == null) return;
		
		traversalPostorder(root.getLeft());
		traversalPostorder(root.getRight());
		System.out.printf("%d ", root.getData());
	}
	
	public static void traversalLevelorder(TNode root) {
		
		if(root == null) return;
		
		Queue<TNode> q = new LinkedList<TNode>();
		
		q.add(root);
		
		while(!q.isEmpty()) {
			TNode node = q.remove();
			System.out.printf("%d ", node.getData());
			
			if(node.getLeft() != null) q.add(node.getLeft());
			if(node.getRight() != null) q.add(node.getRight());
		}
	}
	
	public static TNode buildBST(int[] a) {
		
		TNode root = null;
		
		for(int i=0;i<a.length;i++) {
			if(root == null) {
				root = new TNode(a[i], null, null, null);
			} else {
				insert(root, a[i]);
			}
		}
		
		return root;
	}
	
	public static TNode successor(TNode node) {
		if(node == null) return null;
		
		if(node.getRight() != null) return min(node.getRight());
		
		TNode p = node.getParent();
        while (p != null && node == p.getRight()) {
            node = p;
            p = p.getParent();
        }
      
		return p;
	}
	
	private static void insert(TNode node, int value) {
		
		if(value < node.getData()) {
			if(node.getLeft() == null) {
				node.setLeft(new TNode(value, null, null, node));
			} else {
				insert(node.getLeft(), value);
			}
		} else {
			if(node.getRight() == null) {
				node.setRight(new TNode(value, null, null, node));
			} else {
				insert(node.getRight(), value);
			}
		}
	}
}
