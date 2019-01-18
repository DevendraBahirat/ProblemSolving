package math;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 *
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 * Example:
 *
 * Given input = [2, 7, 11, 15], target = 9,
 *
 * Because input[0] + input[1] = 2 + 7 = 9,
 * return [0, 1].
 */
public class TwoSum {

	public static int[] twoSum(int[] input, int target) {
		Map<Integer, Integer> sumMap = new HashMap<>();
		int[] result = new int[2];
		for (int i=0; i<input.length; i++) {
			if (sumMap.containsKey(target - input[i])) {
				result[0] = i;
				result[1] = sumMap.get(target - input[i]);

			} else {
				sumMap.put(input[i], i);
			}
		}
		return result;
	}

	public static void main(String[] args) {
		int[] input = {2, 7, 11, 15};
		int target = 9;
		System.out.println(Arrays.toString(twoSum(input, target)));
	}
}
