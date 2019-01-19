package matrix;

/**
 * Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in-place.
 * <p>
 * Example 1:
 * <p>
 * Input:
 * [
 * [1,1,1],
 * [1,0,1],
 * [1,1,1]
 * ]
 * Output:
 * [
 * [1,0,1],
 * [0,0,0],
 * [1,0,1]
 * ]
 * Example 2:
 * <p>
 * Input:
 * [
 * [0,1,2,0],
 * [3,4,5,2],
 * [1,3,1,5]
 * ]
 * Output:
 * [
 * [0,0,0,0],
 * [0,4,5,0],
 * [0,3,1,0]
 * ]
 * Follow up:
 * <p>
 * A straight forward solution using O(mn) space is probably a bad idea.
 * A simple improvement uses O(m + n) space, but still not the best solution.
 * Could you devise a constant space solution?
 */

public class SetMatrixZeros {

	public static void main(String[] args) {
		int[][] input1 = {
			{1, 1, 1},
			{1, 0, 1},
			{1, 1, 1}
		};

		int[][] input2 = {
			{0, 1, 2, 0},
			{3, 4, 5, 2},
			{1, 3, 1, 5}
		};

		print(setZeroes(input1));
	}

	static void print(int[][] mat) {
		for (int i=0; i<mat.length; i++) {
			for (int j=0; j<mat[0].length; j++) {
				System.out.print(mat[i][j] + " ");
			}
			System.out.println("");
		}
	}

	static int[][] setZeroes(int[][] matrix) {
		boolean firstRowFlag = false;
		boolean firstColFlag = false;

		for (int rowElement : matrix[0]) {
			if (rowElement == 0) {
				firstRowFlag = true;
				break;
			}
		}

		for (int[] col : matrix) {
			if (col[0] == 0) {
				firstColFlag = true;
				break;
			}
		}

		for (int i=1; i<matrix.length; i++) {
			for (int j=1; j<matrix[0].length; j++) {
				if (matrix[i][j] == 0) {
					matrix[i][0] = 0;
					matrix[0][j] = 0;
				}
			}
		}

		for (int i=1; i<matrix.length; i++) {
			for (int j=1; j<matrix[0].length; j++) {
				if(matrix[0][j] == 0 || matrix[i][0] == 0) {
					matrix[i][j] = 0;
				}
			}
		}
		if(firstRowFlag) {
			for (int i=0; i<matrix[0].length; i++) {
				matrix[0][i] = 0;
			}
		}

		if(firstColFlag) {
			for (int i = 0; i < matrix.length; i++) {
				matrix[i][0] = 0;
			}
		}
		return matrix;
	}
}
