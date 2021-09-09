package datastructures.arrays;

import java.util.Scanner;

public class Array2D {

	static Scanner scn = new Scanner(System.in);
	
	
	public static void main(String[] args) {
//		int t = 1;
		int t = scn.nextInt();
		while(t-- > 0) {
			int[][] arr = takeInput();
//			rowWiseSum(arr);
//			findLargest(arr);
//			wavePrint(arr);
			spiral(arr);
		}

	}
	
	

	private static void spiral(int[][] arr) {
		if(arr.length == 0) return;
		
		int totalCount = arr.length * arr[0].length;
		int currCount = 0;
		int top = 0;
		int bottom = arr.length -1;
		int left = 0;
		int right = arr[0].length -1;
	
		while(currCount != totalCount) {
			
			for(int i = left; i <= right && currCount != totalCount; i++) {
				System.out.print(arr[top][i] + " ");
				currCount++;
			}
			top++;
			
			for(int i = top; i <= bottom && currCount != totalCount; i++) {
				System.out.print(arr[i][right] + " ");
				currCount++;
			}
			right--;
			
			for(int i = right; i >= left && currCount != totalCount; i--) {
				System.out.print(arr[bottom][i] + " ");
				currCount++;
			}
			bottom--;
			
			for(int i = bottom; i >= top && currCount != totalCount; i--) {
				System.out.print(arr[i][left] + " ");
				currCount++;
			}
			left++;
			
		}
	}



	private static void wavePrint(int[][] arr) {
		boolean upSteame = false;
		for(int j = 0; j < arr[0].length; j++) {
			if(upSteame) {
				for(int i = arr.length - 1; i >= 0 ; i--) {
					System.out.print(arr[i][j] + " ");
				}
			} else {
				for(int i = 0; i < arr.length; i++) {
					System.out.print(arr[i][j] + " ");					
				}
			}
			upSteame = !upSteame;
		}
		
	}



	private static void findLargest(int[][] arr) {
		int[] rowSum = new int[arr.length];
		int[] colSum = new int[arr[0].length];
		
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr[0].length; j++) {
				rowSum[i] += arr[i][j];
				colSum[j] += arr[i][j];
			}
		}
		
		int maxRowSum = Integer.MIN_VALUE;
		int maxRowSumIndex = 0;
		for(int i = 0; i < rowSum.length; i++) {
			if(maxRowSum < rowSum[i]) {
				maxRowSum = rowSum[i];
				maxRowSumIndex = i;
			}
		}

		int maxColSum = Integer.MIN_VALUE;
		int maxColSumIndex = 0;
		for(int i = 0; i < colSum.length; i++) {
			if(maxColSum < colSum[i]) {
				maxColSum = colSum[i];
				maxColSumIndex = i;
			}
		}
		
		if(maxRowSum >= maxColSum) {
			System.out.println("row " + maxRowSumIndex + " " + maxRowSum);
		} else {
			System.out.println("column " + maxColSumIndex + " " + maxColSum);			
		}
	}



	private static void rowWiseSum(int[][] arr) {
		
		for(int i = 0; i < arr.length; i++) {			
			int sum = 0;
			for(int j = 0; j < arr[i].length ; j++) {
				sum += arr[i][j];
			}
			System.out.print(sum + " ");
		}
	}

	private static int[][] takeInput() {
		int n = scn.nextInt();
		int m = scn.nextInt();
		int[][] arr = new int[n][m];
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				arr[i][j] = scn.nextInt();
			}
		}
		
		return arr;
	}

}
