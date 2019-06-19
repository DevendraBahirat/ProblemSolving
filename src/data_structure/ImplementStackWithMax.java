package data_structure;

/**
 * Design a stack with push, pop and max function which returns max value in the stack, all of which run in O(1) time
 */

public class ImplementStackWithMax {

	private static class Element {
		int val;
		Element next;
		Element previousMax;

		Element(int val) {
			this.val = val;
		}
	}

	private Element stack;
	private Element max;

	public ImplementStackWithMax() {
		stack = null;
		max = null;
	}

	public void push(int value) {
		Element element = new Element(value);
		if (stack != null) {

			element.next = stack;
			stack = element;
		} else {
			stack = element;
		}
		if (max == null || max.val < element.val) {
			element.previousMax = max;
			max = element;
		}
	}

	public int pop() {
		if(stack == null) {
			throw new RuntimeException("cannot pop from empty stack");
		}
		int result = stack.val;

			max = stack.previousMax;

		stack = stack.next;
		return result;
	}

	public int max() {
		if (max == null) {
			throw new RuntimeException("No Max as stack is empty");
		}
		return max.val;
	}
}
