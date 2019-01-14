package arrays_strings;

public class LargestContiguousSum {
	public static void main(String[] args) {
		int[] input = {-2, 1, -3, 4, -1, 2, 1, -5, 4};

		System.out.println(kadaneAlgorithm(input));
	}

	private static int kadaneAlgorithm(int[] input) {
		if (input.length == 0) {
			return Integer.MIN_VALUE;
		}
		int current_max = input[0];
		int global_max = input[0];

		for (int i = 1; i<input.length; i++) {
			current_max = Math.max(current_max + input[i], input[i]);
			if(current_max > global_max) {
				global_max = current_max;
			}
		}
		return global_max;
	}
}
