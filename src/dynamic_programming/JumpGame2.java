package dynamic_programming;

/**
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * <p>
 * Each element in the array represents your maximum jump length at that position.
 * <p>
 * Your goal is to reach the last index in the minimum number of jumps.
 * <p>
 * Example:
 * <p>
 * Input: [2,3,1,1,4]
 * Output: 2
 * Explanation: The minimum number of jumps to reach the last index is 2.
 * Jump 1 step from index 0 to 1, then 3 steps to the last index.
 */
public class JumpGame2 {

	public static void main(String[] args) {
		int[] input1 = {2, 3, 1, 1, 4};
		int[] input2 = {3, 2, 1, 0, 4};

		System.out.println(jump(input1));
		System.out.println(jump(input2));
	}

	static int jump(int[] nums) {
		int[] temp = new int[nums.length];
		for (int i = 0; i<temp.length; i++) {
			if(i ==0 ) {
				temp[i] = 0;
			} else {
				temp[i] = Integer.MAX_VALUE;
			}
		}

		for (int i=1; i<nums.length; i++) {
			for (int j=0; j<i; j++) {
				if (j + nums[j] >= i) {
					temp[i] = Math.min(temp[i], temp[j] + 1);
				}
			}
		}

		return temp[nums.length - 1];
	}
}
