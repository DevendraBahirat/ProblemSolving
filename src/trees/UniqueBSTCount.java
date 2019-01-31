package trees;

/**
 * Given n, how many structurally unique BST's (binary search trees) that store values 1 ... n?
 *
 * Example:
 *
 * Input: 3
 * Output: 5
 * Explanation:
 * Given n = 3, there are a total of 5 unique BST's:
 *
 *    1         3     3      2      1
 *     \       /     /      / \      \
 *      3     2     1      1   3      2
 *     /     /       \                 \
 *    2     1         2                 3
 */

public class UniqueBSTCount {

	public static void main(String[] args) {
		System.out.println(numTrees(3));
		System.out.println(numTrees(5));
	}

	static int numTrees(int n) {
		int[] table = new int[n+1];
		table[0] = 1;
		table[1] = 1;

		for (int i = 2; i<=n; i++) {
			for (int j = 1; j<=i; j++) {
				table[i] += table[j - 1] * table[i-j];
			}
		}
		return table[n];
	}
}
