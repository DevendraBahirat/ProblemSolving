package arrays_strings;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of positive and negative numbers, find if there is a sub array (of size at-least one) with 0 sum.
 * Examples :
 * <p>
 * Input: {4, 2, -3, 1, 6}
 * Output: true {1,3}
 * There is a sub array with zero sum from index 1 to 3.
 * <p>
 * Input: {4, 2, 0, 1, 6}
 * Output: true {2,2}
 * There is a sub array with zero sum from index 2 to 2.
 * <p>
 * Input: {-3, 2, 3, 1, 6}
 * Output: false {-1,-1}
 * There is no sub array with zero sum.
 */

public class ZeroSumSubArray {

	public static void main(String[] args) {
		int[] input1 = {4, 2, -3, 1, 6};
		int[] input2 = {4, 2, 0, 1, 6};
		int[] input3 = {-3, 2, 3, 1, 6};
		int[] input4 = {0, 2, 3, 1, 6};

		System.out.println(Arrays.toString(zeroSumSubArray(input1)));
		System.out.println(Arrays.toString(zeroSumSubArray(input2)));
		System.out.println(Arrays.toString(zeroSumSubArray(input3)));
		System.out.println(Arrays.toString(zeroSumSubArray(input4)));
	}

	static int[] zeroSumSubArray(int[] input) {
		Map<Integer, Integer> sums = new HashMap<>();
		int sum = 0;
		for (int i = 0; i <= input.length; i++) {
			Integer oldIndex = sums.get(sum);
			if (oldIndex == null && i == input.length) {
				return new int[]{-1, -1};
			} else if (oldIndex == null) {
				sums.put(sum, i);
				sum += input[i];
			} else {
				return new int[]{oldIndex, i-1};
			}
		}
		return new int[]{-1, -1};
	}
}
