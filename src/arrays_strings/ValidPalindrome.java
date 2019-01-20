package arrays_strings;

/**
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
 *
 * Note: For the purpose of this problem, we define empty string as valid palindrome.
 *
 * Example 1:
 *
 * Input: "A man, a plan, a canal: Panama"
 * Output: true
 * Example 2:
 *
 * Input: "race a car"
 * Output: false
 */

public class ValidPalindrome {

	public static void main(String[] args) {
		String input1 = "A man, a plan, a canal: Panama";
		String input2 = "race a car";
		String input3 = "0P";
		System.out.println(isPalindrome(input1));
		System.out.println(isPalindrome(input2));
		System.out.println(isPalindrome(input3));
	}

	static boolean isPalindrome(String s) {
		if(s.isEmpty()) {
			return true;
		}

		s = s.toLowerCase();
		int left = 0, right = s.length() -1;

		while (left <= right) {
			char leftChar = s.charAt(left);
			char rightChar = s.charAt(right);
			if ((leftChar < '0' || leftChar > '9') && (leftChar < 'a' || leftChar > 'z')  ) {
				left++;
			} else if ((rightChar < '0' || rightChar > '9') && (rightChar < 'a' || rightChar > 'z')) {
				right--;
			} else if (leftChar == rightChar){
				left++; right--;
			} else {
				return false;
			}
		}
		return true;
	}
}
