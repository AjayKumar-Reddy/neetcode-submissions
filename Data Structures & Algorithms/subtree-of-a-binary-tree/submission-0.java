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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        Deque<TreeNode> queue=new ArrayDeque<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            int n=queue.size();
            for(int i=0;i<n;i++){
                TreeNode node=queue.pollFirst();
                if(node.val==subRoot.val){
                    if(sameTree(node,subRoot)) return true;
                }
                if(node.left!=null) queue.offer(node.left);
                if(node.right!=null) queue.offer(node.right);
            }
        }
        return false;
    }

    private boolean sameTree(TreeNode p,TreeNode q){
        if(p==null && q==null) return true;
        if(p!=null && q==null || p==null && q!=null) return false;
        if(p.val != q.val) return false;

        if(!sameTree(p.left,q.left)) return false;
        return sameTree(p.right,q.right);
    }
}
