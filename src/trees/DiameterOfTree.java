package trees;

/**
 * Given a binary tree, you need to compute the length of the diameter of the tree. The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.
 *
 * Example:
 * Given a binary tree
 *           1
 *          / \
 *         2   3
 *        / \
 *       4   5
 * Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].
 *
 * Note: The length of path between two nodes is represented by the number of edges between them.
 */

public class DiameterOfTree {

	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	static int diameterOfBinaryTree(TreeNode root) {
		if (root == null) {
			return 0;
		}
		return 0;
	}

	static int[] heightDiameter(TreeNode root) {
		if (root == null) {
			return new int[] {0,0};
		}
		int[] leftOutput = heightDiameter(root.left);
		int[] rightOutput = heightDiameter(root.right);
		int height = 1 + Math.max(leftOutput[0], rightOutput[0]);
		int diameter = Math.max((leftOutput[0] + rightOutput[0]), (Math.max(leftOutput[1], rightOutput[1])));
		return new int[] {height, diameter};
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(4);
		root.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);
		root.right.right.right = new TreeNode(8);
		root.right.right.right.right = new TreeNode(9);

		System.out.println(heightDiameter(root)[1]);
	}
}