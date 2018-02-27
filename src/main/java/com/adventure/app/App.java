package com.adventure.app;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.adventure.bit.IntToBit;
import com.adventure.dc.MaxSum;
import com.adventure.dp.Knapsack;
import com.adventure.dp.LCS;
import com.adventure.dp.RodCutting;
import com.adventure.greedy.ActivitySelector;
import com.adventure.hashing.TinyUrl;
import com.adventure.howto.zookeeper.DataAccess;
import com.adventure.leet.LongestStringNoRepeat;
import com.adventure.leet.easy.AddBinary;
import com.adventure.leet.easy.ClimbStairs;
import com.adventure.leet.easy.InStr;
import com.adventure.leet.easy.LongestCommonPrefix;
import com.adventure.leet.easy.MergeTwoSortedList;
import com.adventure.leet.easy.NthSequence;
import com.adventure.leet.easy.PalindromeNumber;
import com.adventure.leet.easy.PlusOne;
import com.adventure.leet.easy.RemoveDuplicatesFromSortedArray;
import com.adventure.leet.easy.RemoveElement;
import com.adventure.leet.easy.RemoveNthNodeFromLinkedList;
import com.adventure.leet.easy.ReverseInteger;
import com.adventure.leet.easy.RomanToInteger;
import com.adventure.leet.easy.StringToInteger;
import com.adventure.leet.easy.ValidParentheses;
import com.adventure.leet.easy.ValidSudoku;
import com.adventure.leet.easy.ZigzagConversion;
import com.adventure.leet.hard.EditDistance;
import com.adventure.leet.hard.FirstMissingPositive;
import com.adventure.leet.hard.InsertInterval;
import com.adventure.leet.hard.Jump;
import com.adventure.leet.hard.LongestValidParentheses;
import com.adventure.leet.hard.MergeIntervals;
import com.adventure.leet.hard.MinWindowSubstring;
import com.adventure.leet.hard.PatternComparison;
import com.adventure.leet.hard.SearchInRotatedSortedArray;
import com.adventure.leet.hard.SortedArrayMedian;
import com.adventure.leet.hard.SubstringOfConcatenationAllWords;
import com.adventure.leet.hard.TextJustification;
import com.adventure.leet.hard.TrappingRainWater;
import com.adventure.leet.hard.ValidateNumber;
import com.adventure.leet.CombinationSum;
import com.adventure.leet.CombinationSumUnique;
import com.adventure.leet.ContainerMaxWater;
import com.adventure.leet.DivideTwoIntegers;
import com.adventure.leet.FourSum;
import com.adventure.leet.GenerateParentheses;
import com.adventure.leet.GrayCode;
import com.adventure.leet.GroupAnagrams;
import com.adventure.leet.IntegerToRoman;
import com.adventure.leet.JumpGame;
import com.adventure.leet.LargetstNumber;
import com.adventure.leet.LongestPalindromicSubstring;
import com.adventure.leet.MergeSortedLists;
import com.adventure.leet.MinimumPathSum;
import com.adventure.leet.MultiplyStrings;
import com.adventure.leet.NextPermutaion;
import com.adventure.leet.PartitionList;
import com.adventure.leet.Permutations;
import com.adventure.leet.PermutationsGet;
import com.adventure.leet.PhoneNumberCombinations;
import com.adventure.leet.Power;
import com.adventure.leet.RotateImage;
import com.adventure.leet.RotateList;
import com.adventure.leet.Search2DMatrix;
import com.adventure.leet.SearchForRange;
import com.adventure.leet.SearchInsertPosition;
import com.adventure.leet.SetMatrixZeroes;
import com.adventure.leet.SimplifyPath;
import com.adventure.leet.SortColors;
import com.adventure.leet.Sqrt;
import com.adventure.leet.Subsets;
import com.adventure.leet.SubsetsDuplicate;
import com.adventure.leet.SwapNodeInPairs;
import com.adventure.leet.ThreeSum;
import com.adventure.leet.ThreeSumClosest;
import com.adventure.leet.TwoNum;
import com.adventure.leet.TwoSum;
import com.adventure.leet.UniquePaths;
import com.adventure.ll.LinkedList;
import com.adventure.multithreading.PrintDemo;
import com.adventure.multithreading.ThreadDemo;
import com.adventure.recursion.n2m;
import com.adventure.sort.HeapSort;
import com.adventure.sort.InsertSort;
import com.adventure.sort.QuickSort;
import com.adventure.tree.Tree;
import com.adventure.tree.TreePrinter;
import com.adventure.tree.Trie;
import com.adventure.util.Interval;
import com.adventure.util.LNode;
import com.adventure.util.ListNode;
import com.adventure.util.TNode;
import com.adventure.util.TrieNode;
import com.adventure.util.Utility;

