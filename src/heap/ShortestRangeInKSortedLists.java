package heap;

import java.util.*;

/**
 * Find smallest range containing elements from k lists
 * Given k sorted lists of integers of size n each, find the smallest range that includes at least element from each of the k lists. If more than one smallest ranges are found, print any one of them.
 * <p>
 * Example :
 * <p>
 * Input:
 * K = 3
 * arr1[] : [4, 7, 9, 12, 15]
 * arr2[] : [0, 8, 10, 14, 20]
 * arr3[] : [6, 12, 16, 30, 50]
 * Output:
 * The smallest range is [6 8]
 * Explanation: Smallest range is formed by
 * number 7 from first list, 8 from second
 * list and 6 from third list.
 * <p>
 * <p>
 * Input:
 * k = 3
 * arr1[] : [4, 7]
 * arr2[] : [1, 2]
 * arr3[] : [20, 40]
 * The smallest range is [2 20]
 */
public class ShortestRangeInKSortedLists {
	static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	static int[] findSmallestRange(List<ListNode> lists) {
		int[] result = {0, 0};
		int resultLength = Integer.MAX_VALUE;
		Queue<ListNode> minHeap = new PriorityQueue<>(new Comparator<ListNode>() {
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

		Queue<ListNode> maxHeap = new PriorityQueue<>(new Comparator<ListNode>() {
			@Override
			public int compare(ListNode o1, ListNode o2) {
				if (o1.val > o2.val) {
					return -1;
				} else if (o1.val < o2.val) {
					return 1;
				}
				return 0;
			}
		});

		for (ListNode listNode : lists) {
			minHeap.add(listNode);
			maxHeap.add(listNode);
		}

		ListNode temp;
		do {
			temp = minHeap.remove();
			ListNode maxTemp = maxHeap.peek();
			int rangeLength = maxTemp.val - temp.val;
			if (resultLength > rangeLength) {
				resultLength = rangeLength;
				result[0] = temp.val;
				result[1] = maxTemp.val;
			}
			maxHeap.remove(temp);
			temp = temp.next;
			if (temp != null) {
				minHeap.add(temp);
				maxHeap.add(temp);
			}
		}while (temp != null);
		return result;
	}

	public static void main(String[] args) {
		ListNode head1 = new ListNode(4);
		head1.next = new ListNode(10);
		head1.next.next = new ListNode(15);
		head1.next.next.next = new ListNode(24);
		head1.next.next.next.next = new ListNode(26);
		ListNode head2 = new ListNode(0);
		head2.next = new ListNode(9);
		head2.next.next = new ListNode(12);
		head2.next.next.next = new ListNode(20);
		ListNode head3 = new ListNode(5);
		head3.next = new ListNode(18);
		head3.next.next = new ListNode(22);
		head3.next.next.next = new ListNode(30);

		List<ListNode> lists = new ArrayList<>();
		lists.add(head1);
		lists.add(head2);
		lists.add(head3);

		System.out.println(Arrays.toString(findSmallestRange(lists)));
	}
}