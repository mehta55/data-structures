package datastructures.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class Array1D {

	public static void main(String[] args) {
//		int[] arr = ArrayUtils.takeInput();
//		int[] arr = {1, 3, 0, 2, 5, 0, 3, 2, 4};
//		int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
		int[] arr = {341, 781, 901, 151, 671};

//		int[] arr;
		int num;
//		try (Scanner scn = new Scanner(System.in)) {
//			int n = scn.nextInt();
//			arr = new int[n];
//			for (int i = 0; i < n; i++) {
//				arr[i] = scn.nextInt();
//			}
//			num = scn.nextInt();
//		}
		
		int[] arr1 = {1, 5, 1, 0};
		int[] arr2 = {8, 5, 5, 9};

//		swapAlternate(arr);
//		inverse(arr);
//		arrange(arr, 5);
//		intersection(arr,arr);
//		pairSum(arr, num);
//		sort01(arr);
//		System.out.println(binarySearch(arr,num));
//		bubbleSort(arr);
//		SelectionSort(arr);
//		insertionSort(arr);
//		arr = mergeTwoSortedArrays(arr1, arr2);
//		System.out.println(maximumSumPath(arr1, arr2));
//		pushZerosAtEnd(arr);
//		rotate(arr, 5);
//		System.out.println(secondLargestElement(arr));
//		arrayRotateCheck(arr);
//		sort012(arr);
//		arr = sumOfTwoArrays(arr1, arr2);
//		System.out.println(arrayEquilibriumIndex(arr));
//		System.out.println(maximumProfit(arr));
		sortByMiddle(arr);
		
		ArrayUtils.print(arr);
		
	}

	
	private static void sortByMiddle(int[] arr) {
		List<String> strs = new ArrayList<>();
		for (int x : arr) {
			strs.add(String.valueOf(x));
		}

		Comparator<String> myComparator = (str1, str2) -> {

			int index1 = str1.length() / 2;
			int index2 = str2.length() / 2;
			return Character.compare(str1.charAt(index1), str2.charAt(index2));
		};

		Collections.sort(strs, myComparator);
		for (int i = 0; i < strs.size(); i++) {
			arr[i] = Integer.parseInt(strs.get(i));
		}

	}


	private static int maximumProfit(int[] arr) {
		Arrays.sort(arr);
		int maxProfit = arr[arr.length - 1];
		for(int i = arr.length -2; i >= 0; i--) {
			maxProfit = Math.max(maxProfit, (arr[i] * (arr.length -i)));
		}
		return maxProfit;
	}


	private static int arrayEquilibriumIndex(int[] arr) {
		int ans = -1;
		int totalSum = 0;
		for(int i = 0; i < arr.length; i++) {
			totalSum += arr[i];
		}
		int curSum = 0;
		for(int i = 0; i < arr.length ; i++) {
			
			if(curSum == totalSum - curSum - arr[i]) {
				ans = i;
			}
			curSum += arr[i];
		}
		return ans;
	}


	/**
	 * Time complexity: O(o) => o = max(m,n) + 1
	 * Space complexity: O(1)
	 * 
	 */
	private static int[] sumOfTwoArrays(int[] arr1, int[] arr2) {
		int n = arr1.length;
		int m = arr2.length;
		int o = Math.max(n, m) + 1;
		int[] arr = new int[o];
		int carry = 0;
		
		int i = n - 1, j = m - 1, k = o - 1;
		while (i >= 0 && j >= 0) {
			int sum = arr1[i] + arr2[j] + carry;
			carry = sum >= 10 ? 1 : 0;
			arr[k] = sum % 10;
			i--;
			j--;
			k--;
		}
		
		while(i >= 0) {
			int sum = arr1[i] + carry;
			carry = sum >= 10 ? 1 : 0;
			arr[k] = sum % 10;
			i--;
			k--;
		}

		while(j >= 0) {
			int sum = arr2[j] + carry;
			carry = sum >= 10 ? 1 : 0;
			arr[k] = sum % 10;
			j--;
			k--;	
		}
		
		arr[0] = carry;
		
		return arr;
	}



	/**
	 * Time complexity: O(n)
	 * Space complexity: O(1)
	 * 
	 */
	private static void sort012(int[] arr) {
		int i = 0;
		int zeroIndex = 0;
		int twoIndex = arr.length - 1;
		
		while(i <= twoIndex) {
			if(arr[i] == 0) {
				swap(arr, i, zeroIndex);
				i++;
				zeroIndex++;
			} else if(arr[i] == 2) {
				swap(arr, i, twoIndex);
				twoIndex--;
			} else {
				i++;
			}
		}
		
	}

	private static void swap(int[] arr, int i, int j) {
		if (i == j) return;
		
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}



	private static int arrayRotateCheck(int[] arr) {
		for(int i = 0; i < arr.length - 1; i++) {
			if(arr[i] > arr[i + 1]) {
				return i + 1;
			}
		}
		return 0;
	}

	/**
	 * Time complexity: O(n)
	 * Space complexity: O(1)
	 * 
	 */
	private static int secondLargestElement(int[] arr) {
		int largest = Integer.MIN_VALUE;
		int secLargest = Integer.MIN_VALUE;
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] > largest) {
				secLargest = largest;
				largest = arr[i];
			} else if(arr[i] > secLargest && arr[i] != largest) {
				secLargest = arr[i];
			}
		}
		
		return secLargest;
	}



	private static void rotate(int[] arr, int d) {
		rotateApp1(arr,d);
		rotateApp2(arr,d);
	}

	/**
	 * Time complexity: O(n)
	 * Space complexity: O(1)
	 * 
	 */
	private static void rotateApp2(int[] arr, int d) {
		if(arr.length == 0 || d == 0 || d == arr.length) return;
		reverse(arr, 0, arr.length - 1);
		reverse(arr, 0, arr.length - 1 - d);
		reverse(arr, arr.length - d, arr.length - 1);
	}

	private static void reverse(int[] arr, int i, int j) {
		while (i < j) {
			int temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
			i++;
			j--;
		}
	}



	/**
	 * Time compexity: O(n)
	 * Space complexity: O(d)
	 * 
	 */
	private static void rotateApp1(int[] arr, int d) {
		if(arr.length == 0 || d == 0) return;
		d = d >= arr.length ? d % arr.length : d;
		if(d == 0) return;
		int subArr[] = new int[d];
		for(int i = 0; i < d; i++) {
			subArr[i] = arr[i];
		}
		for(int i = d; i < arr.length; i++) {
			arr[i - d] = arr[i];
		}
		for(int i = 0; i < subArr.length; i++) {
			arr[arr.length - d + i] = subArr[i];
		}
	}


	private static void pushZerosAtEnd(int[] arr) {
		int j = 0;
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] != 0) {
				arr[j++] = arr[i];
			} 
		}
		
		while(j < arr.length) {
			arr[j++] = 0;
		}
		
	}

	private static long maximumSumPath(int[] arr1, int[] arr2) {
		long maxSum = 0;
		int i = 0;
		int j = 0;
		long sum1 = 0;
		long sum2 = 0;
		
		while(i < arr1.length && j < arr2.length) {
			if(arr1[i] < arr2[j]) {
				sum1 += arr1[i++];
			} else if(arr1[i] > arr2[j]) {
				sum2 += arr2[j++];
			} else {
				sum1 += arr1[i++];
				sum2 += arr2[j++];
				maxSum += Math.max(sum1, sum2);

				sum1 = sum2 = 0;
			}
		}
		
		while(i < arr1.length) {
			sum1 += arr1[i++];
		}
		
		while(j < arr2.length) {
			sum2 += arr2[j++];
		}
		
		return sum1 > sum2 ? maxSum + sum1 : maxSum + sum2;
	}

	/**
	 * Time complexity: O(m + n)
	 * Spcae complexity: O(m + n)
	 * 
	 */
	private static int[] mergeTwoSortedArrays(int[] arr1, int[] arr2) {
		int i = 0;
		int j = 0;
		int k = 0;
		int m = arr1.length;
		int n = arr2.length;
		int[] arr = new int[m + n];
		
		while(i < m && j < n) {
			if(arr1[i] < arr2[j]) {
				arr[k++] = arr1[i++];
			} else if(arr1[i] > arr2[j]) {
				arr[k++] = arr2[j++];				
			} else {
				arr[k++] = arr1[i++];
				arr[k++] = arr2[j++];								
			}
		}
		
		while(i < m) {
			arr[k++] = arr1[i++];
		}
		while(j < n) {
			arr[k++] = arr2[j++];			
		}
		
		return arr;
	}

	private static void insertionSort(int[] arr) {
		for(int i = 1; i < arr.length; i++) {
			int insertVal = arr[i];
			int insertIndex = i;
			while(insertIndex > 0 && insertVal < arr[insertIndex - 1]) {
				arr[insertIndex] = arr[insertIndex - 1];
				insertIndex--;
			}
			if(insertIndex != i) {
				arr[insertIndex] = insertVal;
			}
		}
	}

	private static void SelectionSort(int[] arr) {
		for(int i = 0; i < arr.length - 1; i++) {
			int selectedIndex = i;
			for(int j = i + 1; j < arr.length; j++) {
				if(arr[j] < arr[selectedIndex]) {
					selectedIndex = j;
				}
			}
			int temp = arr[selectedIndex];
			arr[selectedIndex] = arr[i];
			arr[i] = temp;
		}
		
	}

	/**
	 * Time complexity: O(n2)
	 * Space complexity: O(1)
	 * Note: with every iteration right (max) side gets sorted so no need to iterate till last
	 * element for each outer loop
	 */
	private static void bubbleSort(int[] arr) {

		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = 0; j < arr.length - 1 - i; j++) {
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}
	}

	/**
	 * Time complexity: O(logn) 
	 * Space compexity: O(1) 
	 * 
	 * Note: while caculating midIndex
	 * dont use average of si and ei as in case even one of them has
	 * Integer.MAX_VALUE the sum of si + ei will become -ve, whilch makes mid index
	 * -ve and causes ArrayIndexOutOfBonds
	 */
	private static int binarySearch(int[] arr, int num) {
		int startIndex = 0;
		int endIndex = arr.length - 1;

		while (startIndex <= endIndex) {
			int midIndex = startIndex + ((endIndex - startIndex) / 2);
			if (arr[midIndex] < num) {
				startIndex = midIndex + 1;
			} else if (arr[midIndex] > num) {
				endIndex = midIndex - 1;
			} else {
				return midIndex;
			}
		}

		return -1;
	}

	/**
	 * Time complexity: O(n) 
	 * Space complexity: O(1)
	 */
	private static void sort01(int[] arr) {
		int startIndex = 0;
		int endIndex = arr.length - 1;

		while (startIndex < endIndex) {
			if (arr[startIndex] == 0) {
				startIndex++;
			} else if (arr[endIndex] == 1) {
				endIndex--;
			} else {
				arr[startIndex++] = 0;
				arr[endIndex--] = 1;
			}
		}

	}

	private static void pairSum(int[] arr, int num) {
		pairSumByHashMap(arr, num);
		pairSumBySort(arr, num);
	}

	/**
	 * time complexity: n * log(n) + n => O(n * log(n)) 
	 * space complexity: O(1)
	 */
	private static void pairSumBySort(int[] arr, int num) {
		Arrays.sort(arr);
		int i = 0, j = arr.length - 1, pairCount = 0;
		while (i < j) {
			int x = arr[i], y = arr[j];
			if (arr[i] + arr[j] < num) {
				i++;
			} else if (arr[i] + arr[j] > num) {
				j--;
			} else {
				int part1Count = 1, part2Count = 1;
				int startIndex = i, endIndex = j;
				while (arr[startIndex] == arr[startIndex + 1] && startIndex + 1 < endIndex) {
					part1Count++;
					startIndex++;
				}
				while (arr[endIndex] == arr[endIndex - 1] && startIndex < endIndex - 1) {
					part2Count++;
					endIndex--;
				}

				i += part1Count;
				j -= part2Count;

				int totalCount = part1Count + part2Count;
				if (x == y) {
					pairCount += ((totalCount - 1) * totalCount) / 2;

				} else {
					pairCount += part1Count * part2Count;
				}
			}
		}
		System.out.println(pairCount);

	}

	/**
	 * time complexity: O(n) 
	 * space complexity: O(n)
	 */
	private static void pairSumByHashMap(int[] arr, int num) {
		int pairCount = 0;
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int a : arr) {
			if (map.containsKey(num - a)) {
				System.out.println("pair found! ->" + a + " " + (num - a));
				pairCount += map.get(num - a);
			}
			if (map.containsKey(a)) {
				map.put(a, map.get(a) + 1);
			} else {
				map.put(a, 1);
			}
		}
		System.out.println("ans: " + pairCount);
	}

	private static void intersection(int[] arr1, int[] arr2) {
		Arrays.sort(arr1);
		Arrays.sort(arr2);

		int i = 0, j = 0;
		while (i < arr1.length && j < arr2.length) {
			if (arr1[i] > arr2[j]) {
				j++;
			} else if (arr1[i] < arr2[j]) {
				i++;
			} else {
				System.out.println(arr1[i]);
				i++;
				j++;
			}
		}

	}

	private static void arrange(int[] arr, int max) {
		int val = 1;
		int i = 0;
		int j = arr.length - 1;

		while (i <= j) {
			if (i == j) {
				arr[i++] = val++;
			} else {
				arr[i++] = val++;
				arr[j--] = val++;
			}
		}

	}

	private static void inverse(int[] arr) {
		int i = 0;
		int j = arr.length - 1;
		while (i < j) {
			int temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
			i++;
			j--;
		}

	}

	private static void swapAlternate(int[] arr) {
		for (int i = 0; i < arr.length - 1; i += 2) {
			int temp = arr[i];
			arr[i] = arr[i + 1];
			arr[i + 1] = temp;
		}

	}

}
