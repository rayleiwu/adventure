package com.adventure.leet.hard;

import java.util.ArrayList;
import java.util.List;

import com.adventure.util.Interval;

/*
 * https://leetcode.com/problems/insert-interval/
 * 
 * Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).

You may assume that the intervals were initially sorted according to their start times.

Example 1:
Given intervals [1,3],[6,9], insert and merge [2,5] in as [1,5],[6,9].

Example 2:
Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in as [1,2],[3,10],[12,16].

This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].
 * 
 */
public class InsertInterval {
    public static List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        
    	if(newInterval == null) return intervals;
    	
    	if(intervals == null) intervals = new ArrayList<Interval>();
    	
    	List<Interval> result = new ArrayList<>();
    	
    	for(Interval item : intervals) {
    		if(newInterval == null || item.end < newInterval.start) { // new item is after current one with no overlapping. Simply add the current
    			result.add(item);
    		} else if(item.start > newInterval.end) { // new item is before current one with no overlapping
    			result.add(newInterval);
    			result.add(item);
    			newInterval = null; // IMPORTANT: we "delete" newInterval after we added it to final list
    		} else { // when there is a overlapping.. we need merge! and we won't add it to final list until the loop ended
    			newInterval.start = Math.min(newInterval.start, item.start);
    			newInterval.end = Math.max(newInterval.end, item.end);
    		}
    	}
    	
    	// finally, we add newInterval to the list
    	if(newInterval != null) {
    		result.add(newInterval);
    	}
    	
    	return result;
    }
}
