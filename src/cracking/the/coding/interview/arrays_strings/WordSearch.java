package cracking.the.coding.interview.arrays_strings;


/**
 * Given a 2D board and a word, find if the word exists in the grid.
 * <p>
 * The word can be constructed from letters of sequentially adjacent cell,
 * where "adjacent" cells are those horizontally or vertically neighboring.
 * The same letter cell may not be used more than once.
 * <p>
 * Example:
 * <p>
 * board =
 * [
 * ['A','B','C','E'],
 * ['S','F','C','S'],
 * ['A','D','E','E']
 * ]
 * <p>
 * Given word = "ABCCED", return true.
 * Given word = "SEE", return true.
 * Given word = "ABCB", return false.
 */
public class WordSearch {

	public static void main(String[] args) {
		char[][] board = new char[][]
			{
				{'A', 'B', 'C', 'E'},
				{'S', 'F', 'C', 'S'},
				{'A', 'D', 'E', 'E'}
			};
		String word1 = "ABCCED";
		String word2 = "SEE";
		String word3 = "ABCB";

		System.out.println(word1 + " --> " + exist(board, word1));
		System.out.println(word2 + " --> " + exist(board, word2));
		System.out.println(word3 + " --> " + exist(board, word3));
	}

	private static boolean exist(char[][] board, String word) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (dfs(board, word, i, j, 0)) {
					return true;
				}
			}
		}

		return false;
	}

	private static boolean dfs(char[][] board, String word, int i, int j, int k) {
		if (board[i][j] != word.charAt(k)) {
			return false;
		}

		if (k >= word.length() - 1) {
			return true;
		}

		int[] di = {-1, 0, 1, 0};
		int[] dj = {0, 1, 0, -1};

		char t = board[i][j];
		board[i][j] = '#';

		for (int m = 0; m < 4; m++) {
			int pi = i + di[m];
			int pj = j + dj[m];
			if (pi >= 0 && pi < board.length && pj >= 0 && pj < board[0].length && board[pi][pj] == word.charAt(k + 1)) {
				if (dfs(board, word, pi, pj, k + 1)) {
					return true;
				}
			}
		}

		board[i][j] = t;

		return false;
	}
}
