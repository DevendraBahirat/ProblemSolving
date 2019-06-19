package linkedlist;

/**
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each
 * of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 * <p>
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * <p>
 * Example:
 * <p>
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 */
public class AddTwoNumbers {
	public static void main(String[] args) {
		ListNode head1 = new ListNode(9);
		ListNode tens1 = new ListNode(9);
		ListNode hundreds1 = new ListNode(2);
		head1.next = tens1;
		tens1.next = hundreds1;

		ListNode head2 = new ListNode(5);
		ListNode tens2 = new ListNode(6);
		ListNode hundreds2 = new ListNode(4);
		head2.next = tens2;
		tens2.next = hundreds2;

		print(addTwoNumbers(head1, head2));
	}

	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode resultHead = null;
		ListNode previous = null;
		ListNode temp;
		int carry = 0;

		while (l1 != null || l2 != null) {
			int sum = (l1 != null ? l1.val : 0) + (l2 != null ? l2.val : 0) + carry;
			if (sum > 9) {
				carry = 1;
				sum %= 10;
			} else {
				carry = 0;
			}

			temp = new ListNode(sum);

			if (resultHead == null) {
				resultHead = temp;
			} else {
				previous.next = temp;
			}
			previous = temp;

			if (l1 != null) {
				l1 = l1.next;
			}
			if (l2 != null) {
				l2 = l2.next;
			}

			if (carry > 0) {
				temp.next = new ListNode(carry);
			}
		}
		return resultHead;
	}

	static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	private static void print(ListNode node) {
		while (node != null) {
			System.out.print(node.val);
			if (node.next != null) {
				System.out.print("-> ");
			}
			node = node.next;
		}
	}
}

