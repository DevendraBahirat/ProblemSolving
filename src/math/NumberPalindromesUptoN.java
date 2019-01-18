package math;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Find all numbers less than n, which are palindromic. Numbers can be printed in any order.
 * <p>
 * Examples :
 * <p>
 * Input : n = 12
 * Output : 1, 2, 3, 4, 5, 6, 7, 8, 9, 11
 * <p>
 * Input : n = 104
 * Output : 1, 2, 3, 4, 5, 6, 7, 8, 9, 11,
 * 22, 33, 44, 55, 66, 77, 88, 99, 101
 *
 * Brute Force:
 * We check all the numbers from 1 to n whether its decimal representation is palindrome or not.
 *
 * Efficient Approach:
 * We start from 1 and create palindromes of odd digit and even digits up to n. For every number (starting from 1), we append its
 * reverse at end if we need even length palindrome numbers. For odd length palindrome, we append reverse of all
 * digits except last one.
 */

@SuppressWarnings("SpellCheckingInspection")
public class NumberPalindromesUptoN {

	public static void main(String[] args) {
		int input = 114;
		System.out.println(generateAllPalindromes(input));
	}

	private static List<Integer> generateAllPalindromes(int input) {
		List<Integer> result = new ArrayList<>();

		for (int i = 0; i < 2; i++) {
			int j = 1;
			int number;
			while ((number = createPalindrome(j, i % 2 == 1)) < input) {
				result.add(number);
				j++;
			}
		}
		Collections.sort(result);
		return result;
	}

	private static int createPalindrome(int input, boolean shouldGenerateOddLength) {
		int n = input;
		int palindrome = input;

		if (shouldGenerateOddLength) {
			n /= 10;
		}

		while (n > 0) {
			palindrome = palindrome * 10 + (n % 10);
			n /= 10;
		}
		return palindrome;
	}
}
