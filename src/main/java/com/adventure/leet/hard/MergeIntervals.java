package com.adventure.leet.hard;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.ListIterator;

import com.adventure.util.Interval;

/*
 * https://leetcode.com/problems/merge-intervals/
 *
 * solution: https://leetcode.com/discuss/33434/a-clean-java-solution
 * 
 * Given a collection of intervals, merge all overlapping intervals.

For example,
Given [1,3],[2,6],[8,10],[15,18],
return [1,6],[8,10],[15,18].
 * 
 */
public class MergeIntervals {
	public static List<Interval> merge(List<Interval> intervals) {
		// edge cases
		if(intervals == null || intervals.isEmpty()) return intervals;
		
		// sort
		Collections.sort(intervals, new Comparator<Interval>() {
			public int compare(Interval i1, Interval i2) {
				if(i1.start != i2.start) return i1.start - i2.start;
				
				return i1.end - i2.end;
			}
		});
		
		// merge the overlapped item to the its predecessor, delete the overlapped item
		ListIterator<Interval> it = intervals.listIterator();
		Interval current = it.next();
		
		while(it.hasNext()) {
			Interval next = it.next();
			
			if(next.start <= current.end) {
				// merge and delete
				current.end = Math.max(current.end, next.end);
				it.remove(); // ???
			} else {
				current = next;
			}
		}
		
		return intervals;
    }
}
