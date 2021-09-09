package datastructures.heap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Problems {

	public static void main(String args[]) {
		int[] arr = new int[] {3, 9, 4};
//		implementationMaxHeap();
//		implementationMinHeap();
//		heapSort(arr);
//		kLargest(arr, 5);
//		System.out.println(checkMaxHeap(arr));
//		kthLargest(arr, 4);		
//		System.out.println(mergeKSortedArrays(prepareInput()));
//		findMedian(arr);
		buyTicket(arr, 2);
		
		
//		print(arr);
	}
	

	private static void buyTicket(int[] arr, int k) {
		Queue<Integer> queue = new LinkedList<>();
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		
		for (int i = 0; i < arr.length; i++) {
			queue.add(i);
			pq.add(arr[i]);
		}
		
		int time = 0;
		while (!queue.isEmpty()) {
			int curr = queue.poll();
			if (arr[curr] == pq.peek()) {
				pq.poll();
				time++;
				if (curr == k) {
					break;
				}
			} else {
				queue.add(curr);
			}
		}
		
		System.out.println(time);
	}


	private static void findMedian(int[] arr) {
		PriorityQueue<Integer> minpq = new PriorityQueue<>();
		PriorityQueue<Integer> maxpq = new PriorityQueue<>(Collections.reverseOrder());
		
		for (int i = 0; i < arr.length; i++) {
			int x = arr[i];
			
			if (maxpq.isEmpty() || x < maxpq.peek()) {
				maxpq.add(x);
			} else {
				minpq.add(x);
			}
			
			if (maxpq.size() - minpq.size() > 1) {
				minpq.add(maxpq.poll());
			} else if (minpq.size() - maxpq.size() > 1) {
				maxpq.add(minpq.poll());
			}
			
			if ((i + 1) % 2 == 0) {
				System.out.println((maxpq.peek() + minpq.peek())/2);
			} else {
				System.out.println(maxpq.size() > minpq.size() ? maxpq.peek() : minpq.peek());
			}
		}
	}


	static class Triplet<K, V, B> {

		private K key;
		private V value;
		private B meta;

		public Triplet(K key, V value, B meta) {
			this.key = key;
			this.value = value;
			this.meta = meta;
		}

		public K getKey() {
			return key;
		}

		public V getValue() {
			return value;
		}

		public B getMeta() {
			return meta;
		}

	}

	public static ArrayList<Integer> mergeKSortedArrays(ArrayList<ArrayList<Integer>> input) {

		ArrayList<Integer> ans = new ArrayList<>();
		Comparator<Triplet<Integer, Integer, Integer>> priorityComparator = (e1, e2) -> e1.getKey()
				.compareTo(e2.getKey());
		
		PriorityQueue<Triplet<Integer, Integer, Integer>> pq = new PriorityQueue<>(priorityComparator);

		for (int i = 0; i < input.size(); i++) {
			ArrayList<Integer> list = input.get(i);
			int x = list.get(0);
			pq.add(new Triplet<>(x, i, 0));
		}

		while (!pq.isEmpty()) {
			Triplet<Integer, Integer, Integer> element = pq.poll();
			ans.add(element.getKey());

			int listIndex = element.getValue();
			int nextElementIndex = element.getMeta() + 1;

			if (nextElementIndex < input.get(listIndex).size()) {
				pq.add(new Triplet<>(input.get(listIndex).get(nextElementIndex), listIndex, nextElementIndex));
			}
		}

		return ans;
	}

	private static void kthLargest(int[] arr, int k) {
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int i = 0; i < arr.length; i++) {
			if (i < k) {
				pq.add(arr[i]);
			} else {
				pq.add(arr[i]);
				pq.poll();
			}
		}

		System.out.println(pq.peek());
	}

	private static boolean checkMaxHeap(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			int parentIndex = i;
			int childIndexLeft = 2 * parentIndex + 1;
			int childIndexRight = 2 * parentIndex + 2;
			if ((childIndexLeft < arr.length && arr[childIndexLeft] > arr[parentIndex])
					|| (childIndexRight < arr.length && arr[childIndexRight] > arr[parentIndex])) {
				return false;
			}
		}

		return true;
	}

	private static void kLargest(int[] arr, int k) {
		PriorityQueue<Integer> pq = new PriorityQueue<>();

		for (int i = 0; i < arr.length; i++) {
			if (i < k) {
				pq.add(arr[i]);
			} else {
				pq.add(arr[i]);
				pq.poll();
			}
		}

		ArrayList<Integer> ans = new ArrayList<>(pq);
		System.out.println(ans);
	}

	private static void print(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}

	private static void heapSort(int[] arr) {

		for (int i = 1; i < arr.length; i++) {
			int childIndex = i;
			int parentIndex = (childIndex - 1) / 2;
			while (parentIndex >= 0 && arr[parentIndex] < arr[childIndex]) {
				int temp = arr[parentIndex];
				arr[parentIndex] = arr[childIndex];
				arr[childIndex] = temp;
				childIndex = parentIndex;
				parentIndex = (childIndex - 1) / 2;
			}
		}

		int size = arr.length;
		for (int i = 0; i < arr.length - 1; i++) {
			int max = arr[0];
			arr[0] = arr[size - 1];
			arr[size - 1] = max;
			size--;

			int parentIndex = 0;
			while (parentIndex < size) {
				int childIndexLeft = (parentIndex * 2) + 1;
				int childIndexRight = (parentIndex * 2) + 2;
				int childIndex = -1;
				if (childIndexLeft < size && childIndexRight < size) {
					childIndex = arr[childIndexLeft] > arr[childIndexRight] ? childIndexLeft : childIndexRight;
				} else if (childIndexLeft < size) {
					childIndex = childIndexLeft;
				} else if (childIndexRight < size) {
					childIndex = childIndexRight;
				}

				if (childIndex != -1 && arr[childIndex] > arr[parentIndex]) {
					int temp = arr[childIndex];
					arr[childIndex] = arr[parentIndex];
					arr[parentIndex] = temp;
					parentIndex = childIndex;
				} else {
					break;
				}
			}
		}

	}

	private static void implementationMinHeap() {
		try {
			MinPQ pq = new MinPQ();
			pq.add(5);
			pq.add(15);
			pq.add(52);
			pq.add(55);
			pq.add(25);
			pq.add(57);

			while (!pq.isEmpty()) {
				System.out.println(pq.poll());
			}
		} catch (Exception e) {
		}

	}

	private static void implementationMaxHeap() {
		MaxPQ pq = new MaxPQ();
		pq.add(1);
		pq.add(15);
		pq.add(5);
		pq.add(51);
		pq.add(52);
		pq.add(57);
		pq.add(51);
		pq.add(50);

		while (!pq.isEmpty()) {
			System.out.println(pq.poll());
		}

	}
	
	private static ArrayList<ArrayList<Integer>> prepareInput() {
		ArrayList<Integer> arr1 = new ArrayList<>();
		arr1.add(1);
		arr1.add(5);
		arr1.add(12);
		arr1.add(15);
		arr1.add(16);
		ArrayList<Integer> arr2 = new ArrayList<>();
		arr2.add(2);
		arr2.add(16);
		arr2.add(91);
		arr2.add(110);
		arr2.add(111);
		ArrayList<Integer> arr3 = new ArrayList<>();
		arr3.add(3);
		arr3.add(7);
		arr3.add(10);
		ArrayList<Integer> arr4 = new ArrayList<>();
		arr4.add(4);
		arr4.add(8);
		arr4.add(9);
		ArrayList<ArrayList<Integer>> input = new ArrayList<>();
		input.add(arr4);
		input.add(arr3);
		input.add(arr2);
		input.add(arr1);
		return input;
	}
}
