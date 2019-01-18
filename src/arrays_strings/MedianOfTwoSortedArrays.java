package arrays_strings;

/**
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 *
 * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 *
 * You may assume nums1 and nums2 cannot be both empty.
 *
 * Example 1:
 *
 * nums1 = [1, 3]
 * nums2 = [2]
 *
 * The median is 2.0
 * Example 2:
 *
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 *
 * The median is (2 + 3)/2 = 2.5
 */
@SuppressWarnings("ALL")
public class MedianOfTwoSortedArrays {
	public static void main(String[] args) {
		int[] input1 = {1, 3, 8, 9, 15};
		int[] input2 = {7, 11, 18, 19, 21, 25};

		int[] input3 = {3, 5, 7, 9, 11, 16};
		int[] input4 = {23, 26, 31, 35};

		int[] input5 = {1,3};
		int[] input6 = {2};

		System.out.println(findMedian(input1, input2));
		System.out.println(findMedian(input3, input4));
		System.out.println(findMedian(input5, input6));
	}

	private static double findMedian(int[] input1, int[] input2) {
		if (input1.length > input2.length) {
			return findMedian(input2, input1);
		}

		if (input1.length == 0) {
			if (input2.length > 0) {
				int mid = input2.length / 2;
				if (input2.length % 2 == 0) {
					return (input2[mid - 1] + input2[mid]) / 2d;
				} else {
					return input2[mid];
				}
			}
			return Double.NEGATIVE_INFINITY;
		}

		int start = 0;
		int end = input1.length;
		while (start <= end) {
			int partitionX = (start + end) / 2;
			int partitionY = ((input1.length + input2.length + 1) / 2) - partitionX;

			int maxLeftX = partitionX == 0 ? Integer.MIN_VALUE : input1[partitionX - 1];
			int maxLeftY = partitionY == 0 ? Integer.MIN_VALUE : input2[partitionY - 1];

			int minRightX = partitionX == input1.length ? Integer.MAX_VALUE : input1[partitionX];
			int minRightY = partitionY == input2.length ? Integer.MAX_VALUE : input2[partitionY];

			if (maxLeftX <= minRightY && maxLeftY <= minRightX) {
				if ((input1.length + input2.length) % 2 == 0) {
					return (Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY)) / 2d;
				} else {
					return Math.max(maxLeftX, maxLeftY);
				}
			} else {
				if (maxLeftX > minRightY) {
					end = partitionX - 1;
				} else {
					start = partitionX + 1;
				}
			}

		}

		return Double.NEGATIVE_INFINITY;
	}
}
