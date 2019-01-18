package linkedlist;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
 * <p>
 * Example:
 * <p>
 * Input:
 * [
 * 1->4->5,
 * 1->3->4,
 * 2->6
 * ]
 * Output: 1->1->2->3->4->4->5->6
 */
public class MergeKSortedLists {

	static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
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

	public static void main(String[] args) {
		ListNode inputHead1 = new ListNode(1);
		inputHead1.next = new ListNode(5);

		inputHead1.next.next = new ListNode(7);
		inputHead1.next.next.next = new ListNode(9);
		inputHead1.next.next.next.next = new ListNode(12);
		inputHead1.next.next.next.next.next = new ListNode(23);
		inputHead1.next.next.next.next.next.next = new ListNode(40);

		ListNode inputHead2 = new ListNode(8);
		inputHead2.next = new ListNode(15);
		inputHead2.next.next = new ListNode(22);
		inputHead2.next.next.next = new ListNode(23);
		inputHead2.next.next.next.next = new ListNode(33);

		ListNode inputHead3 = new ListNode(1);
		inputHead3.next = new ListNode(4);
		inputHead3.next.next = new ListNode(5);


		ListNode inputHead4 = new ListNode(1);
		inputHead4.next = new ListNode(3);
		inputHead4.next.next = new ListNode(4);

		ListNode inputHead5 = new ListNode(2);
		inputHead5.next = new ListNode(6);

		print(mergeKLists(new ListNode[]{inputHead1, inputHead2, inputHead3, inputHead4, inputHead5}));
	}

	static ListNode mergeKLists(ListNode[] lists) {
		ListNode resultHead = null, currentNode = null, previousNode = null;
		if (lists.length == 0) {
			return resultHead;
		}
		Queue<ListNode> minHeap = new PriorityQueue<>(lists.length, new Comparator<ListNode>() {
			@Override
			public int compare(ListNode o1, ListNode o2) {
				if (o1.val > o2.val) {
					return 1;
				} else if (o1.val < o2.val) {
					return -1;
				}
				return 0;
			}
		});
		for (ListNode node : lists) {
			if (node != null) {
				minHeap.add(node);
			} else {
				minHeap.add(new ListNode(Integer.MAX_VALUE));
			}
		}
		while (minHeap.peek().val != Integer.MAX_VALUE) {
			currentNode = minHeap.remove();
			if (resultHead == null) {
				resultHead = currentNode;
			} else {
				previousNode.next = currentNode;
			}
			previousNode = currentNode;
			if (currentNode.next != null) {
				minHeap.add(currentNode.next);
			} else {
				minHeap.add(new ListNode(Integer.MAX_VALUE));
			}
		}
		return resultHead;
	}
}