package arrays_strings;

import java.util.Arrays;

/**
 * Given balls of these three colors [Red(0), White(1), Blue(2)] arranged randomly in a line (the actual number of balls does not matter),
 * the task is to arrange them such that all balls of the same color are together
 * and their collective color groups are in the correct order.
 *
 * Given an array A[] consisting 0s, 1s and 2s, write a function that sorts A[].
 * The functions should put all 0s first, then all 1s and all 2s in last.
 *
 * Input :  {0, 1, 2, 0, 1, 2}
 * Output : {0, 0, 1, 1, 2, 2}
 *
 * Input :  {0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1}
 * Output : {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2}
 */

public class DutchFlagProblem {

    public static void main(String[] args) {
        int[] input = new int[]{0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1};
        System.out.println(Arrays.toString(sortColors(input)));
        int[] input2 = new int[0];
        System.out.println(Arrays.toString(sortColors(input2)));
    }

    private static int[] sortColors(int[] input) {
        int low = 0, mid = 0, high = input.length - 1;
        int temp;
        while (mid <= high) {
            if (input[mid] == 0) {
                temp = input[low];
                input[low] = input[mid];
                input[mid] = temp;
                low++; mid++;
            } else if (input[mid] == 2) {
                temp = input[high];
                input[high] = input[mid];
                input[mid] = temp;
                high--;
            } else {
                mid++;
            }
        }
        return input;
    }
}