@SpringBootApplication
@EnableScheduling
@ComponentScan(basePackages = {"com.adventure.howto.spring"})
public class App {

	public static void main(String[] args) {
		
		System.out.println("Hi let adventure begin! 1234567");
		
		
		//int i = 3;	System.out.println(i/2);
		
		// runHowTo();
		// runBit();
		// runDc();
		// runDp();
		// runGreedy();
		 runHashing();
		// runLl();
		// runRecursion();
		// runSort();
		// runTree();
		// runDp();
		// runTree();
		// runJava8();
	
		// runLeet();
		
		
		//double a = Math.random();
		
		//runMultiThreading();
		
	}
	
	private static void runMultiThreading() {
		showCategory("Multi Threading ...");

		PrintDemo PD = new PrintDemo();

		ThreadDemo T1 = new ThreadDemo( "Thread - A ", PD );
		ThreadDemo T2 = new ThreadDemo( "Thread - B ", PD );

		T1.start();
		T2.start();

		// wait for threads to end
		try {
			T1.join();
			T2.join();
		} catch( Exception e) {
			System.out.println("Interrupted");
		}
		
	}
	
	private static void runHowTo() {
		showCategory("How To ...");
		
		// spring and spark job launcher
		//SpringApplication.run(App.class);
		
		// zookeeper data operation
		//DataAccess.Test();
		
		//
		priorityQueue();
	}
	
	private static void priorityQueue() {
		int[] ia = { 1, 10, 5, 3, 4, 7, 6, 9, 8 };
		
		/* Java 7
		Queue<Integer> pq1 = new PriorityQueue<>(new Comparator<Integer>() {
			public int compare(Integer s1, Integer s2) {
		        
				if(s1 > s2) return 1;
				if(s1 < s2 ) return -1;
		        return 0;
		    }
		});
		*/
		
		// Java 8
		PriorityQueue<Integer> pq1 = new PriorityQueue<>((a,b)->(Integer.compare(a, b)));
 
		// use offer() method to add elements to the PriorityQueue pq1
		for (int x : ia) {
			pq1.add(x);
		}
		
		while(!pq1.isEmpty()) {
			System.out.println(pq1.poll());
		}
	}
	
	
	private static void runHashing() {
		showCategory("Hashing");
		
		String url = "https://gist.github.com/dgritsko/9554733/dgritsko/9554733/dgritsko/9554733/dgritsko/9554733/dgritsko/9554733";
		long l = TinyUrl.Decode(url);
		String s = TinyUrl.Encode(l);
		
		//l = 9999999999L;
		s = TinyUrl.Encode(l);
		l = TinyUrl.Decode(s);
		
		System.out.printf("Encode(%d)='%s'", l, s);
		
	}
	
