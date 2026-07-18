/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
         Node temp=head;
        while(temp!=null){
            Node newNode=new Node(temp.val);
            newNode.next=temp.next;
            temp.next=newNode;
            temp=temp.next.next;
        }

        //connect the random pointers
        temp=head;
        while(temp!=null){
            if(temp.random!=null){
                temp.next.random=temp.random.next;
                
            }
            temp=temp.next.next;
        }

        //now connect the next pointers properly and remove the existing pointers 

        Node dummy=new Node(-1);
        Node simple=dummy;
        temp=head;
        while(temp!=null){
            simple.next=temp.next;
            temp.next=temp.next.next;
            simple=simple.next;
            temp=temp.next;
        }
        return dummy.next;
    }
}
