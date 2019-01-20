package trees;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Given a binary tree
 * <p>
 * struct TreeLinkNode {
 * TreeLinkNode *left;
 * TreeLinkNode *right;
 * TreeLinkNode *next;
 * }
 * Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to
 * NULL.
 * <p>
 * Initially, all next pointers are set to NULL.
 * <p>
 * Note:
 * <p>
 * You may only use constant extra space.
 * Recursive approach is fine, implicit stack space does not count as extra space for this problem.
 * You may assume that it is a perfect binary tree (ie, all leaves are at the same level, and every parent has two children).
 * Example:
 * <p>
 * Given the following perfect binary tree,
 * <p>
 * 1
 * /  \
 * 2    3
 * / \  / \
 * 4  5  6  7
 * After calling your function, the tree should look like:
 * <p>
 * 1 -> NULL
 * /  \
 * 2 -> 3 -> NULL
 * / \  / \
 * 4->5->6->7 -> NULL
 */

public class PopulateRightNeighbours {
	static class TreeLinkNode {
		int val;
		TreeLinkNode left, right, next;

		TreeLinkNode(int x) {
			val = x;
		}
	}

	public static void main(String[] args) {
		TreeLinkNode root = new TreeLinkNode(1);
		root.left = new TreeLinkNode(2);
		root.left.left = new TreeLinkNode(3);
		root.left.right = new TreeLinkNode(4);
		root.right = new TreeLinkNode(5);
		root.right.right = new TreeLinkNode(6);

		connectExtraSpace(root);
	}

	private static void connectExtraSpace(TreeLinkNode root) {
		if (root == null) {
			return;
		}

		Queue<TreeLinkNode> queue = new ArrayDeque<>();
		queue.add(root);

		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				TreeLinkNode node = queue.remove();
				if(i != size -1) {
					node.next = queue.peek();
				}
				if (node.left != null) {
					queue.add(node.left);
				}
				if (node.right != null) {
					queue.add(node.right);
				}
			}
		}
	}

	private static void connectConstantSpaceCompleteTree(TreeLinkNode root) {
		if (root == null) {
			return;
		}

		if (root.left != null) {
			root.left.next = root.right;
		}

		if (root.right != null) {
			root.right.next = (root.next != null) ? root.next.left : null;
		}

		connectConstantSpaceCompleteTree(root.left);
		connectConstantSpaceCompleteTree(root.right);
	}

	private static void connectConstantSpace(TreeLinkNode root) {
		if (root == null) {
			return;
		}

		if (root.next != null) {
			connectConstantSpace(root.next);
		}

		if (root.left != null) {
			if (root.right != null) {
				root.left.next = root.right;
				root.right.next = getNextRight(root);
			} else {
				root.left.next = getNextRight(root);
			}
			connectConstantSpace(root.left);
		} else if (root.right != null) {
			root.right.next = getNextRight(root);
			connectConstantSpace(root.right);
		} else {
			connectConstantSpace(getNextRight(root));
		}
	}

	private static TreeLinkNode getNextRight(TreeLinkNode root) {
		TreeLinkNode temp = root.next;

		while (temp != null) {
			if(temp.left != null) {
				return temp.left;
			}
			if (temp.right != null) {
				return temp.right;
			}
			temp = temp.next;
		}
		return null;
	}
}
