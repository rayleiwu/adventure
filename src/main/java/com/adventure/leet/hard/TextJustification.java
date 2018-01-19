package com.adventure.leet.hard;

import java.util.ArrayList;
import java.util.List;

/*
 * https://leetcode.com/problems/text-justification/
 * 
 * Given an array of words and a length L, format the text such that each line has exactly L characters and is fully (left and right) justified.

You should pack your words in a greedy approach; that is, pack as many words as you can in each line. Pad extra spaces ' ' when necessary so that each line has exactly L characters.

Extra spaces between words should be distributed as evenly as possible. If the number of spaces on a line do not divide evenly between words, the empty slots on the left will be assigned more spaces than the slots on the right.

For the last line of text, it should be left justified and no extra space is inserted between words.

For example,
words: ["This", "is", "an", "example", "of", "teaxt", "justification."]
L: 16.

Return the formatted lines as:
[
   "This    is    an",
   "example  of text",
   "justification.  "
]
Note: Each word is guaranteed not to exceed L in length.

click to show corner cases.

Corner Cases:
A line other than the last line might contain only one word. What should you do in this case?
In this case, that line should be left-justified.
 * 
 * 
 */
public class TextJustification {

	public static List<String> fullJustify(String[] words, int maxWidth) {
		if(words == null) return null;
		
		List<String> res = new ArrayList<>();
		
		if(words.length == 0) return res;
		
		int i = 0;
		while(i < words.length) {
			int count = 0;
			int sum = 0;
			String s = "";
			
			// 1) find out how many words for this line
			while(i < words.length && sum < maxWidth + 1) {
				if(sum + words[i].length() >= maxWidth + 1) { // no need to add space
					break;
				} else {
					count++; // add more words
					sum += words[i].length(); 
					sum++; // add extra space between words
					i++;
				}
			}
			
			
			// 2) now, concatenate the words
			if(count == 1 || i > words.length - 1) { // where there is one word or when we are at the last word,
													 // we do left justification
				for(int k = i - count; k < i; k++) {
					s += words[k];
					if(k == i-1) break; // this is the last word
					s+=" "; // add a space between words
				}
				
				// append the rest missing spaces
				while(s.length() < maxWidth) {
					s += " ";
				}
				
			} else { // here we do middle justification
				int avespace = (maxWidth - sum + 1) / (count - 1);
				int reminder = (maxWidth - sum + 1) % (count - 1);
				
				for(int k = i - count; k < i; k++) {
					s += words[k];
					
					if(k == i-1) break; //this is the last word
					
					// spaces must be distributed evenly
					for(int j=0;j<=avespace;j++) {
						s+= " ";
					}
					
					// when number of spaces are not divided evenly...
					if(k < i - count + reminder) {
						s+= " ";
					}
				}
			}
			
			res.add(s);
		}
		
		return res;
    }
}