	private static void runLeet() {
		showCategory("Leet");
		 
		/*
		int[] nums = new int[]{6, 3, 7, 2, 5, 1, 4};
		int sum = 8;
		int[] result = TwoSum.twoSum(nums, sum);
		System.out.printf("Input: %s \nOutput(array index): %d=%s\n", Arrays.toString(nums), sum, Arrays.toString(result));
		*/
		
		/*
		ListNode l1 = ListNode.build(new int[]{1,8});
		ListNode l2 = ListNode.build(new int[]{0});
		l1.print(); System.out.print("\n");
		l2.print(); System.out.print("\n");
		ListNode l3 = TwoNum.addTwoNumbers(l1, l2);
		if(l3 != null) l3.print(); System.out.print("\n");
		*/
		
		/*
		String s = "aaaaabcbefbbb";
		int r = LongestStringNoRepeat.lengthOfLongestSubstring(s);
		System.out.printf("Length of LongestStringNoRepeat '%s' is %d\n", s, r);
		*/
		
		/* UNSOLVED!!!
		int[] a1 = new int[]{1,4,5};
		int[] a2 = new int[]{2,6};
		double d = SortedArrayMedian.findMedianSortedArrays(a1, a2);
		System.out.printf("Median of %s and %s is %3.2f", Arrays.toString(a1), Arrays.toString(a2), d);
		*/
		
		/*
		String s = "bananas"; // "", "b", "bb", "bbb", "ab", "bananas"
		//String r = LongestPalindromicSubstring.isPalindrome(s, 1, 5).toString(); // result should be  true
		String r = LongestPalindromicSubstring.longestPalindrome(s); // result should be "anana"
		System.out.printf("LongestPalindromicSubstring of '%s' is '%s'\n", s, r);
		*/
		
		/*
		String s = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String r = ZigzagConversion.convert(s,4);
		System.out.printf("ZiazagConversion of '%s' is '%s'\n", s, r);
		*/
		
		/*
		int i = -1234567890;
		    i = -1234567890;
		    i = -2147483648; // exceeds
		    i = 1223456789; // exceeds max, so it should return 0
		    i = -2147483412;
		    
		int j = ReverseInteger.reverse(i);
		System.out.printf("ReverseInteger of %d is %d\n", i,j);
		*/
		
		/*
		String[] s = {"      -11919730356x", "9223372036854775809", null, "", "+-2", "a123", " a123b", "  123", "  123  abc", "000123", "0+00123", "+123", "-000123", " + 123abc", "+  a123", "-a123xyz", "123.456abc", "2147483647", "-2147483648", "2147483888", "-2147483888"};
		for(String str : s) {
			int r = StringToInteger.myAtoi(str);
			System.out.printf("atoi('%s')=%d\n", str, r);
		}
		*/
		
		/*
		int[] n = {0, 1, -1, 123321, 12321, 123, 1232};
		for(int i : n) {
			boolean r = PalindromeNumber.isPalindrome(i);
			System.out.printf("Is %d PalindromeNumber? %s\n", i, String.valueOf(r));
		}
		*/
		
		/*
		int[] h = {3,2,6,5,4,10,8};
		int r = ContainerMaxWater.maxArea(h);
		System.out.printf("ContainerMaxWater of %s is %d\n", Arrays.toString(h), r);
		*/
		
		/*
		int[] n = {1, 100, 123, 3999};
		for(int i : n) {
			System.out.printf("IntegerToRoman: %4d -> %s\n", i, IntegerToRoman.intToRoman(i));
		}
		*/
		
		/*
		String[] a = {"III", "IV", "VI","XIX", "XX","XLV","MCMXXC"};
		for(String s : a) {
			System.out.printf("Roman '%10s' is %5d\n", s, RomanToInteger.romanToInt(s));
		}
		*/
		
		/*
		String[] a = {"abcdefg", "abcxyz", "abc"};
		System.out.printf("Longest Common Prefix of %s is %s\n", Arrays.toString(a), LongestCommonPrefix.longestCommonPrefix(a));
		*/
		
		/*
		int[] a = {-1, 0, 1, 2, -1, -4};
		List<List<Integer>> r = ThreeSum.threeSum(a);
		*/
		
		/*
		int[] a = {-1, 2, 1, -4};
		int t = 1;
		int r = ThreeSumClosest.threeSumClosest(a, t);
		System.out.printf("ThreeSumClosest: array of %s with target %d is %d\n", Arrays.toString(a), t, r);
		*/
		
		/* 
		 List<String> list = PhoneNumberCombinations.letterCombinations("23");
		*/
		
		/*
		int[] a = {1, 0, -1, 0, -2, 2};
		List<List<Integer>> r = FourSum.fourSum(a, 0);
		*/
		
		/*
		ListNode link = ListNode.build(new int[]{1,2});
		String s = link.toString();
		int n = 1;
		ListNode result = RemoveNthNodeFromLinkedList.removeNthFromBegin(link, n);
		System.out.printf("Linked List: %s\n Remove #%d node: %s\n", s, n, result);
		*/
		
		/*
		ListNode link = ListNode.build(new int[]{1,2,3,4,5});
		String s = link.toString();
		int n = 4;
		ListNode result = RemoveNthNodeFromLinkedList.removeNthFromEnd1Iteration(link, n);
		System.out.printf("Linked List: %s\n Remove backward #%d node: %s\n", s, n, result);
		*/
		
		/*
		String s = "(abc)[ddd{eee}]()fff";
		boolean r = ValidParentheses.isValid(s);
		System.out.printf("ValidParentheses of '%s' is %s\n", s, Boolean.toString(r));
		*/
		
		/*
		ListNode list1 = ListNode.build(new int[]{1,3,4,5});
		ListNode list2 = ListNode.build(new int[] {1,2,4,6,7});
		ListNode list = MergeTwoSortedList.mergeTwoLists(list1, list2);
		System.out.printf("Merge %s and %s is %s", list1, list2, list); 
		*/
		
		/*
		
		List<String> list = GenerateParentheses.generateParenthesis(3);
		System.out.println("GenerateParentheses: " + Arrays.toString(list.toArray()));
		
		*/
		/*
		
		ListNode list1 = ListNode.build(new int[] {1,3,4,5});
		ListNode list2 = ListNode.build(new int[] {1,2,4,6,7});
		ListNode list3 = ListNode.build(new int[] {5,7});
		ListNode list4 = ListNode.build(new int[] {10});
		ListNode[] list = {list1, list2, list3, list4};
		ListNode result = MergeSortedLists.mergeKLists(list);
		result.print();
		*/
		
		/*
		ListNode list = ListNode.build(new int[] {1,2,3,4,5});
		ListNode list2 = SwapNodeInPairs.swapPairs(list);
		if(list2 != null) list2.print();
		*/
		
		/*
		int[] a = {1,2,3,3,3,4,4,5,5,5};
		int r = RemoveDuplicatesFromSortedArray.removeDuplicates(a);
		System.out.printf("Result is first %d elements in %s\n", r, Arrays.toString(a));
		*/
		
		/*
		int[] a = {2,4,5,1,4,6};
		int val = 4;
		int r = RemoveElement.removeElement(a, val);
		System.out.printf("Removing value %d is first %d elements of %s\n", val,r,Arrays.toString(a));
		*/
		
		
		/*
		//String haystack = "ACATXACGACACAGT";
		//String needle =   "ACACAGT";
		String haystack = "AAABADEFAAABHIJKLMNAAAB";
		String needle =   "AAAB";
		int r = InStr.inStr_KMP(haystack, needle);
		System.out.printf("inStr('%s','%s')=%d\n", haystack, needle, r);
		
		List<Integer> result = InStr.inStrAll_KMP(haystack, needle);
		System.out.printf("inStr('%s','%s')=%s\n", haystack, needle, Arrays.toString(result.toArray()));
		*/
		
		/*
		int i = 1000;
		int j = -10;
		int r = DivideTwoIntegers.divide(i, j);
		System.out.printf("%d / %d = %d", i, j, r);
		*/
		
		/*
		String s = "...ABCXYZ123........123...XYZ.......XYZ123ABC.....XYZABC123....123ABC........ABC123XYZ....";
		String[] words = {"ABC", "XYZ", "123"};
		List<Integer> result = SubstringOfConcatenationAllWords.findSubstring(s, words);
		System.out.printf("SubstringOfConcatenationAllwords - \ninput '%s', %s  \noutput: %s\n", s,Arrays.toString(words) ,Arrays.toString(result.toArray()));
		*/
		
		/*
		int[] a = {2,4,3,8,7,6,5,1};
		String s = Arrays.toString(a);
		NextPermutaion.nextPermutation(a);
		System.out.printf("NextPermutaion of %s is %s", s, Arrays.toString(a));
		*/
		
		/*
		
		String s = "((()()((())";
		s = ")()";
		s = "(((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((("
				+ "(((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((("
				+ "(((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((("
				+ "(((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((("
				+ "(((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((("
				+ "(((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((("
				+ "(((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((("
				+ "(((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((("
				+ "(((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((("
				+ "(((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((("
				+ "(((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((("
				+ "(((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((("
				+ "(((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((("
				+ "((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((";
		int i = LongestValidParentheses.longestValidParentheses(s);
		System.out.printf("LongestValidParentheses('%s')=%d", s, i);
		
		*/
		
		/*
		int[] a = { 4,5,6,7,0,1,2 }; //rotated array
		int t = 1;
		int index = SearchInRotatedSortedArray.search(a, t);
		System.out.printf("SearchInRotatedSortedArray in %s for %d = index %d", Arrays.toString(a), t, index);
		*/
		
		/*
		
		int[] a = {5, 7, 7, 8, 8, 8, 8, 10};
		int[] r = SearchForRange.searchRange(a, 8);
		System.out.printf("SearchForRange(%s) = %s", Arrays.toString(a), Arrays.toString(r));
		*/
		
		/*
		int[] a = {1,2,3,4,5,6};
		int i = SearchForRange.searchRange(a, 6, 0, a.length - 1);
		*/
		
		/*
		int[] a = {1,2,8};
		int t = 5;
		System.out.printf("SearchInsertPosition(%s, %d) = %d ", Arrays.toString(a), t, SearchInsertPosition.searchInsert(a, t));
		*/
		
		/*
		char[][] arr = { 
		        {'5', '3', '4',   '6', '7', '8',   '9', '1', '2'}, 
		        {'6', '7', '.',   '1', '9', '5',   '3', '4', '8'},
		        {'1', '9', '8',   '3', '.', '2',   '5', '6', '7'},
		        
		        {'8', '5', '9',   '7', '6', '1',   '4', '2', '3'},
		        {'4', '2', '6',   '8', '5', '3',   '7', '9', '1'},
		        {'7', '1', '3',   '9', '2', '4',   '8', '5', '6'},
		        
		        {'9', '6', '1',   '5', '3', '7',   '2', '8', '4'},
		        {'2', '8', '7',   '4', '1', '9',   '6', '3', '5'},
		        {'3', '4', '5',   '2', '8', '6',   '1', '7', '9'}
		    };
		
		boolean isValid = ValidSudoku.isValidSudoku(arr);
		*/
		
		/*
		int n = 10;
		System.out.printf("NthSequence(%d)='%s'", n, NthSequence.countAndSay(n));
		*/
		
	
		/*
		int[] a = {2,3,6,7};
		int target = 7;
		List<List<Integer>> list = CombinationSum.combinationSum2(a, target);
	
		System.out.println(list.toString());
		*/
		
		/*
		int[] a = {1,1};
		int target = 1;
		List<List<Integer>> list = CombinationSumUnique.combinationSum(a, target);
		*/
		
		/*
		int[] a = {1,3,4,-1,100};
		int r = FirstMissingPositive.firstMissingPositive(a);
		System.out.printf("FirstMissiongPosition of %s = %d", Arrays.toString(a), r);
		*/
		
		/*
		//int[] a = {0,1,0,2,1,0,1,3,2,1,2,1};
		int[] a = {4,2,3};
		int r = TrappingRainWater.trap(a);
		System.out.printf("TrappingRainWater of %s = %d", Arrays.toString(a), r);
		*/
		/*
		String s1 = "123";
		String s2 = "456";  // should result "56088"
		System.out.printf("'%s' x '%s' = '%s'", s1, s2, MultiplyStrings.multiply(s1, s2));
		*/
		
		/*
		String s = "abcdabcd";
		String p = "a*cd*d";
		System.out.printf("%s to %s = %s", s, p, PatternComparison.isMatch(s, p));
		*/
		
		/*
		//int[] a = {2,3,1,1,1,4};
		// int[] a = {2,3,1};
		int[] a = {7,0,9,6,9,6,1,7,9,0,1,2,9,0,3}; //ok
		//int[] a = {1,2}; //ok
		// int[] a = {1,2,3}; //ok
		// int[] a = {0};
		System.out.printf("Jump %s = min steps of %d \n", Arrays.toString(a), Jump.jump(a));
		*/
		
		/*
		int[] a = {1,2,3,4};
		List<List<Integer>> result = Permutations.permute(a);
		*/
		
		/*
		int[] a = {1,1,2};
		List<List<Integer>> result = Permutations.permuteUnique(a);
		*/
		
		/*
		int[][] a = {{1,2,3},{4,5,6},{7,8,9}};
		RotateImage.rotate(a);
		*/
		
		/*
		String[] a = {"eat", "tea", "tan", "ate", "nat", "bat"};
		List<List<String>> r = GroupAnagrams.groupAnagrams(a);
		*/
		
		/*
		double x = 10;
		int n = -5;
		double r = Power.myPow(x, n);
		System.out.printf("Power(%f,%d)=%f", x, n, r);
		*/
		
		/*
		
		int[] a = {2,3,1,1,4};
		boolean r = JumpGame.canJump(a);
		System.out.printf("CanJump(%s) = %s\n", Arrays.toString(a), r);
		
		a = new int[] {3,2,1,0,4};
		r = JumpGame.canJump(a);
		System.out.printf("CanJump(%s) = %s\n", Arrays.toString(a), r);
		
		*/
		
		/*
		
		List<Interval> list = new ArrayList<>();
		list.add(new Interval(1,3)); 
		list.add(new Interval(2,6)); 
		list.add(new Interval(8,10)); 
		list.add(new Interval(15,18));
		
		List<Interval> result = MergeIntervals.merge(list);
		*/
		
		/*
		List<Interval> list = new ArrayList<>();
		list.add(new Interval(1,3)); 
		list.add(new Interval(2,6)); 
		list.add(new Interval(8,10)); 
		
		List<Interval> result = InsertInterval.insert(list, new Interval(5,9));
		*/
		
		/*
		int n = 4;
		int k = 14;
		System.out.printf("PermutationsGet(%d,%d)=%s", n, k, PermutationsGet.getPermutation(n, k));
		*/
		
		/*
		ListNode head = ListNode.build(new int[]{1,2,3,4,5});
		//head = ListNode.build(new int[]{1,2});
		String s = head.toString();
		int k = 10;
		System.out.printf("RotateList(%s,%d) = %s", s, k, RotateList.rotateRight(head, k).toString());
		*/
		
		/*
		int m = 4;
		int n = 6;
		System.out.printf("UniquePaths(%d,%d) = %d\n", m, n, UniquePaths.uniquePaths(m, n));
		System.out.printf("UniquePaths2(%d,%d) = %d\n", m, n, UniquePaths.uniquePaths2(m, n));
		*/
		
		
		/*
		int[][] a = {{1,3,2,5},{3,2,6,3},{8,2,5,6}};
		int r = MinimumPathSum.minPathSum(a);
		*/
		
		/*
		String s = " 1.01 a";
		System.out.printf("ValidateNumber('%s') = %s\n", s, ValidateNumber.isNumber(s));
		*/
		
		/*
		int[] digits = {9,9,9,9,9};
		String s = Arrays.toString(digits);
		int[] result = PlusOne.plusOne(digits);
		System.out.printf("PlusOne(%s) = %s\n", s, Arrays.toString(result));
		*/
		
		/*
		String s1 = "100";
		String s2 =  "111";
		System.out.printf("AddBinary('%s','%s') = '%s'\n", s1, s2, AddBinary.addBinary(s1, s2));
		*/
		
		/*
		String[] a = {"This", "is", "an", "example", "of", "text", "justification."};
		int l = 14;
		System.out.printf("TextJustification('%s', %d) = '%s'\n", Arrays.toString(a), l, Arrays.toString(TextJustification.fullJustify(a, l).toArray()));
		*/
		
		/*
		int x = 100;
		System.out.printf("sqrt(%d) = %d\n", x, Sqrt.mySqrt(x));
		*/
		
		/*
		int n = 3;
		System.out.printf("ClimbStairs(%d) = %d\n", n, ClimbStairs.climbStairs(n));
		*/
		
		/*
		String s = "/a/./b/../../c/";
		System.out.printf("SimplifyPath('%s') = '%s'\n", s, SimplifyPath.simplifyPath(s));
		*/
		
		/*
		String s1 = "abcdefg";
		String s2 = "xycdfxyze";
		System.out.printf("EditDistance('%s', '%s') = %d\n", s1, s2, EditDistance.minDistance(s1, s2));
		*/
		
		/*
		int[][] a = {{0,0,0,5},{4,3,1,4},{0,1,1,4},{1,2,1,3},{0,0,1,1}};
		//a = new int[][]{{1},{0}};
		SetMatrixZeroes.setZeroes(a);
		*/
		
		/*
		int[][] a =
		{
		  {2,   3,  5,  7},
		  {10, 11, 16, 20},
		  {23, 30, 34, 50}
		};
		
		boolean r = Search2DMatrix.searchMatrix(a, 10);
		
		System.out.printf("Search2DMatrix with input %s outputs: %s\n", Arrays.deepToString(a), r);
		*/
		
		/*
		int[] nums = {2,0,1,2,1,2,0,0,1,2,1};
		String s = Arrays.toString(nums);
		SortColors.sortColors(nums);
		System.out.printf("SortColors(%s) = %s\n", s, Arrays.toString(nums));
		*/
		
		/*
		String s = "ADOBECODEBANC";
		String t = "ABC";
		//Minimum window is "BANC".
		String r = MinWindowSubstring.minWindow(s.toCharArray(),t.toCharArray());
		System.out.printf("MinWindowSubstring('%s', '%s') = '%s'", s, t, r);
		*/
		
		/*
		int[] nums = {1,2,3};
		List<List<Integer>> list = Subsets.subsets(nums);
		System.out.printf("Subsets(%s) = %s", Arrays.toString(nums), list.toString());
		*/
		
		/*
		ListNode head;
		
		head = ListNode.build(new int[]{10,40,30,20,50,20}); // {10,40,30,20,50,20}
		head = PartitionList.partition(head, 30);
		head.print();
		System.out.println();
		
		head = ListNode.build(new int[]{20,10});
		head = PartitionList.partition(head, 20);
		head.print();
		*/
		
		//List<Integer> list = GrayCode.grayCode(2);
		
		/*
		int[] nums = {1,2,2,3};
		List<List<Integer>> list = SubsetsDuplicate.subsets(nums);
		System.out.printf("SubsetsDuplicate(%s) = %s", Arrays.toString(nums), list.toString());
		*/
		
		
		int[] a = new int[] {3, 30, 34, 5, 9};
		String s = LargetstNumber.largestNumber(a);
		System.out.printf("LargetstNumber(%s) = '%s'", Arrays.toString(a), s);
		
		
	}
	
