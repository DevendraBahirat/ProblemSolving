package arrays_strings;

/**
 * Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.
 * <p>
 * Note: You may not slant the container and n is at least 2.
 * <p>
 * Example:
 * <p>
 * Input: [1,8,6,2,5,4,8,3,7]
 * Output: 49
 */
public class ContainerWithMostWater {

	public static void main(String[] args) {
		int[] input = {1, 8, 6, 2, 5, 4, 8, 3, 7};
		System.out.println(maxArea(input));
	}

	static int maxArea(int[] height) {
		int left = 0, right = height.length - 1, result = 0;
		while (left < right) {
			int temp = Math.min(height[left], height[right]) * (right - left);
			if (temp > result) {
				result = temp;
			}
			if (height[left] < height[right]) {
				left++;
			} else {
				right--;
			}
		}
		return result;
	}
}
