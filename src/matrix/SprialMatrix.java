package matrix;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
 *
 * Example 1:
 *
 * Input:
 * [
 *  [ 1, 2, 3 ],
 *  [ 4, 5, 6 ],
 *  [ 7, 8, 9 ]
 * ]
 * Output: [1,2,3,6,9,8,7,4,5]
 * Example 2:
 *
 * Input:
 * [
 *   [1, 2, 3, 4],
 *   [5, 6, 7, 8],
 *   [9,10,11,12]
 * ]
 * Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 */
public class SprialMatrix {

	public static void main(String[] args) {
		int[][] input = {
			{1, 2, 3},
			{4, 5, 6},
			{7, 8, 9}
		};

		System.out.println(spiralOrder(input));
	}

	static List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> result = new ArrayList<>();
		if (matrix.length == 0 || matrix[0].length == 0) {
			return result;
		}
		int top = 0, left = 0, bottom = matrix.length - 1, right = matrix[0].length - 1;
		int direction = 0;
		while (top <= bottom && left <= right) {
			switch (direction) {
				case 0:
					for (int i = left; i <= right; i++) {
						result.add(matrix[top][i]);
					}
					top++;
					direction = 1;
					break;
				case 1:
					for (int i = top; i <= bottom; i++) {
						result.add(matrix[i][right]);
					}
					right--;
					direction = 2;
					break;
				case 2:
					for (int i = right; i >= left; i--) {
						result.add(matrix[bottom][i]);
					}
					bottom--;
					direction = 3;
					break;
				case 3:
					for (int i = bottom; i >= top; i--) {
						result.add(matrix[i][left]);
					}
					left++;
					direction = 0;
					break;
			}
		}

		return result;
	}
}