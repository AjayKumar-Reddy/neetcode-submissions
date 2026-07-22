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
    private int ans;

    public int kthSmallest(TreeNode root, int k) {
        inorder(root, new int[]{k});
        return ans;
    }

    private void inorder(TreeNode root, int[] k) {
        if (root == null) return;

        inorder(root.left, k);

        if (--k[0] == 0) {
            ans = root.val;
            return;
        }

        inorder(root.right, k);
    }
}
