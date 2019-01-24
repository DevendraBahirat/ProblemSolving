package linkedlist;

/**
 * A linked list is given such that each node contains an additional random pointer which could point to any node in the list or
 * null.
 * <p>
 * Return a deep copy of the list.
 */
public class CopyListWithRandomPointer {

	static class RandomListNode {
		int label;
		RandomListNode next, random;

		RandomListNode(int x) {
			this.label = x;
		}

		@Override
		public String toString() {
			String res = label + "-> {";
			res += (next != null ? next.label + "" : null) + ", ";
			res += (random != null ? random.label + "" : null) + "}";
			return res;
		}
	}

	public static void main(String[] args) {
		RandomListNode head = new RandomListNode(1);
		head.next = new RandomListNode(2);
		head.next.next = new RandomListNode(3);
		head.next.next.next = new RandomListNode(4);

		head.random = head.next.next;
		head.next.random = head;
		head.next.next.random = head.next.next;
		head.next.next.next.random = head.next;

		print(copyRandomList(head));
	}

	static void print(RandomListNode head) {
		while (head != null) {
			System.out.print(head + " -> ");
			head = head.next;
		}
		System.out.print(null + "");
	}

	static RandomListNode copyRandomList(RandomListNode head) {
		if (head == null) {
			return null;
		}

		RandomListNode current = head;
		while (current != null) {
			RandomListNode temp = new RandomListNode(current.label);
			temp.next = current.next;
			current.next = temp;
			current = current.next.next;
		}

		current = head;
		while (current != null) {
			current.next.random = current.random != null ? current.random.next : null;
			current = current.next.next;
		}

		RandomListNode resultHead = head.next;
		RandomListNode temp = resultHead;
		while (head != null) {
			head = head.next = (temp != null ? temp.next : null);
			temp = temp.next = (temp.next != null ? temp.next.next : null);
		}
		return resultHead;
	}
}