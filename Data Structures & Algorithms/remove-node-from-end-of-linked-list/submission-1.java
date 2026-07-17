/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int n1=0;
        ListNode temp=head;
        while(temp!=null){
            n1++;
            temp=temp.next;
        }

        n1=n1-n;
        ListNode prev=null;
        temp=head;
        while(n1>0){
            prev=temp;
            temp=temp.next;
            n1--;
        }
        if(prev==null) return temp.next;
        prev.next=temp.next;
        return head;
    }
}
