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
    public TreeNode invertTree(TreeNode root) {
        Deque<TreeNode> queue=new ArrayDeque<>();
        if(root==null) return null;
        queue.addLast(root);
        while(!queue.isEmpty()){
            int len=queue.size();
            
            for(int i=0;i<len;i++){
                TreeNode curr=queue.pollFirst();
                TreeNode temp=curr.left;
                curr.left=curr.right;
                curr.right=temp;
                
                if(curr.left!=null){
                    queue.offerLast(curr.left);
                }
                if(curr.right!=null){
                    queue.offerLast(curr.right);
                }
                
                

            }

            

        }
        return root;
    }
}
