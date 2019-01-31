package data_structure;

public class ImplementPriorityQueue {
	int[] heap;
	int size;

	public ImplementPriorityQueue(int maxSize) {
		if (maxSize <= 0) {
			throw new RuntimeException("Size should greater than zero");
		}
		heap = new int[maxSize];
		size = 0;
	}

	public void push(int value) {
		if (size == heap.length) {
			throw new RuntimeException("Queue is full");
		}
		int pos = size;
		heap[pos] = value;

		//Bubbling Up
		while (pos > 0) {
			int parent = ((pos + 1) / 2) - 1;
			if (heap[parent] >= heap[pos]) {
				break;
			}
			swap(parent, pos);
			pos = parent;
		}
		size++;
	}

	public int pop() {
		if (size == 0) {
			throw new RuntimeException("Queue is empty");
		}
		int result = heap[0];
		heap[0] = heap[size - 1];
		size--;

		//Bubble Down
		int pos = 0;
		while (pos < size / 2) {
			int leftChild = (pos * 2) + 1;
			int rightChild = leftChild + 1;

			if (rightChild < size && heap[leftChild] < heap[rightChild]) {
				if (heap[pos] >= heap[rightChild]) {
					break;
				}
				swap(pos, rightChild);
				pos = result;
			} else {
				if (heap[pos] >= heap[leftChild]) {
					break;
				}
				swap(pos, leftChild);
				pos = leftChild;
			}
		}

		return result;
	}

	private void swap(int index1, int index2) {
		int temp = heap[index1];
		heap[index1] = heap[index2];
		heap[index2] = temp;
	}
}
