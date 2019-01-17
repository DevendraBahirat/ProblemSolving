package bfs;

import java.util.*;

/**
 * Given a dictionary, and two words ‘start’ and ‘target’ (both of same length).
 * Find length of the smallest chain from ‘start’ to ‘target’ if it exists,
 * such that adjacent words in the chain only differ by one character and each word in the chain is a valid word
 * i.e., it exists in the dictionary.
 * It may be assumed that the ‘target’ word exists in dictionary and length of all dictionary words is same.
 * <p>
 * Input:  Dictionary = {POON, PLEE, SAME, POIE, PLEA, PLIE, POIN}
 * start = TOON
 * target = PLEA
 * Output: 7
 * Explanation: TOON - POON - POIN - POIE - PLIE - PLEE - PLEA
 */
public class WordLadderProblem {

	public static void main(String[] args) {
		List<String> dictonary = new ArrayList<>();
		dictonary.add("POON");
		dictonary.add("PLEE");
		dictonary.add("SAME");
		dictonary.add("POIE");
		dictonary.add("PLEA");
		dictonary.add("PLIE");
		dictonary.add("POIN");

		String start = "TOON";
		String target = "PLEA";

		String start2 = "hot";
		String target2 = "dot";
		List<String> dict2 = new ArrayList<>();
		dict2.add("hot");
		dict2.add("dot");
		dict2.add("dog");
            /*dict2.add("lot");
            dict2.add("log");
            dict2.add("cog");*/
		String start3 = "a";
		String target3 = "c";
		List<String> dict3 = new ArrayList<>();
		dict3.add("a");
		dict3.add("b");
		dict3.add("c");

		System.out.println(shortestWordChainCount(start, target, dictonary));
		System.out.println(shortestWordChainCount(start2, target2, dict2));
		System.out.println(shortestWordChainCount(start3, target3, dict3));
	}

	private static class WordDistance {
		private String word;
		private int distance;
	}

	private static int shortestWordChainCount(String start, String target, List<String> dictionary) {
		Queue<WordDistance> queue = new ArrayDeque<>();

		if (start != null && !start.isEmpty() && target != null && !target.isEmpty() && dictionary.contains(target)) {
			WordDistance initial = new WordDistance();
			initial.word = start;
			initial.distance = 1;
			queue.add(initial);
		}
		dictionary.remove(start);

		while (!queue.isEmpty()) {
			WordDistance current = queue.remove();
			if (target.equals(current.word)) {
				return current.distance;
			}
			Iterator<String> iterator = dictionary.iterator();
			while (iterator.hasNext()) {
				String next = iterator.next();
				if (isAdjacent(current.word, next)) {
					WordDistance adjacent = new WordDistance();
					adjacent.word = next;
					adjacent.distance = current.distance + 1;
					queue.add(adjacent);
					iterator.remove();
				}
			}
		}
		return 0;
	}

	private static boolean isAdjacent(String word, String validWord) {
		int diffCount = 0;
		for (int i = 0; i < validWord.length(); i++) {
			if (word.charAt(i) != validWord.charAt(i)) {
				diffCount++;
				if (diffCount > 1) {
					return false;
				}
			}
		}
		return true;
	}
}