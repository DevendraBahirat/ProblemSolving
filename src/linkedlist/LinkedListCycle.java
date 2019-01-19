package linkedlist;

/**
 * Given a linked list, determine if it has a cycle in it.
 * <p>
 * To represent a cycle in the given linked list, we use an integer pos to represent the position (0-indexed) in the linked list
 * where tail connects to (Explanation only). If pos is -1, then there is no cycle in the linked list.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: head = [3,2,0,-4], pos = 1
 * Output: true
 * Explanation: There is a cycle in the linked list, where tail connects to the second node.
 * <p>
 * <p>
 * Example 2:
 * <p>
 * Input: head = [1,2], pos = 0
 * Output: true
 * Explanation: There is a cycle in the linked list, where tail connects to the first node.
 * <p>
 * <p>
 * Example 3:
 * <p>
 * Input: head = [1], pos = -1
 * Output: false
 * Explanation: There is no cycle in the linked list.
 */
public class LinkedListCycle {

	static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	static boolean hasCycle(ListNode head) {
		ListNode fast = head, slow = head;
		while (fast != null || slow != null) {
			if (fast != null) {
				fast = fast.next;
				if (fast != null) {
					fast = fast.next;
				}
			}
			if (slow != null) {
				slow = slow.next;
			}

			if (fast == slow) {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		ListNode inputHead1 = new ListNode(1);
		inputHead1.next = new ListNode(5);
		inputHead1.next.next = new ListNode(7);
		inputHead1.next.next.next = new ListNode(9);
		inputHead1.next.next.next.next = inputHead1.next;

		System.out.println(hasCycle(inputHead1));
	}
}
