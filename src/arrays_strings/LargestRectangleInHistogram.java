package arrays_strings;

import java.util.Stack;

/**
 * Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area of largest rectangle in the histogram.
 * <p>
 * Example:
 * <p>
 * Input: [2,1,5,6,2,3]
 * Output: 10
 */

public class LargestRectangleInHistogram {

	public static void main(String[] args) {
		int[] input = {2, 1, 5, 6, 2, 3};
		System.out.println(largestRectangleArea(input));
	}

	static int largestRectangleArea(int[] heights) {
		int maxArea = 0, area, i;
		Stack<Integer> stack = new Stack<>();

		for (i = 0; i < heights.length; ) {
			if (stack.isEmpty() || heights[stack.peek()] <= heights[i]) {
				stack.push(i);
				i++;
			} else {
				int top = stack.pop();

				if (stack.isEmpty()) {
					area = heights[top] * i;
				} else {
					area = heights[top] * (i - stack.peek() - 1);
				}
				if (area > maxArea) {
					maxArea = area;
				}
			}
		}
		while (!stack.isEmpty()) {
			int top = stack.pop();
			if (stack.isEmpty()) {
				area = heights[top] * i;
			} else {
				area = heights[top] * (i - stack.peek() - 1);
			}
			if (area > maxArea) {
				maxArea = area;
			}
		}
		return maxArea;
	}
}
