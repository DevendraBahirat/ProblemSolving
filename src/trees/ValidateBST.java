package trees;

/**
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 *
 * Assume a BST is defined as follows:
 *
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 * Example 1:
 *
 * Input:
 *     2
 *    / \
 *   1   3
 * Output: true
 * Example 2:
 *
 *     5
 *    / \
 *   1   4
 *      / \
 *     3   6
 * Output: false
 * Explanation: The input is: [5,1,4,null,null,3,6]. The root node's value
 *              is 5 but its right child's value is 4.
 */
public class ValidateBST {

	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public static void main(String[] args) {
		TreeNode root1 = new TreeNode(10);
		root1.left = new TreeNode(0);
		root1.left.left = new TreeNode(-1);
		root1.left.right = new TreeNode(21);

		root1.right = new TreeNode(25);
		root1.right.left = new TreeNode(16);
		root1.right.right = new TreeNode(32);

		System.out.println(isValidBST(root1));

		TreeNode root2 = new TreeNode(10);
		root2.left = new TreeNode(-10);
		root2.left.left = new TreeNode(-20);
		root2.left.right = new TreeNode(0);

		root2.right = new TreeNode(19);
		root2.right.left = new TreeNode(17);

		System.out.println(isValidBST(root2));

		TreeNode root3 = new TreeNode(2147483647);

		System.out.println(isValidBST(root3));
	}

	static boolean isValidBST(TreeNode root) {
		return isValidBST(root, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);
	}

	static boolean isValidBST(TreeNode root, double min, double max) {
		if (root == null) {
			return true;
		}

		if (root.val > min && root.val < max) {
			return isValidBST(root.left, min, root.val) && isValidBST(root.right, root.val, max);
		}
		return false;
	}
}
