package arrays_strings;

/**
 * Statement:- Implement an Algorithm to determine if a String has all unique characters.
 *
 * Hurdle :- do not use additional data structures.
 *
 * Assumptions :- String has only ascii characters (0-127)
 */
public class UniqueCharacters {

    public static void main(String[] args) {
        String input1 = "Netflix &ChIL";
        String input2 = "netflix";
        System.out.println(isUniqueCharactersWithSpace(input1));
        System.out.println(isUniqueCharactersWithNoSpace(input2));
    }

    private static boolean isUniqueCharactersWithSpace(String input) {
        if(input.length() > 128) {
            return false;
        }
        boolean[] characterSet = new boolean[128];
        for (int i = 0; i < input.length(); i++) {
            if(characterSet[input.charAt(i)]) {
                return false;
            }
            characterSet[input.charAt(i)] = true;
        }
        return true;
    }

    /**
     * Assumes input is in the range of a-z
     *
     * If assumption does not stand other non optimal approaches can be :-
     * 1. comparing one character with every other character.
     * 2. Sorting the string and comparing neighbouring characters.
     *
     */
    private static boolean isUniqueCharactersWithNoSpace(String input) {
        int checker = 0;
        for (int i = 0; i < input.length(); i++) {
            int val = input.charAt(i) - 'a';
            if((checker & (1 << val)) > 0) {
                return false;
            }
            checker |= (1 << val);
        }
        return true;
    }
}