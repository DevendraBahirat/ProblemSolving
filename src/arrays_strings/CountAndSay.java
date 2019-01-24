package arrays_strings;

/**
 * The count-and-say sequence is the sequence of integers with the first five terms as following:
 * <p>
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * <p>
 * 1 is read off as "one 1" or 11.
 * 11 is read off as "two 1s" or 21.
 * 21 is read off as "one 2, then one 1" or 1211.
 * <p>
 * Given an integer n where 1 ≤ n ≤ 30, generate the nth term of the count-and-say sequence.
 * <p>
 * Note: Each term of the sequence of integers will be represented as a string.
 */
public class CountAndSay {

	public static void main(String[] args) {
		System.out.println(countAndSay(1));
		System.out.println(countAndSay(2));
		System.out.println(countAndSay(3));
		System.out.println(countAndSay(4));
		System.out.println(countAndSay(5));
		System.out.println(countAndSay(6));
		System.out.println(countAndSay(7));
		System.out.println(countAndSay(8));
		System.out.println(countAndSay(9));
		System.out.println(countAndSay(10));
		System.out.println(countAndSay(11));
		System.out.println(countAndSay(12));
		System.out.println(countAndSay(13));
		System.out.println(countAndSay(14));
		System.out.println(countAndSay(15));
		System.out.println(countAndSay(16));
		System.out.println(countAndSay(17));
		System.out.println(countAndSay(18));
		System.out.println(countAndSay(19));
		System.out.println(countAndSay(20));
		System.out.println(countAndSay(21));
		System.out.println(countAndSay(22));
		System.out.println(countAndSay(23));
		System.out.println(countAndSay(24));
		System.out.println(countAndSay(25));
		System.out.println(countAndSay(26));
		System.out.println(countAndSay(27));
		System.out.println(countAndSay(28));
		System.out.println(countAndSay(29));
	}

	static String countAndSay(int n) {
		if (n <= 0) {
			return null;
		}

		String result = "1";
		int i = 1;
		while (i < n) {
			StringBuilder builder = new StringBuilder();
			int count = 1;
			for (int j = 1; j < result.length(); j++) {
				if (result.charAt(j) == result.charAt(j-1)) {
					count++;
				} else {
					builder.append(count);
					builder.append(result.charAt(j-1));
					count = 1;
				}
			}

			builder.append(count);
			builder.append(result.charAt(result.length() - 1));
			result = builder.toString();
			i++;
		}
		return result;
	}
}