	private static void runJava8() {
		showCategory("Java8");
		
		List<String> names1 = new ArrayList<>();
		names1.add("Mahesh");
		names1.add("Suresh");
		names1.add("Namesh");
		names1.add("Naresh");
		names1.add("Kalpesh");
		
		List<String> names2 = new ArrayList<>();
		names2.add("Mahesh");
		names2.add("Suresh");
		names2.add("Namesh");
		names2.add("Naresh");
		names2.add("Kalpesh");
		
		String s = names2	.stream()
							.map(x -> x + "...")
							.map(x -> x.toUpperCase())
							.filter(x -> x.startsWith("N"))
							.reduce((x,y) -> x + "|" + y)
							.get();
		
		System.out.println(s);
		
		Collections.sort(names1, (s1, s2) -> s1.compareTo(s2));
		
		System.out.println(names1);
		
		MathOperation subtraction = (a, b) -> a - b;
	
		//System.out.print(subtraction(10, 8));
		
		//Old way:
		List<Integer> list = Arrays.asList(1,2,3,4,5,6,7);
		int sum = 0;
		for(Integer n : list) {
		    int x = n * n;
		    sum = sum + x;
		}
		System.out.println(sum);
		
		//New way:
		sum = list	.stream()
					.map(x -> x*x)
					.reduce((x,y) -> x + y)
					.get();
		
		System.out.println(sum);
	}
	
