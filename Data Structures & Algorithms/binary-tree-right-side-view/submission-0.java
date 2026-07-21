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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans=new ArrayList<>();
        modifiedPreorder(root,ans,0);
        return ans;
    }
    private void modifiedPreorder(TreeNode root,List<Integer> ans,int level){
        if(root==null) return ;
        if(ans.size()==level) ans.add(root.val);


        if(root.right!=null) modifiedPreorder(root.right,ans,level+1);
        if(root.left!=null) modifiedPreorder(root.left,ans,level+1);
    }
}
