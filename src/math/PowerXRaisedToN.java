package math;

/**
 * Implement pow(x, n), which calculates x raised to the power n (xn).
 * <p>
 * Example 1:
 * <p>
 * Input: 2.00000, 10
 * Output: 1024.00000
 * Example 2:
 * <p>
 * Input: 2.10000, 3
 * Output: 9.26100
 * Example 3:
 * <p>
 * Input: 2.00000, -2
 * Output: 0.25000
 * Explanation: 2-2 = 1/22 = 1/4 = 0.25
 * Note:
 * <p>
 * -100.0 < x < 100.0
 * n is a 32-bit signed integer, within the range [−2^31, 2^31 − 1]
 */

public class PowerXRaisedToN {

	public static void main(String[] args) {
		System.out.println(myPow(2.0, 10));
		System.out.println(myPow(2.1, 3));
		System.out.println(myPow(2.0, -2));
	}

	static double myPow(double x, int n) {
		if (n == 0) {
			return 1;
		}
		double temp = myPow(x, n / 2);
		if (n % 2 == 0) {
			return temp * temp;
		} else {
			if (n > 0) {
				return x * temp * temp;
			} else {
				return (temp * temp) / x;
			}
		}
	}
}