	private static void runRecursion() {
		showCategory("Recursion");
		
		int n = 5;
		int m = 4;
		int r = n2m.calcuate(n, m);
		System.out.printf("%d to %d = %d", n, m, r);
		
	}
	
	private static void runTree() {
		showCategory("Tree");
		
		/*
		int[] a = new int[]{6, 3, 7, 2, 5, 1, 4};
		
		@SuppressWarnings("unused")
		TNode root = Tree.buildBST(a);
		
		// print it out
		TreePrinter.printNode(root);
		
		System.out.print("\npre-order traversal: "); 
		Tree.traversalPreorder(root);
		 
		System.out.print("\nin-order traversal: ");
		Tree.traversalInorder(root);
		
		System.out.print("\npost-order traversal: ");
		Tree.traversalPostorder(root);
		
		System.out.print("\nlevel-order traversal: ");
		Tree.traversalLevelorder(root);
		
		// search
		TNode result = Tree.search(root, 5);
		System.out.printf("\nResult is: %s", result == null ? "null" : Integer.toString(result.getData()));
		
		// min, max
		int min = Tree.min(root).getData();
		int max = Tree.max(root).getData();
		System.out.printf("\nMin: %d Max: %d\n", min, max);
		
		// successor
		TNode node = Tree.search(root, 5);
		TNode successor = Tree.successor(node);
		System.out.printf("Successor of %d is %d\n", node.getData(), successor.getData());
		node = Tree.search(root, 2);
	    successor = Tree.successor(node);
		System.out.printf("Successor of %d is %d\n", node.getData(), successor.getData());
		
		// delete
		Tree.delete(root, 3);
		System.out.println("\nAfter deletion:");
		TreePrinter.printNode(root);
		
		*/
		
		String[] strings = {"abc","bcd", "abd", "abcd", "bcefg"};
		TrieNode root = Trie.build(strings);
		Trie.print(root);
	}
	
