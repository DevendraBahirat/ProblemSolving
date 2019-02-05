package dynamic_programming;

/**
 * Say you have an array for which the ith element is the price of a given stock on day i.
 *
 * Design an algorithm to find the maximum profit. You may complete at most k transactions.
 *
 * Note:
 * You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 *
 * Example 1:
 *
 * Input: [2,4,1], k = 2
 * Output: 2
 * Explanation: Buy on day 1 (price = 2) and sell on day 2 (price = 4), profit = 4-2 = 2.
 * Example 2:
 *
 * Input: [3,2,6,5,0,3], k = 2
 * Output: 7
 * Explanation: Buy on day 2 (price = 2) and sell on day 3 (price = 6), profit = 6-2 = 4.
 *              Then buy on day 5 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.
 */
public class BuyAndSellStock3 {

	public static void main(String[] args) {
		int[] prices1 = {3, 3, 5, 0, 0, 3, 1, 4};
		int[] prices2 = {1, 2, 3, 4, 5};
		int[] prices3 = {7, 6, 4, 3, 1};

		System.out.println(maxProfit(prices1, 6));
		System.out.println(maxProfit(prices2, 2));
		System.out.println(maxProfit(prices3, 2));
	}

	static int maxProfit(int[] prices, int k) {
		if (prices.length <= 1) {
			return 0;
		}

		int[][] table = new int[k + 1][prices.length];

		for (int i = 1; i <= k; i++) {
			int maxDiff = Integer.MIN_VALUE;
			for (int j = 1; j < prices.length; j++) {
				maxDiff = Math.max(maxDiff, table[i-1][j-1] - prices[j -1]);
				table[i][j] = Math.max(table[i][j-1], (prices[j] + maxDiff));
			}
		}

		return table[k][prices.length - 1];
	}
}
