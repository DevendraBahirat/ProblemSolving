package matrix;

/**
 * Determine if a 9x9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:
 * <p>
 * Each row must contain the digits 1-9 without repetition.
 * Each column must contain the digits 1-9 without repetition.
 * Each of the 9 3x3 sub-boxes of the grid must contain the digits 1-9 without repetition.
 * <p>
 * A partially filled sudoku which is valid.
 * <p>
 * The Sudoku board could be partially filled, where empty cells are filled with the character '.'.
 * <p>
 * Example 1:
 * <p>
 * Input:
 * [
 * ["5","3",".",".","7",".",".",".","."],
 * ["6",".",".","1","9","5",".",".","."],
 * [".","9","8",".",".",".",".","6","."],
 * ["8",".",".",".","6",".",".",".","3"],
 * ["4",".",".","8",".","3",".",".","1"],
 * ["7",".",".",".","2",".",".",".","6"],
 * [".","6",".",".",".",".","2","8","."],
 * [".",".",".","4","1","9",".",".","5"],
 * [".",".",".",".","8",".",".","7","9"]
 * ]
 * Output: true
 * Example 2:
 * <p>
 * Input:
 * [
 * ["8","3",".",".","7",".",".",".","."],
 * ["6",".",".","1","9","5",".",".","."],
 * [".","9","8",".",".",".",".","6","."],
 * ["8",".",".",".","6",".",".",".","3"],
 * ["4",".",".","8",".","3",".",".","1"],
 * ["7",".",".",".","2",".",".",".","6"],
 * [".","6",".",".",".",".","2","8","."],
 * [".",".",".","4","1","9",".",".","5"],
 * [".",".",".",".","8",".",".","7","9"]
 * ]
 * Output: false
 * Explanation: Same as Example 1, except with the 5 in the top left corner being
 * modified to 8. Since there are two 8's in the top left 3x3 sub-box, it is invalid.
 * <p>
 * Example 3:
 * [
 * [".",".",".",".",".",".",".",".","."],
 * [".",".",".","3",".",".","5",".","."],
 * [".",".",".",".",".",".",".",".","."],
 * [".",".",".","8",".",".",".",".","."],
 * [".",".",".",".","1","1","6",".","."],
 * [".",".",".",".",".",".",".",".","."],
 * [".",".",".",".",".",".","1",".","."],
 * [".",".",".",".",".",".",".",".","7"],
 * [".",".",".",".",".",".",".","4","."]
 * ]
 * <p>
 * Note:
 * <p>
 * A Sudoku board (partially filled) could be valid but is not necessarily solvable.
 * Only the filled cells need to be validated according to the mentioned rules.
 * The given board contain only digits 1-9 and the character '.'.
 * The given board size is always 9x9.
 */
public class ValidSudoku {

	static boolean isValidSudoku(char[][] board) {
		int[] rows = new int[9];
		int[] cols = new int[9];
		int[] squares = new int[9];

		for (int row = 0; row < board.length; row++) {
			for (int col = 0; col < board[0].length; col++) {
				if (board[row][col] == '.') {
					continue;
				}
				int val = 1 << (board[row][col] - '1');
				if ((val & rows[row]) > 0) return false;
				if ((val & cols[col]) > 0) return false;
				if ((val & squares[3 * (row / 3) + col / 3]) > 0) return false;

				rows[row] |= val;
				cols[col] |= val;
				squares[3 * (row / 3) + col / 3] |= val;
			}
		}
		return true;
	}


	public static void main(String[] args) {
		char[][] board1 = new char[][]{
			{'5', '3', '.', '.', '7', '.', '.', '.', '.'},
			{'6', '.', '.', '1', '9', '5', '.', '.', '.'},
			{'.', '9', '8', '.', '.', '.', '.', '6', '.'},
			{'8', '.', '.', '.', '6', '.', '.', '.', '3'},
			{'4', '.', '.', '8', '.', '3', '.', '.', '1'},
			{'7', '.', '.', '.', '2', '.', '.', '.', '6'},
			{'.', '6', '.', '.', '.', '.', '2', '8', '.'},
			{'.', '.', '.', '4', '1', '9', '.', '.', '5'},
			{'.', '.', '.', '.', '8', '.', '.', '7', '9'}
		};

		char[][] board2 = new char[][]{
			{'8', '3', '.', '.', '7', '.', '.', '.', '.'},
			{'6', '.', '.', '1', '9', '5', '.', '.', '.'},
			{'.', '9', '8', '.', '.', '.', '.', '6', '.'},
			{'8', '.', '.', '.', '6', '.', '.', '.', '3'},
			{'4', '.', '.', '8', '.', '3', '.', '.', '1'},
			{'7', '.', '.', '.', '2', '.', '.', '.', '6'},
			{'.', '6', '.', '.', '.', '.', '2', '8', '.'},
			{'.', '.', '.', '4', '1', '9', '.', '.', '5'},
			{'.', '.', '.', '.', '8', '.', '.', '7', '9'}
		};

		char[][] board3 = new char[][]{
			{'.', '.', '.', '.', '.', '.', '.', '.', '.'},
			{'.', '.', '.', '3', '.', '.', '5', '.', '.'},
			{'.', '.', '.', '.', '.', '.', '.', '.', '.'},
			{'.', '.', '.', '8', '.', '.', '.', '.', '.'},
			{'.', '.', '.', '.', '1', '1', '6', '.', '.'},
			{'.', '.', '.', '.', '.', '.', '.', '.', '.'},
			{'.', '.', '.', '.', '.', '.', '1', '.', '.'},
			{'.', '.', '.', '.', '.', '.', '.', '.', '7'},
			{'.', '.', '.', '.', '.', '.', '.', '4', '.'}
		};

		System.out.println(isValidSudoku(board1));
		System.out.println(isValidSudoku(board2));
		System.out.println(isValidSudoku(board3));
	}
}
