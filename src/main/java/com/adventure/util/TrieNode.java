package com.adventure.util;

import java.util.HashMap;
import java.util.Map;

public class TrieNode {
	public int count = 0;
	public Map<Character, TrieNode> children = new HashMap<>();
}
