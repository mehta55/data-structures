package datastructures.hashmap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import datastructures.binarytrees.BinaryTreeNode;

public class Problems {

	public static void main(String args[]) {
//		implementation();
//		maxFrequencyNumber(new int[] {1,2,7,99,11,6,3,3,4, 4, 2});
//		printBinaryTreeVerticalOrder(null);
//		pairSum(new int[] {}, 0);
//		longestConsecutiveIncreasingSequence(new int[] {2, 12, 9, 16, 10, 5, 3, 20, 25, 11, 1, 8, 6 });
//		getPairsWithDifferenceK(new int[] {5,1,2,4}, 3);
//		lengthOfLongestSubsetWithZeroSum( new int[] { 95, -97, -387, -435, -5, -70, 897, 127, 23, 284});

	}

	private static int lengthOfLongestSubsetWithZeroSum(int[] arr) {
		Map<Integer, Integer> map = new HashMap<>();
		int sum = 0;
		int maxSize = 0;
		map.put(0, -1);
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
			if (map.containsKey(sum)) {
				int size = i - map.get(sum);
				maxSize = Math.max(maxSize, size);
			} else {
				map.put(sum, i);
			}
		}
		return maxSize;
	}

	private static int getPairsWithDifferenceK(int[] arr, int k) {
		Map<Integer, Integer> freq = new HashMap<>();
		for (int x : arr) {
			freq.put(x, freq.getOrDefault(x, 0) + 1);
		}
		
		int tpairs = 0;
		for (int x : arr) {
			
			int find = k + x;
			int pairs = freq.getOrDefault(find, 0);
			
			if (find == x) {
				pairs--;
			}
			if (pairs > 0) {
				freq.put(x, freq.get(x) - 1);
				tpairs += pairs;
			}
		}
		System.out.println(tpairs);
		return tpairs;
	}

	private static List<Integer> longestConsecutiveIncreasingSequence(int[] arr) {
		Set<Integer> set = new HashSet<>();
		for (int x : arr) {
			set.add(x);
		}
		List<Integer> ans = new LinkedList<>();
		int maxSize = 0;
		for (int i = 0; i < arr.length; i++) {
			int currSize = 1;
			int nextElement = arr[i] + 1;
			while (set.contains(nextElement)) {
				currSize++;
				nextElement = nextElement + 1;
			}
			if (currSize > maxSize) {
				maxSize = currSize;
				ans = new LinkedList<>();
				ans.add(arr[i]);
				if (maxSize != 1) {
					ans.add(arr[i] + maxSize - 1);
				}
			}
		}
		
		System.out.println(ans);
		return ans;
	}

	public static String uniqueChar(String str) {

		Set<Character> set = new HashSet<>();
		for (Character ch : str.toCharArray()) {
			set.add(ch);
		}

		String ans = "";
		for (Character ch : str.toCharArray()) {
			if (set.contains(ch)) {
				ans = ans + ch;
				set.remove(ch);
			}
		}

		return ans;
	}

	public static int pairSum(int[] arr, int size) {

		Map<Integer, Integer> freq = new HashMap<>();
		for (int x : arr) {
			int count = freq.getOrDefault(x, 0);
			freq.put(x, count + 1);
		}

		int totalPairCount = 0;
		for (int x : arr) {
			int count = freq.getOrDefault(x, 0);
			if (count > 0) {
				freq.put(x, count - 1);
				int y = x * -1;
				totalPairCount += freq.getOrDefault(y, 0);
			}

		}
		return totalPairCount;
	}

	public static void printBinaryTreeVerticalOrder(BinaryTreeNode<Integer> root) {

		Map<Integer, List<Integer>> vlevelMap = new HashMap<>();
		printBinaryTreeVerticalOrderHelper(root, vlevelMap, 0);

		for (List<Integer> vlevel : vlevelMap.values()) {
			vlevel.stream().forEach(x -> System.out.print(x + " "));
			System.out.println();
		}
	}

	private static void printBinaryTreeVerticalOrderHelper(BinaryTreeNode<Integer> root,
			Map<Integer, List<Integer>> vlevelMap, int vlevelNo) {

		if (root == null) {
			return;
		}

		List<Integer> vlevel = vlevelMap.get(vlevelNo);
		if (vlevel == null) {
			vlevel = new ArrayList<>();
		}
		vlevel.add(root.data);
		vlevelMap.put(vlevelNo, vlevel);

		printBinaryTreeVerticalOrderHelper(root.left, vlevelMap, vlevelNo - 1);
		printBinaryTreeVerticalOrderHelper(root.right, vlevelMap, vlevelNo + 1);
	}

	public static void intersection(int[] arr1, int[] arr2) {
		Map<Integer, Integer> freq = new HashMap<>();

		for (int x : arr1) {
			int count = freq.getOrDefault(x, 0);
			freq.put(x, count + 1);
		}

		List<Integer> ans = new ArrayList<>();
		for (int y : arr2) {
			int count = freq.getOrDefault(y, 0);
			if (count > 0) {
				ans.add(y);
				freq.put(y, count - 1);
			}
		}

		Collections.sort(ans);
		ans.stream().forEach(x -> System.out.print(x + " "));

	}

	private static void maxFrequencyNumber(int[] arr) {
		Map<Integer, Integer> freq = new HashMap<>();
		for (int x : arr) {
			int xFreq = freq.getOrDefault(x, 0) + 1;
			freq.put(x, xFreq);
		}

		int ans = -1;
		int maxFreq = Integer.MIN_VALUE;
		for (int x : arr) {
			int xFreq = freq.get(x);
			if (xFreq > maxFreq) {
				maxFreq = xFreq;
				ans = x;
			}
		}
		System.out.println(ans);
	}

	private static void implementation() {
		String str = "The quick brown fox jumps over the lazy dog";
		MyHashMap<Character, Integer> map = new MyHashMap<>();

		for (char ch : str.toCharArray()) {
			Integer val = map.get(ch);
			if (val != null) {
				map.put(ch, val + 1);
			} else {
				map.put(ch, 1);
			}
		}

		System.out.println("-----------------");

		for (char ch : str.toCharArray()) {
			System.out.println(ch + " => " + map.get(ch));

		}

		System.out.println("-----------------");
		System.out.println(map);
	}
}
