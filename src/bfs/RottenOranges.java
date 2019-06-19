package bfs;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Given a matrix of dimension m*n where each cell in the matrix can have values 0, 1 or 2 which has the following meaning:
 * 0: Empty cell
 * 1: Cells have fresh oranges
 * 2: Cells have rotten oranges
 * <p>
 * So we have to determine what is the minimum time required so that all the oranges become rotten. A rotten orange at index [i,j]
 * can rot other fresh orange at indexes [i-1,j], [i+1,j], [i,j-1], [i,j+1] (up, down, left and right). If it is impossible to rot
 * every orange then simply return -1.
 * <p>
 * Examples:
 * <p>
 * Input:  arr[][C] = { {2, 1, 0, 2, 1},
 * {1, 0, 1, 2, 1},
 * {1, 0, 0, 2, 1}};
 * Output:
 * All oranges can become rotten in 2 time frames.
 * <p>
 * <p>
 * Input:  arr[][C] = { {2, 1, 0, 2, 1},
 * {0, 0, 1, 2, 1},
 * {1, 0, 0, 2, 1}};
 * Output:
 * All oranges cannot be rotten.
 */

public class RottenOranges {

	public static void main(String[] args) {
		int[][] oranges = new int[][]{
			{2, 1, 0, 2, 1},
			{1, 0, 1, 2, 1},
			{1, 0, 0, 2, 1}
		};

		int[][] input = {
			{2, 1, 0, 2, 1},
			{0, 0, 1, 2, 1},
			{1, 0, 0, 2, 1}
		};

		System.out.println(findTimeToRotAllOranges(oranges));
		System.out.println(findTimeToRotAllOranges(input));
	}

	static class Orange {
		int x, y;

		Orange(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static int[] rowNum = {0, -1, 0, 1};
	static int[] colNum = {-1, 0, 1, 0};

	static boolean isValid(int row, int col, int maxRow, int maxCol) {
		return row >= 0 && row < maxRow && col >= 0 && col < maxCol;
	}

	private static int findTimeToRotAllOranges(int[][] oranges) {
		int count = 0;
		Queue<Orange> queue = new ArrayDeque<>();
		for (int i = 0; i < oranges.length; i++) {
			for (int j = 0; j < oranges[0].length; j++) {
				if (oranges[i][j] == 2) {
					queue.add(new Orange(i, j));
				} else if (oranges[i][j] == 1) {
					count++;
				}
			}
		}

		int time = 0;
		while (!queue.isEmpty()) {
			int size = queue.size();
			boolean flag = false;
			for (int m = 0; m < size; m++) {
				Orange current = queue.remove();
				for (int k = 0; k < 4; k++) {
					int tempRow = current.x + rowNum[k];
					int tempCol = current.y + colNum[k];
					if (isValid(tempRow, tempCol, oranges.length, oranges[0].length) && oranges[tempRow][tempCol] == 1) {
						oranges[tempRow][tempCol] = 2;
						queue.add(new Orange(tempRow, tempCol));
						count--;
						flag = true;
					}
				}
			}
			if (flag) {
				time++;
			}
		}
		return count > 0 ? -1 : time;
	}
}
