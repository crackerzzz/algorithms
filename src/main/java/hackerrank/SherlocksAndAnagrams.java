package hackerrank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SherlocksAndAnagrams {
	/***
	 * Returns all substring of given string.
	 * 
	 * @param str given string
	 * @return List of substrings
	 */
	public static List<String> getSubstrings(String str) {
		final int N = str.length();
		final List<String> lst = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			for (int j = i + 1; j <= N; j++) {
				lst.add(str.substring(i, j));
			}
		}
		return lst;
	}

	/***
	 * Checks if given strings s1 and s2 are anagrams.
	 * 
	 * @param s1 first string
	 * @param s2 second string
	 * @return true if s1 and s2 are anagrams, false otherwise
	 * 
	 */
	public static boolean isAnagram(String s1, String s2) {
		if (s1.length() != s2.length()) {
			return false;
		}

		final char[] s1Arr = s1.toCharArray();
		final char[] s2Arr = s2.toCharArray();

		// input string only contains lower case characters
		final int[] arr = new int[26];
		for (int i = 0; i < s1Arr.length; i++) {
			arr[s1Arr[i] - 97]++;
			arr[s2Arr[i] - 97]--;
		}

		return Arrays.stream(arr)
			.allMatch(c -> c == 0);
	}

	public static int findAnagrams(List<String> substrList) {
		final String[] substr = substrList.toArray(new String[0]);
		int count = 0;
		for (int i = 0; i < substr.length; i++) {
			for (int j = i + 1; j < substr.length; j++) {
				if (isAnagram(substr[i], substr[j])) {
					count++;
				}
			}
		}
		return count;
	}

	public static void main(String[] args) {
		System.out.println(getSubstrings("abba"));
//		System.out.println(isAnagram("abba", "baba"));
		System.out.println(findAnagrams(getSubstrings("abba")));
	}
}
