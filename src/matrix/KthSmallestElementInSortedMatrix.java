package matrix;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class KthSmallestElementInSortedMatrix {

	public static void main(String[] args) {
		int[][] input = {
			{1, 5, 9},
			{10, 11, 13},
			{12, 13, 15}
		};

		System.out.println(kthSmallest(input, 8));
	}

	static class Position {
		int row, col, val;

		Position(int row, int col, int val) {
			this.row = row;
			this.col = col;
			this.val = val;
		}
	}

	static int kthSmallest(int[][] matrix, int k) {
		int result = 0;
		if (matrix.length == 0 || k > matrix.length * matrix.length) {
			return -1;
		}
		Queue<Position> queue = new PriorityQueue<>(new Comparator<Position>() {
			@Override
			public int compare(Position o1, Position o2) {
				if (o1.val > o2.val) {
					return 1;
				} else if (o2.val > o1.val) {
					return -1;
				}
				return 0;
			}
		});

		for (int i = 0; i < matrix.length; i++) {
			queue.add(new Position(0, i, matrix[0][i]));
		}

		for (int j = k; j > 0; j--) {
			Position min = queue.remove();
			result = min.val;
			if (min.row < matrix.length - 1) {
				queue.add(new Position(min.row + 1, min.col, matrix[min.row + 1][min.col]));
			}
		}
		return result;
	}
}
