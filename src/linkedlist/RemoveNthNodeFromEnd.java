package linkedlist;

/**
 * Given a linked list, remove the n-th node from the end of list and return its head.
 *
 * Example:
 *
 * Given linked list: 1->2->3->4->5, and n = 2.
 *
 * After removing the second node from the end, the linked list becomes 1->2->3->5.
 * Note:
 *
 * Given n will always be valid.
 *
 * Follow up:
 *
 * Could you do this in one pass?
 */

public class RemoveNthNodeFromEnd {

	static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);

		print(removeNthFromEnd(head, 2));
	}

	static void print(ListNode node) {
		while (node != null) {
			System.out.print(node.val);
			if (node.next != null) {
				System.out.print("->");
			}
			node = node.next;
		}
	}

	static ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode previousNode = null, fast = head, slow = head;
		for (int i = 1; fast != null; i++) {
			if (i > n) {
				previousNode = slow;
				slow = slow.next;
			}
			fast = fast.next;
		}
		if (previousNode != null) {
			previousNode.next = previousNode.next.next;
		} else {
			return head.next;
		}
		return head;
	}
}