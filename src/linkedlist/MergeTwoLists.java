package linkedlist;

public class MergeTwoLists {

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

		print(mergeTwoLists(inputHead1, inputHead2));
	}

	static void print(ListNode node) {
		while (node != null) {
			System.out.print(node.val);
			if(node.next != null){
				System.out.print("->");
			}
			node = node.next;
		}
	}

	static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode resultHead = null, currentNode = null, previousNode = null;
		if (l1 == null) {
			return l2;
		} else if (l2 == null) {
			return l1;
		}

		while (l1 != null && l2 != null) {
			if (l1.val <= l2.val) {
				currentNode = new ListNode(l1.val);
				l1 = l1.next;
			} else {
				currentNode = new ListNode(l2.val);
				l2 = l2.next;
			}
			if (resultHead == null) {
				resultHead = currentNode;
			} else {
				previousNode.next = currentNode;
			}
			previousNode = currentNode;
		}

		while (l1 != null) {
			currentNode = new ListNode(l1.val);
			previousNode.next = currentNode;
			previousNode = currentNode;
			l1 = l1.next;
		}
		while (l2 != null) {
			currentNode = new ListNode(l2.val);
			previousNode.next = currentNode;
			previousNode = currentNode;
			l2 = l2.next;
		}
		return resultHead;
	}
}
