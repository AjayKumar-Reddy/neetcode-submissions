/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        HashMap<Node,Node> map=new HashMap<>();
        if(node==null) return node;
        dfs(node,map);
        return map.get(node);

    }

    private void dfs(Node node,HashMap<Node,Node> map){
        if(map.containsKey(node)) return;
        
        Node newNode=new Node(node.val);
        map.put(node,newNode);
        ArrayList<Node> list=new ArrayList<>();
        for(Node val:node.neighbors){
            dfs(val,map);
            if(map.containsKey(val)){
                list.add(map.get(val));
            } 
        }
        newNode.neighbors=list;
    }
}