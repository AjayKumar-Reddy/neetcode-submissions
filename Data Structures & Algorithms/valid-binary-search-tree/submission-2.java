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
    public boolean isValidBST(TreeNode root) {
        return isCheck(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
        

    }
    private boolean isCheck(TreeNode root,int left,int right){
        if(root==null) return true;
        if(root.val>=right || root.val<=left) return false;

        if(!isCheck(root.left,left,root.val)) return false;
        return isCheck(root.right,root.val,right);
    }
}
