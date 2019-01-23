package arrays_strings;

import java.util.Stack;

/**
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 *
 * An input string is valid if:
 *
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Note that an empty string is also considered valid.
 *
 * Example 1:
 *
 * Input: "()"
 * Output: true
 * Example 2:
 *
 * Input: "()[]{}"
 * Output: true
 * Example 3:
 *
 * Input: "(]"
 * Output: false
 * Example 4:
 *
 * Input: "([)]"
 * Output: false
 * Example 5:
 *
 * Input: "{[]}"
 * Output: true
 */
public class ValidParantheses {

	public static void main(String[] args) {
		System.out.println(isValid("()"));
		System.out.println(isValid("()[]{}"));
		System.out.println(isValid("(]"));
		System.out.println(isValid("([)]"));
		System.out.println(isValid("{[]}"));
	}

	static boolean isValid(String s) {
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i<s.length(); i++) {
			Character character = s.charAt(i);
			if (character == '(' || character == '{' || character == '[') {
				stack.push(character);
			} else {
				if (stack.isEmpty()) {
					return false;
				}
				Character pop = stack.pop();
				if (character == ')' && pop != '(') {
					return false;
				}
				if (character == '}' && pop != '{'){
					return false;
				}
				if (character == ']' && pop != '[') {
					return false;
				}
			}
		}
		return stack.isEmpty();
	}
}
