package arrays_strings;

/**
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * <p>
 * Design an algorithm to find the maximum profit. You may complete as many transactions as you like (i.e., buy one and sell one share of the stock multiple times).
 * <p>
 * Note: You may not engage in multiple transactions at the same time (i.e., you must sell the stock before you buy again).
 * <p>
 * Example 1:
 * <p>
 * Input: [7,1,5,3,6,4]
 * Output: 7
 * Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
 * Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
 * Example 2:
 * <p>
 * Input: [1,2,3,4,5]
 * Output: 4
 * Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
 * Note that you cannot buy on day 1, buy on day 2 and sell them later, as you are
 * engaging multiple transactions at the same time. You must sell before buying again.
 * Example 3:
 * <p>
 * Input: [7,6,4,3,1]
 * Output: 0
 * Explanation: In this case, no transaction is done, i.e. max profit = 0.
 */
public class BuyAndSellStock2 {

	public static void main(String[] args) {
		int[] prices1 = {7, 1, 5, 3, 6, 4};
		int[] prices2 = {1, 2, 3, 4, 5};
		int[] prices3 = {7, 6, 4, 3, 1};

		System.out.println(maxProfit(prices1));
		System.out.println(maxProfit(prices2));
		System.out.println(maxProfit(prices3));
	}

	static int maxProfit(int[] prices) {
		if (prices.length <= 1) {
			return 0;
		}
		int result = 0;

		for (int i = 1; i < prices.length; i++) {
			int diff = prices[i] - prices[i - 1];
			if (diff > 0) {
				result += diff;
			}
		}

		return result;
	}
}
