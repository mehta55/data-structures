package datastructures.basics;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.OptionalInt;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Set;

public class Basic {

	public static void main(String args[]) {
//		printPrimes();
//		nthFibonaci();
//		trailingZeroes();
//		System.out.println(isFibonaci(6));
//		reverseNumber();
//		decToBin();
//		checkSeq();

//		System.out.println(sol1(new int[] {3, 0, 5}));
//		System.out.println(sol3("zyzyzyz"));
//		System.out.println(sol2(new int[] {1,2,1}, new int[] {2,3,3}));

//		String input = "abc";
//		 for(int i = 0; i < input.length(); i++)
//		    {
//		        for(int j = i + 1; j <= input.length(); j++)
//		        {
//		            if (i != j) {
//		            	String subs = input.substring(i, j);
//		            	System.out.println(subs);
//		            }
//		            	
//		        }
//		    }
//		 System.out.println("--------------------------");
//		addSubstringsToFreq(input, ""); 

		System.out.println("012.12".matches("^[0-9]+(\\.[0-9]+)?$"));
	}

	private static boolean sol2(int[] v, int[] e) {
		Set<Integer> visited = new HashSet<>();
		HashMap<Integer, Integer> index = new HashMap<>();
		for (int i = 0; i < v.length; i++) {
			index.put(v[i], i);
		}
		int currV = v[0];
		while (visited.size() != v.length) {
			visited.add(currV);
			int nextIndex = index.getOrDefault(currV, -1);
			if (nextIndex != -1 && nextIndex < e.length) {
				int nextV = e[nextIndex];
				if (visited.contains(nextV) && visited.size() == v.length) {
					return true;
				} else if (visited.contains(nextV)) {
					return false;
				} else
					currV = nextV;
			} else {
				return false;
			}
		}

		return false;
	}

	private static int sol3(String input) {

		Map<String, Integer> freq = new HashMap<>();
//		addSubstringsToFreq(input, "", freq);

		for (int i = 0; i < input.length(); i++) {
			for (int j = i + 1; j <= input.length(); j++) {
				if (i != j) {
					String subs = input.substring(i, j);
					freq.put(subs, freq.getOrDefault(subs, 0) + 1);
				}

			}
		}

		OptionalInt optAns = freq.entrySet().stream().filter(entry -> entry.getValue().equals(1))
				.filter(entry -> !entry.getKey().isEmpty()).map(Entry::getKey).mapToInt(String::length).min();

		return optAns.orElse(-1);
	}

	private static void addSubstringsToFreq(String input, String output) {
		if (input.length() == 0) {
			System.out.println(output);
			return;
		}

		addSubstringsToFreq(input.substring(1), output + input.substring(0, 1));
		addSubstringsToFreq(input.substring(1), output);
	}

	private static int sol1(int[] arr) {
		PriorityQueue<Double> pq = new PriorityQueue<>(arr.length, Collections.reverseOrder());
		double sum = 0;
		for (int x : arr) {
			sum += x;
			pq.add((double) x);
		}

		int filterCount = 0;
		double desiredSum = sum / 2;
		while (sum > desiredSum) {
			filterCount++;
			double x = pq.poll();
			x = x / 2;
			sum -= x;
			pq.add(x);
		}

		return filterCount;
	}

	private static void checkSeq() {
		try (Scanner scn = new Scanner(System.in)) {
			int n = scn.nextInt();
			int change = 0;
			int prev = scn.nextInt();
			boolean inc = false;
			while (n-- > 1) {
				int cur = scn.nextInt();

				if (cur > prev && !inc) {
					change++;
					inc = true;
				} else if (cur < prev && inc) {
					change++;
					inc = false;
				}
				prev = cur;
			}
			System.out.println(change <= 1);
//			System.out.println(change);
		}

	}

	private static void decToBin() {
		try (Scanner scn = new Scanner(System.in)) {
			int n = scn.nextInt();
			long bin = 0;
			long pow = 0;
			while (n > 0) {
				bin += (long) Math.pow(10, pow) * (n % 2);
				n = n / 2;
				pow++;
			}
			System.out.println(bin);
		}

	}

	private static void reverseNumber() {
		try (Scanner scn = new Scanner(System.in)) {
			int n = scn.nextInt();
			int reverse = 0;
			while (n > 0) {
				reverse = (reverse * 10) + (n % 10);
				n = n / 10;
			}
			System.out.println(reverse);
		}

	}

	private static boolean isFibonaci(int n) {
		int prev = 1;
		int cur = 1;

		while (cur < n) {
			int temp = cur;
			cur += prev;
			prev = temp;
		}

		return cur == n;
	}

	private static void trailingZeroes() {
		try (Scanner scn = new Scanner(System.in)) {
			int n = scn.nextInt();
			int zeros = 0;
			for (int i = 5; i <= n; i *= 5) {
				zeros += n / i;
			}
			System.out.println(zeros);
		}
	}

	// 1 1 2 3 5 8
	private static void nthFibonaci() {
		try (Scanner scn = new Scanner(System.in)) {
			int n = scn.nextInt();

			if (n <= 2) {
				System.out.println(1);
			} else {
				int fibn = 1;
				int fibn_1 = 1;

				for (int i = 3; i <= n; i++) {
					int temp = fibn;
					fibn += fibn_1;
					fibn_1 = temp;
				}
				System.out.println(fibn);
			}
		}
	}

	private static void printPrimes() {
		try (Scanner scn = new Scanner(System.in)) {
			int n = scn.nextInt();
			for (int i = 2; i <= n; i++) {
				if (isPrime(i)) {
					System.out.println(i);
				}
			}
		}

	}

	private static boolean isPrime(int n) {

		for (int i = 2; i <= Math.sqrt(n); i++) {
			if (n % i == 0) {
				return false;
			}
		}

		return true;
	}
}