	private static void runSort() {
		showCategory("Sort");
		
		int[] a = new int[]{6, 3, 7, 2, 5, 1, 4}; //, 0, 0, 0, 0};
		
	    //InsertSort.sort(data);
		
		////HeapSort.heapBuild(a); // a[0] is reserved for heapSize
		////HeapSort.heapInsert(a, 11);
		
		//HeapSort.sort(a); // a[0] is reserved for heapSize
		
		//QuickSort.sort(a);
		
	    System.out.println(Arrays.toString(a));
		
		@SuppressWarnings("unused")
		int breakpoint = 0;
	}
	
	private static void runDp() {
		showCategory("Dynamic Programming");

		int l = 8;
		int r = RodCutting.MemoziedCut(l);
		System.out.printf("Max profit of length of %d is %d:\n", l, r);
		
		r = RodCutting.BottomUpCut(l);
		System.out.printf("Max profit of length of %d is %d:\n", l, r);
		
		int w = 5;
		
		System.out.printf("Knapsack problem with weight capacity:\n", w);
		Knapsack.Calculate(w);

		String A = "acbaed", B = "abcadf";
		System.out.printf("LCS('%s','%s') = '%s'", A, B, LCS.find(A,B));
		
	}
	
	private static void runLl() {
		showCategory("Linked List");
		
		int[] a = new int[]{6, 3, 7, 2, 5, 1, 4};
		
		LNode head = LinkedList.build(a);
		
		LinkedList.print(head);
		
		//head = LinkedList.reverse(head);
		
		//LNode result = LinkedList.search(head, 5);
		//System.out.println(result.getData());
		
		head = LinkedList.insert(head, 5, 8);
		LinkedList.print(head);
		
		head = LinkedList.insert(head, 10, 9);
		LinkedList.print(head);
		 
		head = LinkedList.insert(head, 6, 12);
		LinkedList.print(head);
		
		head = LinkedList.insert(head, 12, 1);
		LinkedList.print(head);
		
		head = LinkedList.insert(head, -1, 1);
		LinkedList.print(head);
		
		head = LinkedList.delete(head, 1);
		LinkedList.print(head);
		
		@SuppressWarnings("unused")
		int breakpoint = 0;
	}
	
