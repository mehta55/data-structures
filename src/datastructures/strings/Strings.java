package datastructures.strings;

public class Strings {

	public static void main(String args[]) {
		String str = "abaa";
		String str1 = "avdf";
		String str2 = "agvd";
		
//		System.out.println(isPalindrome(str));
//		System.out.println(replaceCharacter(str, 'b', 'x'));
//		printSubstrings(str);
//		System.out.println(reverseEachWord(str));
//		System.out.println(minLengthWord(str));
//		System.out.println(reverseWordWise(str));
//		System.out.println(isPermutation(str1, str2));
//		System.out.println(removeConsecutiveDuplicates(str));
//		System.out.println(removeAllOccurrencesOfChar(str, 'c'));
//		System.out.println(highestOccuringChar(str));
//		System.out.println(getCompressedString(str));
		System.out.println(countPalindromeSubstrings(str));
	}


	private static int countPalindromeSubstrings(String str) {
		int count = 0;
		
		for(int i = 0; i < str.length(); i++) {
			count++;
			int leftIndex = i - 1;
			int rightIndex = i + 1;
			while(leftIndex >= 0 && rightIndex < str.length() && str.charAt(leftIndex) == str.charAt(rightIndex)) {
				count++;
				leftIndex--;
				rightIndex++;
			}
		}
		
		for(int i = 0; i < str.length() - 1; i++) {
			if(str.charAt(i) == str.charAt(i + 1)) {
				count++;
				int leftIndex = i - 1;
				int rightIndex = i + 2;
				while(leftIndex >= 0 && rightIndex < str.length() && str.charAt(leftIndex) == str.charAt(rightIndex)) {
					count++;
					leftIndex--;
					rightIndex++;
				}
			}
		}
		
		return count;
	}


	private static String getCompressedString(String str) {
		String ans = str.substring(0, 1);
		int occ = 1;
		
		for(int i = 1; i < str.length(); i++) {
			char ch = str.charAt(i);
			if(ch == ans.charAt(ans.length() -1)) {
				occ++;
			} else {
				ans += occ == 1 ? str.substring(i, i + 1) : (occ + str.substring(i, i + 1));
				occ = 1;
			}
		}
			
		return occ == 1 ? ans : ans + occ;
	}


	private static char highestOccuringChar(String str) {
		int[] freq = new int[256];
		int maxFreq = -1;
		for(char ch : str.toCharArray()) {
			freq[ch]++;
			if(freq[ch] > maxFreq) {
				maxFreq = freq[ch];
			}
		}
		for(int i = 0; i < str.length(); i++) {
			if(freq[str.charAt(i)] == maxFreq) {
				return str.charAt(i);
			}
		}
		
		return '\0';
	}


	private static String removeAllOccurrencesOfChar(String str, char c) {
		String ans = new String();
		for(int i = 0; i < str.length(); i++) {
			if(str.charAt(i) != c) {
				ans += str.charAt(i);
			}
		}
		return ans;
	}


	private static String removeConsecutiveDuplicates(String str) {
		String ans = str.substring(0,1);
		for(int i = 1; i < str.length(); i++) {
			if(str.charAt(i) != ans.charAt(ans.length() - 1)) {
				ans += str.charAt(i);
			}
		}
		return ans;
	}


	private static boolean isPermutation(String str1, String str2) {
		if(str1.length() != str2.length()) 
			return false;
		
		int[] freq = new int[256];
		for(char ch : str1.toCharArray()) {
			freq[ch]++;
		}
		for(char ch: str2.toCharArray()) {
			freq[ch]--;
		}
		for(int i : freq) {
			if(i != 0) 
				return false;
		}
		
		return true;
	}


	private static String reverseWordWise(String str) {
		String revStr = "";
		String word = "";
		
		for(int i = 0; i < str.length(); i++) {
			if(str.charAt(i) == ' ') {
				revStr = str.charAt(i) + word +  revStr;
				word = "";
			} else {
				word = word + str.charAt(i);
			}
		}
		return word +  revStr;
	}


	private static String minLengthWord(String str) {
		str += " ";
		String smallestStr = "";
		String currStr = "";
		
		for(int i = 0; i < str.length(); i++) {
			if(str.charAt(i) == ' ') {
				if(smallestStr.length() == 0 || smallestStr.length() > currStr.length()) {
					smallestStr = currStr;
				}
				currStr = "";
			} else {
				currStr += str.charAt(i);
			}
		}
		
		return smallestStr;
	}


	private static String reverseEachWord(String str) {
		String revStr = "";
		String revWord = "";
		
		for(int i = 0; i < str.length(); i++) {
			if(str.charAt(i) == ' ') {
				revStr = revStr + revWord + str.charAt(i) ;
				revWord = "";
			} else {
				revWord = str.charAt(i) + revWord;
			}
		}
		return revStr + revWord;
	}


	private static void printSubstrings(String str) {
		for(int i = 0; i < str.length(); i++) {
			for(int size = 1; i + size <= str.length(); size++) {
				System.out.println(str.substring(i, i + size));
			}
		}
		
	}


	private static String replaceCharacter(String str, char c1, char c2) {
		String ans = "";
		for (int i = 0; i < str.length(); i++) {
			ans += str.charAt(i) == c1 ? c2 : str.charAt(i);
		}
		return ans;

	}

	private static boolean isPalindrome(String str) {
		int i = 0, j = str.length() - 1;

		while (i < j) {
			if (str.charAt(i++) != str.charAt(j--)) {
				return false;
			}
		}
		return true;
	}
}
