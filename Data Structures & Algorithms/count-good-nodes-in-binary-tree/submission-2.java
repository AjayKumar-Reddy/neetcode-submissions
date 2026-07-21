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
    public int goodNodes(TreeNode root) {
        int[] count=new int[1];
        preorder(root,Integer.MIN_VALUE,count);
        return count[0];
    }

    private void preorder(TreeNode root,int maxi,int[] count){
        if(root==null) return ;

        if(root.val>=maxi){
            count[0]++;
            maxi=root.val;
        }

        preorder(root.left,maxi,count);
        preorder(root.right,maxi,count);
    }
}
