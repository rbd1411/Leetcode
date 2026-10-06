/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    int maxDepth = 0;

    // First DFS: compute maximum depth
    public void findDepth(TreeNode root, int depth) {
        if (root == null) return;

        maxDepth = Math.max(maxDepth, depth);
        findDepth(root.left, depth + 1);
        findDepth(root.right, depth + 1);
    }

    // Second DFS: find LCA of deepest leaves
    public TreeNode lca(TreeNode root, int depth) {
        if (root == null) return null;

        if (depth == maxDepth) return root;

        TreeNode left = lca(root.left, depth + 1);
        TreeNode right = lca(root.right, depth + 1);

        if (left != null && right != null) return root;
        if (left != null) return left;
        return right;
    }

    public TreeNode lcaDeepestLeaves(TreeNode root) {
        findDepth(root, 0);
        return lca(root, 0);
    }
}