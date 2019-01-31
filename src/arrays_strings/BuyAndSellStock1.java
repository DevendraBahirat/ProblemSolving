package arrays_strings;

/**
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * <p>
 * If you were only permitted to complete at most one transaction (i.e., buy one and sell one share of the stock), design an algorithm to find the maximum profit.
 * <p>
 * Note that you cannot sell a stock before you buy one.
 * <p>
 * Example 1:
 * <p>
 * Input: [7,1,5,3,6,4]
 * Output: 5
 * Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
 * Not 7-1 = 6, as selling price needs to be larger than buying price.
 * Example 2:
 * <p>
 * Input: [7,6,4,3,1]
 * Output: 0
 * Explanation: In this case, no transaction is done, i.e. max profit = 0.
 */
public class BuyAndSellStock1 {

	public static void main(String[] args) {
		int[] prices1 = {7, 1, 5, 3, 6, 4};
		int[] prices2 = {7, 6, 4, 3, 1};
		int[] prices3 = {3,3,5,0,0,3,1,4};

		System.out.println(maxProfit(prices1));
		System.out.println(maxProfit(prices2));
		System.out.println(maxProfit(prices3));
	}

	static int maxProfit(int[] prices) {
		if (prices.length <= 1) {
			return 0;
		}
		int result = 0;
		int min = prices[0];

		for (int i = 1; i < prices.length; i++) {
			result = Math.max(result, prices[i] - min);
			min = Math.min(min, prices[i]);
		}

		return result;
	}
}
