package graph_greedy;

/**
 * Given a number of friends who have to give or take some amount of money from one another. Design an algorithm by which the total
 * cash flow among all the friends is minimized.
 * <p>
 * <p>
 * The idea is to use Greedy algorithm where at every step, settle all amounts of one person and recur for remaining n-1 persons.
 * How to pick the first person? To pick the first person, calculate the net amount for every person where net amount is obtained by
 * subtracting all debts (amounts to pay) from all credits (amounts to be paid). Once net amount for every person is evaluated, find
 * two persons with maximum and minimum net amounts. These two persons are the most creditors and debtors. The person with minimum
 * of two is our first person to be settled and removed from list. Let the minimum of two amounts be x. We pay ‘x’ amount from the
 * maximum debtor to maximum creditor and settle one person. If x is equal to the maximum debit, then maximum debtor is settled,
 * else maximum creditor is settled.
 * <p>
 * The following is detailed algorithm.
 * <p>
 * Do following for every person Pi where i is from 0 to n-1.
 * 1) Compute the net amount for every person. The net amount for person ‘i’ can be computed be subtracting sum of all debts from
 * sum of all credits.
 * <p>
 * 2) Find the two persons that are maximum creditor and maximum debtor. Let the maximum amount to be credited maximum creditor be
 * maxCredit and maximum amount to be debited from maximum debtor be maxDebit. Let the maximum debtor be Pd and maximum creditor be
 * Pc.
 * <p>
 * 3) Find the minimum of maxDebit and maxCredit. Let minimum of two be x. Debit ‘x’ from Pd and credit this amount to Pc
 * <p>
 * 4) If x is equal to maxCredit, then remove Pc from set of persons and recur for remaining (n-1) persons.
 * <p>
 * 5) If x is equal to maxDebit, then remove Pd from set of persons and recur for remaining (n-1) persons.
 */

public class MinimizeCashFlow {

	public static void main(String[] args) {
		// graph[i][j] indicates the amount
		// that person i needs to pay person j
		int[][] graph = {{0, 1000, 2000},
			{0, 0, 5000},
			{0, 0, 0},};

		// Print the solution
		minCashFlow(graph);
	}

	private static int getMinIndex(int[] arr) {
		int minInd = 0;
		for (int i = 1; i < arr.length; i++)
			if (arr[i] < arr[minInd])
				minInd = i;
		return minInd;
	}

	private static int getMaxIndex(int[] arr) {
		int maxInd = 0;
		for (int i = 1; i < arr.length; i++)
			if (arr[i] > arr[maxInd])
				maxInd = i;
		return maxInd;
	}

	// amount[p] indicates the net amount
	// to be credited/debited to/from person 'p'
	// If amount[p] is positive, then
	// i'th person will amount[i]
	// If amount[p] is negative, then
	// i'th person will give -amount[i]
	private static void minCashFlowRec(int[] amount) {
		// Find the indexes of minimum and
		// maximum values in amount[]
		// amount[mxCredit] indicates the maximum amount
		// to be given (or credited) to any person .
		// And amount[mxDebit] indicates the maximum amount
		// to be taken(or debited) from any person.
		// So if there is a positive value in amount[],
		// then there must be a negative value
		int mxCredit = getMaxIndex(amount), mxDebit = getMinIndex(amount);

		// If both amounts are 0, then
		// all amounts are settled
		if (amount[mxCredit] == 0 && amount[mxDebit] == 0)
			return;

		// Find the minimum of two amounts
		int min = Math.min(-amount[mxDebit], amount[mxCredit]);
		amount[mxCredit] -= min;
		amount[mxDebit] += min;

		// If minimum is the maximum amount to be
		System.out.println("Person " + mxDebit + " pays " + min
			+ " to " + "Person " + mxCredit);

		// Recur for the amount array.
		// Note that it is guaranteed that
		// the recursion would terminate
		// as either amount[mxCredit]  or
		// amount[mxDebit] becomes 0
		minCashFlowRec(amount);
	}

	// Given a set of persons as graph[]
	// where graph[i][j] indicates
	// the amount that person i needs to
	// pay person j, this function
	// finds and prints the minimum
	// cash flow to settle all debts.
	private static void minCashFlow(int[][] graph) {
		// Create an array amount[],
		// initialize all value in it as 0.
		int[] amount = new int[graph.length];

		// Calculate the net amount to
		// be paid to person 'p', and
		// stores it in amount[p]. The
		// value of amount[p] can be
		// calculated by subtracting
		// debts of 'p' from credits of 'p'
		for (int p = 0; p < graph.length; p++)
			for (int i = 0; i < graph.length; i++)
				amount[p] += (graph[i][p] - graph[p][i]);

		minCashFlowRec(amount);
	}
}
