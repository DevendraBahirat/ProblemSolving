package data_structure;

/**
 * DRY RUN
 *
 * topOfStack 	= {0,3,-1}
 *
 * stackData	= {9,7,6,9,8}
 *
 * nextIndex	= {-1,-1,-1,4,1}
 *
 * nextAvailable	= 2
 *
 * PST = 4
 * PNA = -1
 * indexCurrtop = 2
 *
 * push (0, 9);
 * push (1, 7);
 * push (0, 6);
 * push (0, 5);
 * push (1, 8);
 *
 * pop(0) --> 5
 * push (1, 9);
 * pop(0) --> 6
 */

public class ImplementNStacksinArray {

	int[] stackData;
	int[] nextIndex, topOfStack;
	int nextAvailable;

	public ImplementNStacksinArray(int sizeOfArray, int numberOfStacks) {
		stackData = new int[sizeOfArray];
		nextIndex = new int[sizeOfArray];
		for (int i=0; i<sizeOfArray; i++) {
			nextIndex[i] = i + 1;
			if (i + 1 == sizeOfArray) {
				nextIndex[i] = -1;
			}
		}
		topOfStack = new int[numberOfStacks];
		for (int i=0; i <numberOfStacks; i++) {
			topOfStack[i] = -1;
		}
		nextAvailable = 0;
	}

	public void push(int stackNumber, int value) {
		if (stackNumber < 0 || stackNumber >= topOfStack.length) {
			throw new RuntimeException("invalid Stack number");
		}
		if(nextAvailable < 0) {
			throw new RuntimeException("Stack Overflow");
		}
		stackData[nextAvailable] = value;
		int previousStackTop = topOfStack[stackNumber];
		int previousNextAvailable = nextIndex[nextAvailable];
		topOfStack[stackNumber] = nextAvailable;
		nextIndex[nextAvailable] = previousStackTop;
		nextAvailable = previousNextAvailable;
	}

	public int pop(int stackNumber) {
		if (stackNumber < 0 || stackNumber >= topOfStack.length) {
			throw new RuntimeException("invalid Stack number");
		}
		int indexOfCurrentTop = topOfStack[stackNumber];
		if(indexOfCurrentTop < 0) {
			throw new RuntimeException("Stack Empty");
		}
		int result = stackData[indexOfCurrentTop];
		topOfStack[stackNumber] = nextIndex[indexOfCurrentTop];
		nextIndex[indexOfCurrentTop] = nextAvailable;
		nextAvailable = indexOfCurrentTop;
		return result;
	}
}