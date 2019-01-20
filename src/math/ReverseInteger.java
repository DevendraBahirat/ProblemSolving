package math;

/**
 * Given a 32-bit signed integer, reverse digits of an integer.
 *
 * Example 1:
 *
 * Input: 123
 * Output: 321
 * Example 2:
 *
 * Input: -123
 * Output: -321
 * Example 3:
 *
 * Input: 120
 * Output: 21
 * Note:
 * Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range:
 * [−231,  231 −1].
 * For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.
 */

public class ReverseInteger {

	public static void main(String[] args) {
		int input1 = 123, input2 = -123, input3 = 120;
		System.out.println(reverse(input1));
		System.out.println(reverse(input2));
		System.out.println(reverse(input3));
	}

	static int reverse(int x) {
		Long result = 0L;
		int res = 0;
		long temp = Math.abs(x);

		while (temp != 0) {
			result *= 10;
			result += temp%10;
			temp /= 10;
		}

		if(x < 0) {
			result *= -1;
		}

		if (result >= Integer.MIN_VALUE && result <= Integer.MAX_VALUE) {
			res = result.intValue();
		}

		return res;
	}
}
