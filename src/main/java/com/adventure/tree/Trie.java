package com.adventure.tree;

import com.adventure.util.TrieNode;

public class Trie {
	public static TrieNode build(String[] strings) {
		TrieNode root = new TrieNode();
		
		for(String s : strings) {
			add(root, s);
		}
		
		return root;
	}
	
	public static void add(TrieNode root, String s) {
		
		TrieNode node = root;
		
		for(char c : s.toCharArray()) {
			
			node.count ++;
			
			if(!node.children.containsKey(c)) {
				TrieNode childNode = new TrieNode();
				node.children.put(c, childNode);
				node = childNode;
			} else {
				node = node.children.get(c);
			}
		}
	}
	
	public static void print(TrieNode root) {
		print("", root);
	}

	public static void print(String prefix, TrieNode root) {
		
		if(root == null) return;
		
		for(Character key : root.children.keySet()){
			String temp = String.format("%s%s", prefix, key);
			System.out.printf("%s\n", temp);
			
			print(temp, root.children.get(key));
		}
	}
}