	private static void runDc() {
		showCategory("Divide and Conquer");
		
		int[] stockPrices = new int[] {100,113,110,85,105,102,86,63,81,101,94,106,101,79,94,90,97};
		
		(new MaxSum()).maxProfit(stockPrices);
		
		int max = (new MaxSum()).maxProfit_quick(stockPrices);
		
		System.out.printf("maxProfit is %d", max);
	}
	
	private static void runGreedy() {
		showCategory("Greedy (local optimal solution leads to global!)");
		
		int[] stockPrices = new int[] {100,113,110,85,105,102,86,63,81,101,94,106,101,79,94,90,97};
		
		(new com.adventure.greedy.MaxSum()).maxProfit(stockPrices);
		
		int[] start  = new int[] {1, 3, 0,   8,  8,  11,  12};
		int[] finish = new int[] {4, 5, 6,   11, 12, 14, 16};
		
		ActivitySelector.Calculate(start, finish);
		
	}
	
	private static void runBit() {
		showCategory("Bit Operations");
		int num=7;
		String s = IntToBit.convert(num);
		System.out.printf("Int %d = Bit %s", num, s);
		
//		char c = 'a';
//		c ^= 256;
//		System.out.println(c);
//		c ^= 256;
//		System.out.println(c);
		
	}
	
	
	private static void showCategory(String category) {
		System.out.println("===========================================================");
		System.out.println(category);
		System.out.println("===========================================================");
	}
	
	interface MathOperation {
	      int operation(int a, int b);
	}

}


