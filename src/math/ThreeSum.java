package math;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the
 * array which gives the sum of zero.
 * <p>
 * Note:
 * The solution set must not contain duplicate triplets.
 * <p>
 * Example:
 * <p>
 * Given array nums = [-1, 0, 1, 2, -1, -4],
 * <p>
 * A solution set is:
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 */

public class ThreeSum {

	public static void main(String[] args) {
		int[] input = {-1, 0, 1, 2, -1, -4};
		System.out.println(threeSum(input));
	}

	static List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		Arrays.sort(nums);
		for (int i = 0; i < nums.length - 1; i++) {
			int l = i + 1, r = nums.length - 1, x = nums[i];
			while (l < r) {
				int tempSum = x + nums[l] + nums[r];
				if (tempSum == 0) {
					List<Integer> triplet = new ArrayList<>();
					triplet.add(x);
					triplet.add(nums[l]);
					triplet.add(nums[r]);
					if (!result.contains(triplet)) {
						result.add(triplet);
					}
					l++;
					r--;
				} else if (tempSum < 0) {
					l++;
				} else {
					r--;
				}
			}
		}
		return result;
	}
}
