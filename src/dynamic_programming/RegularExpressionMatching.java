package dynamic_programming;

/**
 * Given an input string (s) and a pattern (p), implement regular expression matching with support for '.' and '*'.
 * <p>
 * '.' Matches any single character.
 * '*' Matches zero or more of the preceding element.
 * The matching should cover the entire input string (not partial).
 * <p>
 * Note:
 * <p>
 * s could be empty and contains only lowercase letters a-z.
 * p could be empty and contains only lowercase letters a-z, and characters like . or *.
 * Example 1:
 * <p>
 * Input:
 * s = "aa"
 * p = "a"
 * Output: false
 * Explanation: "a" does not match the entire string "aa".
 * Example 2:
 * <p>
 * Input:
 * s = "aa"
 * p = "a*"
 * Output: true
 * Explanation: '*' means zero or more of the precedeng element, 'a'. Therefore, by repeating 'a' once, it becomes "aa".
 * Example 3:
 * <p>
 * Input:
 * s = "ab"
 * p = ".*"
 * Output: true
 * Explanation: ".*" means "zero or more (*) of any character (.)".
 * Example 4:
 * <p>
 * Input:
 * s = "aab"
 * p = "c*a*b"
 * Output: true
 * Explanation: c can be repeated 0 times, a can be repeated 1 time. Therefore it matches "aab".
 * Example 5:
 * <p>
 * Input:
 * s = "mississippi"
 * p = "mis*is*p*."
 * Output: false
 */
public class RegularExpressionMatching {

	public static void main(String[] args) {
		String string1 = "aa";
		String pattern1 = "a";
		System.out.println(isMatch(string1, pattern1));

		String string2 = "aa";
		String pattern2 = "a*";
		System.out.println(isMatch(string2, pattern2));

		String string3 = "aab";
		String pattern3 = "c*a*b";
		System.out.println(isMatch(string3, pattern3));

		String string4 = "ab";
		String pattern4 = ".*";
		System.out.println(isMatch(string4, pattern4));

		String string5 = "mississippi";
		String pattern5 = "mis*is*p*.";
		System.out.println(isMatch(string5, pattern5));


	}

	static boolean isMatch(String string, String pattern) {
		boolean[][] table = new boolean[string.length() + 1][pattern.length() + 1];

		if (!pattern.isEmpty() && pattern.charAt(0) == '*') {
			return false;
		}

		table[0][0] = true;
		//handle cases like a*, a*b*, a*b*c*
		for (int i = 1; i < table[0].length; i++) {
			if (pattern.charAt(i - 1) == '*') {
				table[0][i] = table[0][i - 2];
			}
		}

		for (int i = 1; i < table.length; i++) {
			for (int j = 1; j < table[0].length; j++) {
				if (pattern.charAt(j - 1) == '.' || string.charAt(i - 1) == pattern.charAt(j - 1)) {
					table[i][j] = table[i - 1][j - 1];
				} else if (pattern.charAt(j - 1) == '*') {
					table[i][j] = table[i][j-2];
					if (pattern.charAt(j-2) == '.' || pattern.charAt(j-2) == string.charAt(i-1)) {
						table[i][j] = table[i][j] | table[i-1][j];
					}
				} else {
					table[i][j] = false;
				}
			}
		}

		return table[string.length()][pattern.length()];
	}
}
