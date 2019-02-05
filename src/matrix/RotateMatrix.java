package matrix;

/**
 * You are given an n x n 2D matrix representing an image.
 * <p>
 * Rotate the image by 90 degrees (clockwise).
 * <p>
 * Note:
 * <p>
 * You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another
 * 2D matrix and do the rotation.
 * <p>
 * Example 1:
 * <p>
 * Given input matrix =
 * [
 * [1,2,3],
 * [4,5,6],
 * [7,8,9]
 * ],
 * <p>
 * rotate the input matrix in-place such that it becomes:
 * [
 * [7,4,1],
 * [8,5,2],
 * [9,6,3]
 * ]
 * Example 2:
 * <p>
 * Given input matrix =
 * [
 * [ 5, 1, 9,11],
 * [ 2, 4, 8,10],
 * [13, 3, 6, 7],
 * [15,14,12,16]
 * ],
 * <p>
 * rotate the input matrix in-place such that it becomes:
 * [
 * [15,13, 2, 5],
 * [14, 3, 4, 1],
 * [12, 6, 8, 9],
 * [16, 7,10,11]
 * ]
 */
public class RotateMatrix {

	static void print(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		int[][] matrix = {
			{1, 2, 3, 4, 5, 6},
			{7, 8, 9, 10, 11, 12},
			{13, 14, 15, 16, 17, 18},
			{19, 20, 21, 22, 23, 24},
			{25, 26, 27, 28, 29, 30},
			{31, 32, 33, 34, 35, 36}
		};

		rotate(matrix);
	}

	static void rotate(int[][] matrix) {
		int rows = matrix.length - 1;
		for (int i = 0; i < matrix.length / 2; i++) {
			for (int j = i; j < matrix[0].length - 1 - i; j++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[rows - j][i];
				matrix[rows - j][i] = matrix[rows - i][rows - j];
				matrix[rows - i][rows - j] = matrix[j][rows - i];
				matrix[j][rows - i] = temp;
			}
		}
		print(matrix);
	}
}
