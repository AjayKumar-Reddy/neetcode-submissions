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
    int ans;
    public int maxPathSum(TreeNode root) {
        ans=Integer.MIN_VALUE;
        dfs(root);
        return ans;
    }

    private int dfs(TreeNode root){
        if(root==null) return 0;

        int l=dfs(root.left);
        int r=dfs(root.right);
        l=Math.max(0,l);
        r=Math.max(0,r);
        int total=root.val+l+r;
        ans=Math.max(ans,total);
        return root.val+Math.max(l,r);
    }
}
