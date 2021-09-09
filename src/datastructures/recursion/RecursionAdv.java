package datastructures.recursion;

import datastructures.arrays.ArrayUtils;

public class RecursionAdv {

	public static void main(String[] args) {
		int[] arr = {5, 12, 3, 17, 1, 18, 15, 3, 17};
		String[] arr2 = new String[0];
		int[][] mat = new int[0][0];
		
//		towerOfHanoi(3, 'a', 'b', 'c');
//		mergeSort(arr);
//		arr2 = keypad(23);
//		System.out.println(binarySearch(arr, 3));
//		arr2 = subsequence("abc");
//		printSubsequences("abc");
//		System.out.println(findWays(4));
//		System.out.println(checkAB("aaazbba"));
//		printKeypad(23);
//		arr2 = permutationOfString("abc");
//		permutations("abc");
//		mat = subsets(arr);
//		printSubsets(arr);
//		mat = subsetsSumK(arr, 6);
//		printSubsetsSumTok(arr, 6);
//		arr2 = getCode("1123");
//		printAllPossibleCodes("1123");
//		quickSort(arr);
		arr2 = allStrings("abc", 2);
		
		ArrayUtils.print(arr);
		for(int i = 0; i < arr2.length; i++) {
			System.out.println(arr2[i]);
		}
		
		for(int i = 0; i < mat.length; i++) {
			for(int j = 0; j < mat[i].length; j++) {
				System.out.print(mat[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	private static String[] allStrings(String str, int k) {
		if(k == 0) {
			return new String[] { "" };
		}
		
		String[] smallAns = allStrings(str, k - 1);
		String[] ans = new String[smallAns.length * str.length()];
		int n = 0;
		for(int i = 0; i < smallAns.length; i++) {
			for(int j = 0; j < str.length(); j++) {
				ans[n++] = smallAns[i] + str.charAt(j);
			}
		}
		
		return ans;
	}

	private static void quickSort(int[] arr) {
		quickSort(arr, 0, arr.length - 1);
		
	}

	private static void quickSort(int[] arr, int si, int ei) {
		if(si >= ei) {
			return;
		}
		
		int pi = partition(arr, si, ei);
		quickSort(arr, si, pi - 1);
		quickSort(arr, pi + 1, ei);
		
	}

	private static int partition(int[] arr, int si, int ei) {
		int pi = si;
		int pivot = arr[si];
		
		int smallerElementsCount = 0;
		for(int i = si + 1; i <= ei; i++) {
			if(arr[i] <= pivot) {
				smallerElementsCount++;
			}
		}
		pi = si + smallerElementsCount;
		swap(arr, pi, si);
		while(si < pi && ei > pi) {
			if(arr[si] <= pivot) {
				si++;
			} else if(arr[ei] > pivot) {
				ei--;
			} else {
				swap(arr, si++, ei--);
			}
		}
		return pi;
	}

	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	private static void printAllPossibleCodes(String str) {
		printAllPossibleCodes(str, "");
		
	}

	private static void printAllPossibleCodes(String str, String out) {
		if(str.length() == 0) {
			System.out.println(out);
			return;
		}
		int singleDigit = getIntValue(str.charAt(0));
		printAllPossibleCodes(str.substring(1), out + getCharValue(singleDigit));
		if(str.length() > 1) {
			int doubleDigit = getIntValue(str.charAt(0)) * 10 + getIntValue(str.charAt(1));
			if(doubleDigit <= 26) {
				printAllPossibleCodes(str.substring(2), out + getCharValue(doubleDigit) );
			}
		}
	}

	private static String[] getCode(String str) {
		if(str.length() == 0) {
			return new String[] { "" };
		}
			
		char ch1 = getCharValue(getIntValue(str.charAt(0)));
		String[] smallAns1 = getCode(str.substring(1));
		String[] smallAns2 = new String[0];
		
		char ch2 = '\0';
		if(str.length() > 1) {
			int val = (getIntValue(str.charAt(0)) * 10) + getIntValue(str.charAt(1));
			if(val <= 26) {
				smallAns2 = getCode(str.substring(2));
			}
			ch2 = getCharValue(val);
		}
	
		String[] ans = new String[smallAns1.length + smallAns2.length];
		for(int i =0; i < smallAns1.length; i++) {
			ans[i] = ch1 + smallAns1[i];
		}	
		for(int i = 0; i < smallAns2.length; i++) {
			ans[smallAns1.length + i] =  ch2 + smallAns2[i];
		}
		
		return ans;
	}
	
	private static int getIntValue(char ch) {
		return ch - '0';
	}

	private static char getCharValue(int n) {
		return (char)(n - 1 + 'a');
	}

	private static void printSubsetsSumTok(int[] arr, int sum) {
		printSubsetsSumTok(arr, sum, 0, new int[0]);
	}

	private static void printSubsetsSumTok(int[] arr, int sum, int index, int[] out) {
		if(sum == 0) {
			for(int i = 0; i < out.length; i++) {
				System.out.print(out[i] + " ");
			}
			System.out.println();
			return;
		} else if(sum < 0 || arr.length == index){
			return;
		}
		
		int[] newOut = new int[out.length + 1];
		for(int i = 0; i < out.length; i++) {
			newOut[i] = out[i];
		}
		newOut[out.length] = arr[index];
		printSubsetsSumTok(arr, sum - arr[index], index + 1, newOut);
		printSubsetsSumTok(arr, sum, index + 1, out);
		
	}

	private static int[][] subsetsSumK(int[] arr, int sum) {
		return subsetsSumK(arr, sum, 0);
	}

	private static int[][] subsetsSumK(int[] arr, int sum, int index) {
		if(sum == 0) {
			return new int[1][0];
		} else if(arr.length == index || sum < 0) {
			return new int[0][0];
		}
		
		int[][] smallAns1 = subsetsSumK(arr, sum - arr[index], index + 1);
		int[][] smallAns2 = subsetsSumK(arr, sum, index + 1);
		int[][] ans = new int[smallAns1.length + smallAns2.length][0];
		
		for(int i = 0; i < smallAns1.length; i++) {
			ans[i] = new int[smallAns1[i].length + 1];
			for(int j = 0; j < smallAns1[i].length; j++) {
				ans[i][j + 1] = smallAns1[i][j];
			}
			ans[i][0] = arr[index];
		}
		
		for(int i = 0; i < smallAns2.length; i++) {
			ans[smallAns1.length + i] = smallAns2[i];
		}
		
		return ans;
	}

	private static void printSubsets(int[] arr) {
		printSubsets(arr, new int[0], 0);
		
	}

	private static void printSubsets(int[] arr, int[] out, int index) {
		if(index == arr.length) {
			for(int i = 0; i < out.length; i++) {
				System.out.print(out[i] + " ");
			}
			System.out.println();
			return;
		}
		
		printSubsets(arr, out, index + 1);

		int[] out2 = new int[out.length + 1];
		for(int i = 0; i < out.length; i++) {
			out2[i] = out[i];
		}
		out2[out.length] = arr[index];
		printSubsets(arr, out2, index + 1);
	}

	private static int[][] subsets(int[] arr) {
		return subsets(arr, 0);
	}

	private static int[][] subsets(int[] arr, int index) {
		if(index == arr.length ) {
			return new int[][] { {} };
		}
		
		int[][] smallAns = subsets(arr, index + 1);
		int[][] ans = new int[smallAns.length * 2][];
		
		for(int i = 0; i < smallAns.length; i++) {
			ans[i] = smallAns[i];
			
			ans[smallAns.length + i] = new int[smallAns[i].length + 1];
			for(int j = 0; j < smallAns[i].length; j++) {
				ans[smallAns.length + i][j + 1] = smallAns[i][j];
			}
			ans[smallAns.length + i][0] = arr[index];
		}
	
		return ans;
	}

	private static void permutations(String str) {
		permutations(str, "");
	}

	private static void permutations(String str, String out) {
		if(str.length() == 0) {
			System.out.println(out);
			return;
		}
		for(int i = 0; i <= out.length(); i++) {
			permutations(str.substring(1), out.substring(0, i) + str.charAt(0) + out.substring(i));
		}
		
	}

	private static String[] permutationOfString(String str) {
		if(str.length() == 1) {
			return new String[] {str};
		}
		String[] smallAns = permutationOfString(str.substring(1));
		String[] ans = new String[smallAns.length * str.length()];
		
		int k = 0;
		for(int i = 0; i < smallAns.length; i++) {
			for(int j = 0; j <= smallAns[i].length(); j++) {
				ans[k++] = smallAns[i].substring(0, j) + str.charAt(0) + smallAns[i].substring(j);
			}
		}
		
		return ans;
	}

	private static void printKeypad(int n) {
		printKeypad(n, "");
		
	}

	private static void printKeypad(int n, String out) {
		if(n == 0) {
			System.out.println(out);
		}
		int k = n % 10;
		String opt = findKey(k);
		for(char ch : opt.toCharArray()) {
			printKeypad(n / 10, ch + out);
		}
		
	}

	private static boolean checkAB(String str) {
		if(str.length() == 0) {
			return true;
		}
		
		if(str.charAt(0) == 'a') {
			if(str.length() > 2 && str.substring(1, 3).equals("bb")) {
				return checkAB(str.substring(3));
			} else {
				return checkAB(str.substring(1));
			}
		}
		
		return false;
	}

	private static int findWays(int n) {
		if(n == 0) {
			return 1;
		} 
		if(n < 0) {
			return 0;
		}
		
		return findWays(n - 1) + findWays(n - 2) + findWays(n - 3);
	}

	private static void printSubsequences(String string) {
		printSubsequences(string, "");
	}

	private static void printSubsequences(String str, String out) {
		if(str.length() == 0) {
			System.out.println(out);
			return;
		}
		printSubsequences(str.substring(1), out);
		printSubsequences(str.substring(1), out + str.charAt(0));
	}

	private static String[] subsequence(String str) {
		if(str.length() == 0) {
			return new String[] { "" };
		}
		String[] smallAns = subsequence(str.substring(1));
		String[] ans = new String[smallAns.length * 2];

		for(int i = 0; i < smallAns.length; i++) {
			ans[i] = smallAns[i];
			ans[smallAns.length + i] = str.charAt(0) + smallAns[i];
		}
		return ans;
	}

	private static int binarySearch(int[] arr,int x) {
		return binarySearch(arr, 0, arr.length - 1, x);
	}

	private static int binarySearch(int[] arr, int si, int ei, int x) {
		if(si > ei) {
			return -1;
		}
		int mid = si + (ei - si)/2;
		if(arr[mid] < x) {
			return binarySearch(arr, mid + 1, ei, x);
		} else if(arr[mid] > x) {
			return binarySearch(arr, si, mid - 1, x);
		} else 
			return mid;
	}

	private static String[] keypad(int n) {
		if(n == 0) {
			return new String[] { "" };
		}
		
		String[] smallAns = keypad(n / 10);
		String opt = findKey(n % 10);
		String[] ans = new String[smallAns.length * opt.length()];
		
		int k = 0;
		for(int i = 0; i < smallAns.length; i++) {
			for(int j = 0; j < opt.length(); j++) {
				ans[k++] = smallAns[i] + opt.charAt(j);
			}
		}
		return ans;
	}
	
	private static String findKey(int k) {
		String[] keys = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
		return keys[k];
	}

	private static void mergeSort(int[] arr) {
		mergeSort(arr, 0, arr.length - 1);
	}

	private static void mergeSort(int[] arr, int si, int ei) {
		if(si == ei) {
			return;
		}
		int mid = si + (ei - si)/2;
		mergeSort(arr, si, mid);
		mergeSort(arr, mid + 1, ei);
		merge(arr, si, mid, mid+1, ei);
	}

	
	private static void merge(int[] arr, int si1, int ei1, int si2, int ei2) {
		int size = ei2 - si1 + 1;
		int[] sortedArr = new int[size];
		int index = 0;
		int si = si1;
		
		while(si1 <= ei1 && si2 <= ei2) {
			if(arr[si1] < arr[si2]) {
				sortedArr[index++] = arr[si1++];
			} else {
				sortedArr[index++] = arr[si2++];				
			}
		}
		
		while(si1 <= ei1) {
			sortedArr[index++] = arr[si1++];
		}

		while(si2 <= ei2) {
			sortedArr[index++] = arr[si2++];
		}
		
		for(int i = 0; i < size; i++) {
			arr[si + i] = sortedArr[i];
		}
	}

	private static void towerOfHanoi(int disks, char source, char aux, char dest) {
		if(disks == 0) {
			return;
		}
		towerOfHanoi(disks - 1, source, dest, aux);
		System.out.println(source + " " + dest);
		towerOfHanoi(disks - 1, aux, source, dest);
		
	}
}
