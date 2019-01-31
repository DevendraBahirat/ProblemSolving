package dynamic_programming;

/**
 * You are given coins of different denominations and a total amount of money. Write a function to compute the number of
 * combinations that make up that amount. You may assume that you have infinite number of each kind of coin.
 *
 * Example 1:
 *
 * Input: amount = 5, coins = [1, 2, 5]
 * Output: 4
 * Explanation: there are four ways to make up the amount:
 * 5=5
 * 5=2+2+1
 * 5=2+1+1+1
 * 5=1+1+1+1+1
 *
 *  Example 2:
 *
 * Input: amount = 3, coins = [2]
 * Output: 0
 * Explanation: the amount of 3 cannot be made up just with coins of 2.
 *
 * Example 3:
 *
 * Input: amount = 10, coins = [10]
 * Output: 1
 */
public class CoinChange2 {

	static int change(int amount, int[] coins) {
		if (amount == 0 && coins.length == 0) {
			return 1;
		} else if (coins.length == 0) {
			return 0;
		}

		int[][] table = new int[coins.length + 1][amount + 1];
		for (int i = 0; i<=coins.length; i++) {
			table[i][0] = 1;
		}

		for (int i=1; i<=coins.length; i++) {
			for (int j=1; j<= amount; j++) {
				table[i][j] = table[i-1][j];
				if (j - coins[i-1] >=0) {
					table[i][j] += table[i][j - coins[i-1]];
				}
			}
		}

		return table[coins.length][amount];
	}

	public static void main(String[] args) {
		int[] coins = {1,2,5};
		int amount = 5;
		System.out.println(change(amount, coins));
	}
}
