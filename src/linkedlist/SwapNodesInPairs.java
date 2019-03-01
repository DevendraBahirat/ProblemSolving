package linkedlist;

/**
 * Given a linked list, swap every two adjacent nodes and return its head.
 * <p>
 * You may not modify the values in the list's nodes, only nodes itself may be changed.
 * <p>
 * Example:
 * <p>
 * Given 1->2->3->4, you should return the list as 2->1->4->3.
 */
public class SwapNodesInPairs {
	static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	static ListNode swapPairs(ListNode head) {
		ListNode current = head, next, nextToNext;
		if (current != null) {
			head = head.next == null ? head : head.next;
			while (true) {
				next = current.next;
				nextToNext = next != null ? next.next : null;
				if (nextToNext == null || nextToNext.next == null) {
					if (next != null) {
						next.next = current;
					}
					current.next = nextToNext;
					break;
				}
				next.next = current;
				current.next = nextToNext.next;
				current = nextToNext;
			}
		}
		return head;
	}

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		/*head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);*/

		print(swapPairs(null));
	}

	private static void print(ListNode node) {
		while (node != null) {
			System.out.print(node.val);
			if (node.next != null) {
				System.out.print("->");
			}
			node = node.next;
		}
	}
}
