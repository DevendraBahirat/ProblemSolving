package arrays_strings;

import java.util.Arrays;

/**
 * Find the smallest positive number missing from an unsorted array
 * You are given an unsorted array with both positive and negative elements.
 * You have to find the smallest positive number missing from the array in O(n) time using constant extra space.
 *
 * Example:
 * Input = {2, 3, 4, 6, 8, -1, -3}
 * Output = 1
 *
 * Input = { 1, 3, -7, 6, 8, 1, -5, 5 }
 * Output = 2
 *
 */

public class FirstMissingPositiveNumberInteger {

    public static void main(String[] args) {
        int[] input1 = new int[]{2, 3, 17, 16, 48, 1};
        int[] input2 = new int[]{0, 0, 0, 0, 0, 0};
        int[] input3 = new int[]{0, 3, 17, 16, 48, 1, -10, 15};
        int[] input4 = new int[]{-1, -2, -3, -4};
        int[] input5 = new int[]{1, -2, -3, -4};
        int[] input6 = new int[]{1, 2, 3, 4};
        System.out.println(findFirstMissingPositiveInteger(input1));
        System.out.println(findFirstMissingPositiveInteger(input2));
        System.out.println(findFirstMissingPositiveInteger(input3));
        System.out.println(findFirstMissingPositiveInteger(input4));
        System.out.println(findFirstMissingPositiveInteger(input5));
        System.out.println(findFirstMissingPositiveInteger(input6));
    }

    private static int findFirstMissingPositiveInteger(int[] input) {
        //Handling empty array input
        if (input.length == 0) {
            return 1;
        }
        //Bringing all positive integers to left of the array
        int positiveNumbersCount = 0, temp;
        for (int i = 0; i < input.length; i++) {
            if (input[i] > 0) {
                temp = input[i];
                input[i] = input[positiveNumbersCount];
                input[positiveNumbersCount] = temp;
                positiveNumbersCount++;
            }
        }
        System.out.println(Arrays.toString(input));

        //Handling all negative/zero input
        if (positiveNumbersCount == 0) {
            return 1;
        }

        /*
          We traverse the array containing all positive numbers and to mark presence of an element x,
          we change the sign of value at index x to negative.
          We traverse the array again and return the first index which has positive value.
          During traversing, we can ignore the index value if it is greater than array size.
          We are bothered only for array values in range of array size.
         */
        for (int j = 0; j < positiveNumbersCount; j++) {
            int indexToInvert = Math.abs(input[j]) - 1;
            if (indexToInvert >= 0 && indexToInvert < positiveNumbersCount && input[indexToInvert] > 0) {
                input[indexToInvert] *= -1;
            }
        }
        System.out.println(Arrays.toString(input));

        for (int k = 0; k < input.length; k++) {
            if (input[k] > 0) {
                return k + 1;
            }
        }
        return positiveNumbersCount + 1;
    }
}