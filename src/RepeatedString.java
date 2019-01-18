import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/repeated-string/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=warmup
 *
 * Lilah has a string, s, of lowercase English letters that she repeated infinitely many times.
 *
 * Given an integer, n, find and print the number of letter a's in the first n letters of Lilah's infinite string.
 *
 * For example, if the string s = "abcac" and n=10, the substring we consider is "abcacabcac", the first 10 characters of her infinite string.
 * There are 4 occurrences of a in the substring.
 *
 * Function Description
 *
 * Complete the repeatedString function in the editor below. It should return an integer representing the number of occurrences of a in the prefix of length  in the infinitely repeating string.
 *
 * repeatedString has the following parameter(s):
 *
 * s: a string to repeat
 * n: the number of characters to consider
 * Input Format
 *
 * The first line contains a single string, s.
 * The second line contains an integer, n.
 */
@SuppressWarnings("ALL")
public class RepeatedString {

    // Complete the repeatedString function below.
    static long repeatedString(String s, long n) {
        long res = 0, multiplier = 1, remainder;
        multiplier = n/s.length();
        remainder = n%s.length();
        for(int i=0; i<n && i<s.length(); i++) {
            if(s.charAt(i) == 'a') {
                res++;
            }
        }
        res *= multiplier;
        for (int j=0; j<remainder && j < s.length(); j++) {
            if(s.charAt(j) == 'a') {
                res++;
            }
        }
        return res;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        String s = scanner.nextLine();

        long n = scanner.nextLong();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        long result = repeatedString(s, n);

        System.out.println(result);

        scanner.close();
    }
}