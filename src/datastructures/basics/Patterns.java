package datastructures.basics;

import java.util.Scanner;

public class Patterns {

	public static void main(String args[]) {
//		pattern1();
//		pattern2();
//		pattern3();
//		pattern4();
//		pattern5();
//		pattern6();
		pattern7();
	}
	
	private static void pattern7() {
		try(Scanner scn = new Scanner(System.in)) {
			int n = scn.nextInt();
			int counter = n;
			int delta = 1;
			for(int i = 1; i <= n; i++) {
				counter -= i - 1;
				for(int j = 1; j <= n; j++) {
					if(i == j) {
						delta = 0;
					}
					System.out.print(counter);
					counter += delta;
				}
				System.out.println();
				delta = 1;
			}
		
		}
	
	}

//	*
//	 * *
//	   * * *
//	     * * * *
//	   * * *
//	 * *
//	*
	private static void pattern6() {
		try(Scanner scn = new Scanner(System.in)) {
			int n = scn.nextInt();
			int counter = 1;
			int delta = 1;
			
			for(int i = 1; i <= n; i++) {
				
				for(int j = 1; j <= counter - 1 ; j++)
					System.out.print("  ");
				for(int k = 1; k <= counter; k++)
					System.out.print("* ");
				
				if(i == n/2 + 1) {
					delta = -1;
				}
				counter += delta;
				System.out.println();
			}
		}
		
	}

//	1234
//	123
//	12
//	1
	private static void pattern5() {
		try (Scanner scn = new Scanner(System.in)) {
			int n = scn.nextInt();
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					System.out.print(j);
					if(j > n - i) {
						break;
					}
				}
				System.out.println();
			}
		}

	}

//    1
//   232
//  34543
// 4567654
//567898765
	private static void pattern4() {
		try (Scanner scn = new Scanner(System.in)) {
			int n = scn.nextInt();
			for (int i = 0; i < n; i++) {
				int counter = i + 1;
				for (int j = 0; j < n; j++) {
					if (i >= n - 1 - j) {
						System.out.print(counter++);
					} else
						System.out.print(" ");
				}
				counter -= 2;
				for (int k = 0; k < n; k++) {
					if (k < i) {
						System.out.print(counter--);
					} else {
						break;
					}
				}
				System.out.println();
			}
		}
	}

//    *
//   *** 
//  *****
// *******
	private static void pattern3() {
		try (Scanner scn = new Scanner(System.in)) {
			int n = scn.nextInt();
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (i >= n - 1 - j) {
						System.out.print("*");
					} else
						System.out.print(" ");
				}
				for (int k = 0; k < n; k++) {
					if (k < i) {
						System.out.print("*");
					} else {
						break;
					}
				}
				System.out.println();
			}
		}
	}


//    1
//   23
// 	345
// 4567
//56789
	private static void pattern2() {
		try (Scanner scn = new Scanner(System.in)) {
			int n = scn.nextInt();
			for (int i = 0; i < n; i++) {
				int counter = i + 1;
				for (int j = 0; j < n; j++) {
					if (i >= n - 1 - j) {
						System.out.print(counter++);
					} else {
						System.out.print(" ");
					}
				}
				System.out.println();
			}
		}

	}

//	1
//	23
//	345
	private static void pattern1() {
		try (Scanner scn = new Scanner(System.in)) {
			int n = scn.nextInt();
			for (int i = 0; i < n; i++) {
				int counter = i + 1;
				for (int j = 0; j < n; j++) {
					System.out.print(counter++);
					if (i == j) {
						System.out.println();
						break;
					}
				}
			}
		}

	}
}
