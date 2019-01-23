package dynamic_programming;

import java.util.Arrays;

/**
 * You are given coins of different denominations and a total amount of money amount. Write a function to compute the fewest
 * number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the
 * coins, return -1.
 * <p>
 * Example 1:
 * <p>
 * Input: coins = [1, 2, 5], amount = 11
 * Output: 3
 * Explanation: 11 = 5 + 5 + 1
 * Example 2:
 * <p>
 * Input: coins = [2], amount = 3
 * Output: -1
 */
public class CoinChange {

	public static void main(String[] args) {
		int[] coins = {1, 2, 5};
		int amount = 11;

		int[] coins1 = { 2};
		int amount1 = 3;
		System.out.println(coinChange(coins, amount));
		System.out.println(coinChange(coins1, amount1));
	}

	static int coinChange(int[] coins, int amount) {
		if (coins.length == 0) {
			return -1;
		}

		int[] result = new int[amount + 1];
		result[0] = 0;
		for (int i = 1; i < result.length; i++) {
			result[i] = Integer.MAX_VALUE;
		}

		for (int j = 1; j < result.length; j++) {
			for (int coin : coins) {
				if (j - coin >= 0) {
					int temp = result[j - coin];
					if(temp < Integer.MAX_VALUE) {
						temp += 1;
					}
					result[j] = Math.min(temp, result[j]);
				}
			}
		}
		System.out.println(Arrays.toString(result));
		return result[amount] != Integer.MAX_VALUE ? result[amount] : -1;
	}
}
