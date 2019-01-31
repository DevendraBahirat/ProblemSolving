package trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
 *
 * For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
 *
 * Example:
 *
 * Given the sorted linked list: [-10,-3,0,5,9],
 *
 * One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:
 *
 *       0
 *      / \
 *    -3   9
 *    /   /
 *  -10  5
 */
public class SortedListToBST {

	static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public static void main(String[] args) {
		ListNode head = new ListNode(-10);
		head.next = new ListNode(-3);
		head.next.next = new ListNode(0);
		head.next.next.next = new ListNode(5);
		head.next.next.next.next = new ListNode(9);

		System.out.println(inorderTraversal(sortedListToBST(head)));
	}

	static List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		Stack<TreeNode> stack = new Stack<>();
		TreeNode currentNode = root;
		while (true) {
			while (currentNode != null) {
				stack.push(currentNode);
				currentNode = currentNode.left;
			}

			if (!stack.isEmpty()) {
				currentNode = stack.pop();
				result.add(currentNode.val);
				currentNode = currentNode.right;
			} else {
				break;
			}
		}
		return result;
	}

	static TreeNode sortedListToBST(ListNode head) {
		ListNode curr = head;
		tempHead = head;
		int len = 0;
		while (curr != null) {
			len++;
			curr = curr.next;
		}
		return sortedListToBSTRecurr(len);
	}

	static ListNode tempHead;

	static TreeNode sortedListToBSTRecurr(int len) {
		if (len <= 0) {
			return null;
		}

		TreeNode left = sortedListToBSTRecurr(len / 2);
		TreeNode root = new TreeNode(tempHead.val);
		root.left = left;
		tempHead = tempHead.next;
		root.right = sortedListToBSTRecurr(len - (len / 2) - 1);
		return root;
	}
}