package linkedlist;

/**
 * You are given a doubly linked list which in addition to the next and previous pointers, it could have a child pointer, which
 * may or may not point to a separate doubly linked list. These child lists may have one or more children of their own, and so
 * on, to produce a multilevel data structure, as shown in the example below.
 * <p>
 * Flatten the list so that all the nodes appear in a single-level, doubly linked list. You are given the head of the first
 * level of the list.
 * <p>
 * Example:
 * <p>
 * Input:
 * 1---2---3---4---5---6--NULL
 * 		   |
 *         7---8---9---10--NULL
 * 			   |
 * 			   11--12--NULL
 * <p>
 * Output:
 * 1-2-3-7-8-11-12-9-10-4-5-6-NULL
 */
public class FlattenMultilevelDLL {

	static class Node {
		int val;
		Node prev;
		Node next;
		Node child;

		Node(int val) {
			this.val = val;
		}
	}

	static Node flatten(Node head) {
		Node tail, temp = head;
		tail = updateTail(temp);
		temp = head;

		while (temp != tail) {
			if (temp.child != null) {
				tail.next = temp.child;
				tail.next.prev = tail;
				temp.child = null;
				tail = updateTail(tail);
			}
			temp = temp.next;
		}

		return head;
	}

	private static Node updateTail(Node temp) {
		while (temp != null) {
			if (temp.next != null) {
				temp = temp.next;
				} else {
					break;
				}
		}
		return temp;
	}

	public static void main(String[] args) {
		Node head = new Node(1);

		head.next = new Node(2);
		head.next.prev = head;

		head.next.next = new Node(3);
		head.next.next.prev = head.next;

		head.next.next.child = new Node(7);

		head.next.next.child.next = new Node(8);
		head.next.next.child.next.prev = head.next.next.child;

		head.next.next.child.next.child = new Node(11);

		head.next.next.child.next.child.next = new Node(12);
		head.next.next.child.next.child.next.prev = head.next.next.child.next.child.next;

		head.next.next.child.next.next = new Node(9);
		head.next.next.child.next.next.prev = head.next.next.child.next.next;

		head.next.next.child.next.next.next = new Node(10);
		head.next.next.child.next.next.next.prev = head.next.next.child.next.next.next;

		head.next.next.next = new Node(4);
		head.next.next.next.prev = head.next.next;

		head.next.next.next.next = new Node(5);
		head.next.next.next.next.prev = head.next.next.next;

		head.next.next.next.next.next = new Node(6);
		head.next.next.next.next.next.prev = head.next.next.next.next;

		printList(flatten(head));
	}

	private static void printList(Node head) {
		while (head != null) {
			System.out.print(head.val);
			if (head.next != null) {
				System.out.print(" -> ");
			}
			head = head.next;
		}
	}
}