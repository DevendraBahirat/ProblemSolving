package arrays_strings;

import java.util.Arrays;

/**
 * Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.
 * <p>
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * <p>
 * If the target is not found in the array, return [-1, -1].
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [5,7,7,8,8,10], target = 8
 * Output: [3,4]
 * Example 2:
 * <p>
 * Input: nums = [5,7,7,8,8,10], target = 6
 * Output: [-1,-1]
 */

public class FirstAndLastPositionInSortedArray {

	public static void main(String[] args) {
		int[] nums = {5, 7, 7, 8, 8, 10};
		int target1 = 8, target2 = 6;
		System.out.println(Arrays.toString(searchRange(nums, target1)));
		System.out.println(Arrays.toString(searchRange(nums, target2)));
	}

	static int[] searchRange(int[] nums, int target) {
		if (nums.length == 0) {
			return new int[]{-1, -1};
		}
		int high = nums.length - 1, low = 0;

		int[] firstIndex = binarySearch(nums, target, low, high);
		while (firstIndex[0] - 1 >= 0 && target == nums[firstIndex[0] - 1]) {
			firstIndex = binarySearch(nums, target, firstIndex[1], firstIndex[0] - 1);
		}

		int[] lastIndex = binarySearch(nums, target, low, high);
		while (lastIndex[0] + 1 < nums.length && target == nums[lastIndex[0] + 1]) {
			lastIndex = binarySearch(nums, target, lastIndex[0] + 1, lastIndex[2]);
		}
		return new int[]{firstIndex[0], lastIndex[0]};
	}

	private static int[] binarySearch(int[] nums, int target, int low, int high) {
		int[] result = {-1, -1, -1};
		int mid = (high + low) / 2;
		if (low > high) {
			return result;
		}
		if (nums[mid] == target) {
			return new int[]{mid, low, high};
		} else if (nums[mid] > target) {
			return binarySearch(nums, target, low, mid - 1);
		} else {
			return binarySearch(nums, target, mid + 1, high);
		}
	}
}
