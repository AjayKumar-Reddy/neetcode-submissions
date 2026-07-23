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

public class Codec {
    int indx;

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        ArrayList<String> list=new ArrayList<>();
        preorder(root,list);
        return String.join(",",list);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] arr=data.split(",");
        indx=0;
        return build(arr);


    }

    private TreeNode build(String[] arr){
        if(indx==arr.length) return null;;
        if(arr[indx].equals("N")) {
            indx++;
            return null;
        }

        TreeNode node=new TreeNode(Integer.parseInt(arr[indx++]));
        node.left=build(arr);
        node.right=build(arr);
        return node;
    }

    private void preorder(TreeNode root,ArrayList<String> list){
        if(root==null){
            list.add("N");
            return;
        }

        list.add(String.valueOf(root.val));
        preorder(root.left,list);
        preorder(root.right,list);

    }
}
