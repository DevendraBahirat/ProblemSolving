import java.util.ArrayList;
import java.util.List;

/**
 * Amazon amcat test Demo test problem 1.
 * If the neighbouring cells have same value i.e. both 0 or both 1 the the current cell becomes inactive the next day.
 * else it becomes active the next day.
 *
 * Consider values of previous day to determine current day state.
 *
 * Given an array representing state of cells return the state of cells after given number of days.
 */
public class ActiveInactive {

	public static void main(String[] args) {
		int[] input = new int[]{1, 1, 1, 0, 1, 1, 1, 1};
		int days = 2;
		System.out.println(cellCompete(input, days));
	}

	private static List<Integer> cellCompete(int[] states, int days) {
		List<Integer> result = new ArrayList<>();
		for (int i = 0; i < days; i++) {
			int[] temp = states.clone();
			for (int j = 0; j < temp.length; j++) {
				if (j == 0) {
					if (temp[j + 1] == 0) {
						states[j] = 0;
					} else {
						states[j] = 1;
					}
				} else if (j == temp.length - 1) {
					if (temp[j - 1] == 0) {
						states[j] = 0;
					} else {
						states[j] = 1;
					}
				} else {
					if (temp[j - 1] == temp[j + 1]) {
						states[j] = 0;
					} else {
						states[j] = 1;
					}
				}
			}
		}
		for (int k : states) {
			result.add(k);
		}
		return result;
	}


}
