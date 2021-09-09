package datastructures.recursion;

public class Recursion {

	public static void main(String args[]) {
		int x = 3;
		int n = 3;
		int[] arr = { 1, 2, 3, 4, 3, 5 };
		String str = "uiaahua";
		String[] ans = new String[0];

//		System.out.println(power(x, n));
//		System.out.println(sum(n));
//		System.out.println(sum(arr));
//		System.out.println(checkNumber(arr, x));
//		System.out.println(firstIndex(arr, x));
//		int[] ans = allIndexes(arr, x);
//		System.out.println(multiplyTwoIntegers(x, n));
//		System.out.println(countZerosRec(n));
//		System.out.println(findGeometricSum(n));
//		System.out.println(isStringPalindrome(str));
//		System.out.println(sumOfDigits(n));
//		System.out.println(replace(str));
//		System.out.println(removeX(str));
//		System.out.println(convertStringToInt(str));
//		System.out.println(addStars(str));
//		System.out.println(replaceCharacter(str, 'a', 'x'));
//		System.out.println(removeConsecutiveDuplicates(str));
		
		
//		ArrayUtils.print(ans);
	}


	private static String removeConsecutiveDuplicates(String str) {
		if(str.length() == 1) {
			return str;
		}
		String smallAns = removeConsecutiveDuplicates(str.substring(1));
		return str.charAt(0) == smallAns.charAt(0) ? smallAns : str.charAt(0) + smallAns;
	}


	private static String replaceCharacter(String str, char c1, char c2) {
		if(str.length() == 0) {
			return str;
		}
		char ch = str.charAt(0) == c1 ? c2 : str.charAt(0);
		return ch + replaceCharacter(str.substring(1), c1, c2);
	}


	private static String addStars(String str) {
		if(str.length() == 1) {
			return str;
		}
		String smallAns = addStars(str.substring(1));
		if(smallAns.length() != 0) {
			String ans = str.charAt(0) == smallAns.charAt(0) 
					? str.charAt(0) + "*" + smallAns
					: str.charAt(0) + smallAns;
			return ans;
		} else {
			return smallAns;
		}
	}

	private static int convertStringToInt(String str) {
		if(str.length() == 0) {
			return 0;
		}
		int smallAns = ((int)str.charAt(0) - 48) * ((int)Math.pow(10, str.length() - 1)); 
		return smallAns + convertStringToInt(str.substring(1));
	}

	private static String removeX(String str) {
		if(str.length() == 0) {
			return new String();
		}
		String ch = str.charAt(0) == 'x' ? "" : str.substring(0, 1);
		return ch + removeX(str.substring(1));
	}

	private static String replace(String str) {
		if(str.length() < 2) {
			return str;
		}
		
		if(str.substring(0, 2).equals("pi")) {
			return "3.14" + replace(str.substring(2));
		}
		return str.charAt(0) + replace(str.substring(1));
	}

	private static int sumOfDigits(int n) {
		if(n < 10) {
			return n;
		}
		return n % 10 + sumOfDigits(n / 10);
	}

	private static boolean isStringPalindrome(String str) {
		if(str.length() < 2) {
			return true;
		} 
		
		return str.charAt(0) ==  str.charAt(str.length() - 1) 
				? isStringPalindrome(str.substring(1, str.length() -1)) 
				: false;
	}

	private static double findGeometricSum(int n) {
		if(n == 0) {
			return 1;
		}
		
		double sum = 1.0 / (Math.pow(2, n));
		return sum + findGeometricSum(n - 1);
	}

	private static int countZerosRec(int n) {
		if(n < 10) {
			return n == 0 ? 1 : 0;
		}
		return n % 10 == 0 ? 1 + countZerosRec(n / 10) 
						 : countZerosRec(n / 10);
	}

	private static int multiplyTwoIntegers(int m, int n) {
		return n == 1 ? m : m + multiplyTwoIntegers(m, n - 1);
	}

	private static int[] allIndexes(int[] arr, int x) {
		return allIndexes(arr, x, 0);
	}

	private static int[] allIndexes(int[] arr, int x, int index) {
		
		if(arr.length == index) {
			return new int[0];
		}
		int[] smallans = allIndexes(arr, x, index + 1);
		if(arr[index] == x) {
			return addElement(smallans, index);
			
		}
		return smallans;
	}

	private static int[] addElement(int[] oldArr, int element) {
		int[] newArr = new int[oldArr.length + 1];
		for(int i = 0; i < oldArr.length; i++) {
			newArr[i + 1] = oldArr[i];
		}
		newArr[0] = element;
		return newArr;
	}

	private static int firstIndex(int[] arr, int x) {
		return firstIndex(arr, x, 0);
	}

	private static int firstIndex(int[] arr, int x, int index) {
		if(arr.length == index) {
			return -1;
		} 
		return arr[index] == x ? index : firstIndex(arr, x, index + 1);
	}

	private static int lastIndex(int[] arr, int x) {
		return lastIndex(arr, x, arr.length - 1);
	}
	
	private static int lastIndex(int[] arr, int x, int index) {
		if(index == -1) {
			return -1;
		} 
		return arr[index] == x ? index : lastIndex(arr, x, index - 1);
	}

	private static boolean checkNumber(int[] arr, int x) {
		return checkNumber(arr, x, 0); 
	}

	private static boolean checkNumber(int[] arr, int x, int index) {
		if(arr.length == index) {
			return false;
		} 
		
		return arr[index] == x ? true : checkNumber(arr, x, index + 1);
	}

	private static int sum(int[] arr) {
		return sum(arr, 0);
	}

	private static int sum(int[] arr, int index) {
		return arr.length == index ? 0 : arr[index] + sum(arr, index + 1);
	}

	private static int sum(int n) {
		return n == 1 ? 1 : n + sum(n - 1);
	}

	private static int power(int x, int n) {
		return n == 0 ? 1 : x * power(x, n - 1);
	}

}