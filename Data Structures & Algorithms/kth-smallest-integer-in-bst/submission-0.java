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
    public int kthSmallest(TreeNode root, int k) {
        int[] n=new int[1];
        n[0]=k;
        return helper(root,n);
    }

    private int helper(TreeNode root,int[] k){
        if(root==null) return -1;

        int l=helper(root.left,k);
        if(l!=-1) return l;
        k[0]--;
        if(k[0]==0) return root.val;
        return helper(root.right,k);
    }
}
