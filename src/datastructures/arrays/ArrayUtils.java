package datastructures.arrays;

import java.util.Scanner;

public class ArrayUtils {

	public static int[] takeInput() {
		int[] arr;
		try(Scanner scn = new Scanner(System.in)) {
			int n = scn.nextInt();
			arr = new int[n];
			for(int i = 0; i < n; i++) {
				arr[i] = scn.nextInt();
			}
		}
		
		return arr;
	}
	
	public static void print(int[] arr) {
		for(int val : arr) {
			System.out.print(val + " ");
		}
		System.out.println();
	}

	public static void print(String[] arr) {
		for(String val : arr) {
			System.out.println(val);
		}
		System.out.println();
	}
}
