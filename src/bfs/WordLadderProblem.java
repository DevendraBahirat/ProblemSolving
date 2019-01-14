package bfs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * Given a dictionary, and two words ‘start’ and ‘target’ (both of same length).
 * Find length of the smallest chain from ‘start’ to ‘target’ if it exists,
 * such that adjacent words in the chain only differ by one character and each word in the chain is a valid word
 * i.e., it exists in the dictionary.
 * It may be assumed that the ‘target’ word exists in dictionary and length of all dictionary words is same.
 *
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

        System.out.println(shortestWordChainCount(start, target, dictonary));
    }

    private static class WordDistance {
        private String word;
        private int distance;
    }

    private static int shortestWordChainCount(String start, String target, List<String> dictonary) {
        Queue<WordDistance> queue = new ArrayDeque<>();

        if (start != null && !start.isEmpty() && target != null && !target.isEmpty() && dictonary.contains(target)) {
            WordDistance initial = new WordDistance();
            initial.word = start;
            initial.distance = 1;
            queue.add(initial);
        }

        while (!queue.isEmpty()) {
            WordDistance current = queue.remove();
            for (int i = 0; i < dictonary.size(); i++) {
                if (target.equals(current.word)) {
                    return current.distance;
                }
                if (isAdjacent(current.word, dictonary.get(i))) {
                    WordDistance adjacent = new WordDistance();
                    adjacent.word = dictonary.get(i);
                    adjacent.distance = current.distance + 1;
                    queue.add(adjacent);
                    dictonary.remove(dictonary.get(i));
                }
            }
        }
        return -1;
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