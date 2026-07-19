class Node{
    int key;
    int val;
    Node next;
    Node prev;
    public Node(int key,int val,Node next,Node prev){
        this.key=key;
        this.val=val;
        this.next=next;
        this.prev=prev;
    }
}

class LRUCache {
    HashMap<Integer,Node> map;
    int capacity;
    Node head=new Node(-1,-1,null,null);
    Node tail=new Node(-1,-1,null,null);

    public LRUCache(int capacity) {
        this.capacity=capacity;
        this.map=new HashMap<>();
        this.head.next=tail;
        this.tail.prev=head;
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
            delete(map.get(key));
            insert(map.get(key));
            return map.get(key).val;
        } else {
            return -1;
        }
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            delete(map.get(key));
            map.remove(key);
        }
        if(map.size()==capacity){
            map.remove(tail.prev.key);
            delete(tail.prev);
            
        }
        Node node=new Node(key,value,null,null);
        insert(node);
        map.put(key,node);
    }

    private void insert(Node newNode){
        
        Node oldNext=head.next;
        head.next=newNode;
        newNode.next=oldNext;
        newNode.prev=head;
        oldNext.prev=newNode;
    }

    private void delete(Node node){
        Node next=node.next;
        Node prev=node.prev;
        prev.next=next;
        next.prev=prev;
    }
}
