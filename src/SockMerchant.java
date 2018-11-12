import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/sock-merchant/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=warmup
 *
 * John works at a clothing store.
 * He has a large pile of socks that he must pair by color for sale.
 * Given an array of integers representing the color of each sock, determine how many pairs of socks with matching colors there are.
 *
 * For example, there are n=7 socks with colors ar = [1,2,1,2,1,3,2].
 * There is one pair of color 1 and one of color 2. There are three odd socks left, one of each color. The number of pairs is 2.
 *
 * Function Description
 *
 * Complete the sockMerchant function in the editor below. It must return an integer representing the number of matching pairs of socks that are available.
 *
 * sockMerchant has the following parameter(s):
 *
 * n: the number of socks in the pile
 * ar: the colors of each sock
 * Input Format
 *
 * The first line contains an integer , the number of socks represented in .
 * The second line contains  space-separated integers describing the colors  of the socks in the pile.
 *
 * Output Format
 *
 * Print the total number of matching pairs of socks that John can sell.
 *
 * Sample Input
 *
 * 9
 * 10 20 20 10 10 30 50 10 20
 * Sample Output
 *
 * 3
 *
 */
public class SockMerchant {
    static int sockMerchant(int n, int[] ar) {
        int result = 0;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i =0; i<n; i++) {
            if(map.get(ar[i]) == null) {
                map.put(ar[i], 1);
            } else {
                map.put(ar[i], map.get(ar[i])+1);
            }
        }
        for(Map.Entry<Integer,Integer> entry : map.entrySet()) {
            result += (entry.getValue()/2);
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] ar = new int[n];
        for(int ar_i = 0; ar_i < n; ar_i++){
            ar[ar_i] = in.nextInt();
        }
        int result = sockMerchant(n, ar);
        System.out.println(result);
    }
}
